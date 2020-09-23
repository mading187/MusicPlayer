package com.mading;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.mading.dao")
class MusicApplicationTests {
	public static void main(String[] args) {
		SpringApplication.run(MusicApplication.class , args);
	}

}
