// Essa é a Classe principal da aplicação, usada para iniciar o Spring Boot
package com.exemplo.calculadora_spring;

import org.springframework.boot.SpringApplication; // Módulo que inicia a execução da aplicação Spring Boot
import org.springframework.boot.autoconfigure.SpringBootApplication; // Habilita a configuração e interpretação automática de componentes

// Define a aplicação como um projeto Spring Boot e habilita suas configurações
@SpringBootApplication // Anotação que marca a classe como ponto de entrada do Spring Boot
public class CalculadoraSpringApplication {
	public static void main(String[] args) {
		// Inicia e roda a aplicação
		SpringApplication.run(CalculadoraSpringApplication.class, args);
	}
}