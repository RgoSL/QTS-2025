// Essa Classe contém a lógica das operações matemáticas da calculadora
package com.exemplo.calculadora_spring.service;

import org.springframework.stereotype.Service; // Marca a classe como um serviço gerenciado pelo Spring Boot

// Define esta classe como um serviço do Spring
@Service // Permite que o Spring controlar as instâncias dessa classe
public class CalculadoraService {

    // Método que realiza a soma de dois números
    public double somar(double a, double b) {
        return a + b;
    }

    // Método que realiza a subtração de dois números
    public double subtrair(double a, double b) {
        return a - b;
    }

    // Método que realiza a multiplicação de dois números
    public double multiplicar(double a, double b) {
        return a * b;
    }

    // Método que realiza a divisão de dois números
    public double dividir(double a, double b) {
        if (b == 0) {
           // Validação para evitar divisão por zero
            throw new IllegalArgumentException("Erro: Divisão por Zero!"); // Ativa uma exceção se o divisor for zero
        }
        return a / b;
    }
}