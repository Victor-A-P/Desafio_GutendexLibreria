package com.UPIICSA.desafioLibreria;

import com.UPIICSA.desafioLibreria.principal.Principal;
import com.UPIICSA.desafioLibreria.repository.AutorRepository;
import com.UPIICSA.desafioLibreria.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DesafioLibreriaApplication implements CommandLineRunner {


	@Autowired
	private AutorRepository autorRepository;
	@Autowired
	private LibroRepository libroRepository;

	public static void main(String[] args) {
		SpringApplication.run(DesafioLibreriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal( autorRepository, libroRepository);
		principal.muestraMenu();
	}
}
