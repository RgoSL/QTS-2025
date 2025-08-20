// Nessa Classe são realizados os testes para validar os métodos da CalculadoraService
package com.exemplo.calculadora_spring.service; 

import org.junit.jupiter.api.BeforeEach; // Executa um método antes de cada teste
import org.junit.jupiter.api.Test; // Marca um método como caso de teste
import static org.junit.jupiter.api.Assertions.*; // Importa métodos de validação

// Classe para testes unitários da CalculadoraService
public class CalculadoraServiceTest {

    // Instância da classe que será testada
    private CalculadoraService calculadoraService;

    // Executa antes de cada teste, inicializando a CalculadoraService
    @BeforeEach // Configurações executadas antes de cada método teste
    void setUp() {
        calculadoraService = new CalculadoraService();
    }

    // Testa o método de soma
    @Test // Indica que este método é um teste
    void testSom() {
        double resultado = calculadoraService.somar(5, 3);
        assertEquals(8, resultado); // Método de validação que verifica se o resultado retornado é igual a 8
    }
    
    // Testa o método de subtração
    @Test 
    void testSub() {
        double resultado = calculadoraService.subtrair(10, 4);
        assertEquals(6, resultado);
    }

    // Testa o método de multiplicação
    @Test 
    void testMult() {
        double resultado = calculadoraService.multiplicar(6, 7);
        assertEquals(42, resultado);
    }

    // Testa o método de divisão
    @Test 
    void testDiv() {
        double resultado = calculadoraService.dividir(15, 3);
        assertEquals(5, resultado);
    }

    // Testa a exceção lançada ao tentar dividir por zero
    @Test 
    void testDiv0() {
        assertThrows(IllegalArgumentException.class, () -> { // Verifica se essa exceção é ativada quando ocorre uma divisão por zero
            calculadoraService.dividir(10, 0);
        });
    }
}