package com.calculadora.calculadoraapi.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {
    public double somar(double a, double b) {
        return a + b;
    }
    public double subtrair(double a, double b) {
        return a - b;
    }
        public double multiplicar(double a, double b) {
        return a * b;
    }
        public double dividir(double a, double b) {
            if (b==0){
                throw new IllegalArgumentException("SEU FODIDO, SEM DIVISAO POR ZERO")
            }
            return a / b;
        }
}