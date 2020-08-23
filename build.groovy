pipeline{
  environment {
    registry = "mofino/wallx"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Checkout Source') {
      steps{
        script {
          checkout scm: [$class: 'GitSCM', userRemoteConfigs: [[credentialsId: 'gitlab',url: env.gitlabSourceRepoHttpUrl]], branches: [[name: env.gitlabSourceBranch]]], poll: false
        }
      }
    }
    stage('Build artifact') {
      steps{
        sh "mvn clean install -Dliquibase.should.run=false"
      	sh "mvn sonar:sonar -Dsonar.projectKey=walletx-backend -Dsonar.host.url=http://159.89.227.122:9000"	      
}
    }
    stage('Build Image') {
      steps{
        script {
          dockerImage = docker.build registry + ":$BUILD_NUMBER"
        }
      }
    }
    stage('Tag & Push Image') {
      steps{
        script {
          docker.withRegistry( '', registryCredential ) {
            dockerImage.push()
            dockerImage.push('latest')
          }
        }
      }
    }
    stage('Remove Unused Docker Image') {
      steps{
        sh "docker rmi $registry:$BUILD_NUMBER"
      }
    }
    stage('Deploy and Run App') {
      steps{
        sshagent(credentials : ['543699f1-e549-4e48-b3db-7ab4456ee495']) {
            sh 'ssh -o StrictHostKeyChecking=no root@104.248.147.193 "docker stop walletx || true  && docker container rm wallx || true"'
            sh 'ssh -o StrictHostKeyChecking=no root@104.248.147.193 "docker pull $registry || true"'
            sh 'ssh -o StrictHostKeyChecking=no root@104.248.147.193 "mkdir -p /apps/wallx"'
            sh 'scp -o StrictHostKeyChecking=no wallx.env root@104.248.147.193:/apps/wallx/wallx.env'
            sh 'ssh -o StrictHostKeyChecking=no root@104.248.147.193 "cd /apps/wallx && docker run -p 8070:8070 -d --env-file=wallx.env --name=wallx $registry"'
        }
      }
    }
  }
}
