package com.cg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={
"com.cg.controller","com.cg.service"})
public class NoteData1Application {

	public static void main(String[] args) {
		SpringApplication.run(NoteData1Application.class, args);
	}

}
