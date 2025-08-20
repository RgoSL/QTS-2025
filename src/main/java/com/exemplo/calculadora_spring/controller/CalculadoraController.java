// Essa é a Classe responsável por expor os endpoints da API Calculadora
package com.exemplo.calculadora_spring.controller; 

import com.exemplo.calculadora_spring.service.CalculadoraService; // Importa o pacote que contém a lógica da calculadora
import org.springframework.beans.factory.annotation.Autowired; // Permite o uso automático de dependências
import org.springframework.web.bind.annotation.*; // Importa anotações para criar endpoints REST
import org.springframework.web.bind.annotation.GetMapping; // Especifica o tipo de captura dos endpoints como HTTP GET
import org.springframework.web.bind.annotation.RequestParam; // Captura parâmetros passados na URL

// Define que esta classe será um controlador REST, retornando valores de forma direta
@RestController // Indica que a classe é um controller REST
@RequestMapping("/api/calculadora") // Define um caminho base para endpoints nesta classe

// Essa classe recebe requisições e chama os métodos do service
public class CalculadoraController {
    
    @Autowired // Marca automaticamente a instância da CalculadoraService no controller
    // Classe privada responsável pela lógica de cálculo
    private CalculadoraService calculadoraService;

    // Endpoint de soma
    @GetMapping("/somar") // Define que este método será chamado em uma requisição GET
    public Double somar(@RequestParam double a, @RequestParam double b) {
        return calculadoraService.somar(a, b);
    }
    
    // Endpoint de subtração
    @GetMapping("/subtrair") 
    public Double subtrair(@RequestParam double a, @RequestParam double b) {
        return calculadoraService.subtrair(a, b);
    }

    // Endpoint de multiplicação
    @GetMapping("/multiplicar") 
    public Double multiplicar(@RequestParam double a, @RequestParam double b) {
        return calculadoraService.multiplicar(a, b);
    }

    // Endpoint de divisões
    @GetMapping("/dividir") 
    public Double dividir(@RequestParam double a, @RequestParam double b) {
        return calculadoraService.dividir(a, b);
    }
}