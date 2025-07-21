package com.AliceAndHerBakery.CakeBaker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CakeBakerApplication implements CommandLineRunner {

	@Autowired
	CakeBaker cakeBaker;

	public static void main(String[] args) {
		SpringApplication.run(CakeBakerApplication.class, args);
	}

	public void run(String... args) throws Exception {
		cakeBaker.bakeCake();
	}
}
