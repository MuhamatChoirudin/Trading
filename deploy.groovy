pipeline{
  environment {
    registry = "rafie/wallx"
    registryCredential = 'dockerhub'
    dockerImage = ''
  }
  agent any
  stages {
    stage('Deploy and Run App') {
      steps{
        sshagent(credentials : ['543699f1-e549-4e48-b3db-7ab4456ee495']) {
            sh 'ssh -o StrictHostKeyChecking=no root@104.248.147.193 "docker stop walletx || true  && docker container rm walletx || true"'
            sh 'ssh -o StrictHostKeyChecking=no root@104.248.147.193 "docker pull $registry || true"'
            sh 'ssh -o StrictHostKeyChecking=no root@104.248.147.193 "mkdir -p /apps/wallet-x"'
            sh 'scp -o StrictHostKeyChecking=no deploy/dev.env root@104.248.147.193:/apps/wallet-x/app.env'
            sh 'ssh -o StrictHostKeyChecking=no root@104.248.147.193 "cd /apps/wallet-c && docker run -p 8180:8180 -d --env-file=app.env --name=walletx $registry"'
        }
      }
    }
  }
}
