package com.spring.revision.Revision;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RevisionApplication implements CommandLineRunner {

	@Autowired
	Person person;

	public static void main(String[] args) {
		SpringApplication.run(RevisionApplication.class, args);
	}

	public void run(String... args) throws Exception {
		person.displayName();
	}
}
