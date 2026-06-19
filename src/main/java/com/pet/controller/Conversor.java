package com.pet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Conversor {

	@GetMapping("/bin2dec")
	public String bin2dec() {
		return "10";
	}
	
}
