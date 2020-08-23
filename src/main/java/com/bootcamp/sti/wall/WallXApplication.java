package com.bootcamp.sti.wall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.bootcamp.sti.wall.config.BeanConfig;

@EntityScan({"com.bootcamp.sti.wall.model"})
@SpringBootApplication
@Import(BeanConfig.class)
@EnableJpaRepositories("com.bootcamp.sti.wall.repositories")
public class WallXApplication {

	public static void main(String[] args) {
		SpringApplication.run(WallXApplication.class, args);
	}

}
