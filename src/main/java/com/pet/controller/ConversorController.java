package com.pet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pet.service.ConversorService;

@RestController
public class ConversorController {

	@Autowired
	private ConversorService service;
	
	@GetMapping(value = {"/bin2dec/{binario}", "/bin2dec/"})
	public ResponseEntity<String> bin2dec(@PathVariable(required = false) String binario) {
		
		if(binario == null || binario.isBlank()) {
			return ResponseEntity.badRequest().body("O valor informado não pode ser nulo ou vazio");
		}
		
		if(!binario.matches("[01]+")) {
			return ResponseEntity.badRequest().body("O valor informado não é um número binário válido");
		}
		
		return ResponseEntity.ok("Valor convertido para decimal é "+service.bin2dec(binario));
		
	}
	
}


/*
@Autowired
	
	
	@GetMapping("/bin2dec/{binario}")
	
 
 
 
 int decimal = 0;
		int expoente = 0;
		int contador = binario.length();
		
		while(contador > 0) {
			//1001
			int numero = Integer.parseInt(binario.substring(contador-1, contador));
			// somar com decimal
			decimal = decimal + (int)(numero*Math.pow(2, expoente));
			
			expoente = expoente + 1;
			contador = contador - 1;
		}
		
		return decimal;
*/
