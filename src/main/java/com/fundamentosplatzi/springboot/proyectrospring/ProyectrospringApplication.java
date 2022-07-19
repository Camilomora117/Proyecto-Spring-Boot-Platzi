package com.fundamentosplatzi.springboot.proyectrospring;

import com.fundamentosplatzi.springboot.proyectrospring.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectrospringApplication implements CommandLineRunner {

	//Inyeccion
	private ComponentDependency componentDependency;

	public ProyectrospringApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency) {
		this.componentDependency = componentDependency;
	}

	public static void main(String[] args) {
		SpringApplication.run(ProyectrospringApplication.class, args);
	}

	@Override
	public void run(String... args) {
		componentDependency.saludar();
	}

}
