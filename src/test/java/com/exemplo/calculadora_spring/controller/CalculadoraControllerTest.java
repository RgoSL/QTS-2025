// Essa Classe testa e valida os endpoints da CalculadoraController
package com.exemplo.calculadora_spring.controller;

import com.exemplo.calculadora_spring.service.CalculadoraService; // Importa o service que será simulado nos testes
import org.junit.jupiter.api.Test; // Marca métodos como testes
import org.springframework.beans.factory.annotation.Autowired; // Aplica dependências de forma automâtica nos testes
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; // Configura o ambiente de teste apenas para a camada Web
import org.springframework.test.context.bean.override.mockito.MockitoBean; // Permite criar beans simulados com Mockito
import org.springframework.test.web.servlet.MockMvc; // Módulo usado para simular requisições HTTP e testar endpoints sem rodar o servidor

import static org.mockito.Mockito.when; // Define o comportamento esperado de um mock
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get; // Cria simulações de requisições GET
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*; // Verifica respostas de status e conteúdo

@WebMvcTest(CalculadoraController.class) // Configura o teste para carregar apenas o CalculadoraController e seus componentes relacionados

// Classe de teste para os endpoints do CalculadoraController
class CalculadoraControllerTest {

    // Simula requisições HTTP contra os endpoints
    @Autowired // Aplica automaticamente o objeto mockMvc no teste
    private MockMvc mockMvc; // Responsável por executar chamadas simuladas à API

    // Simula o comportamento do service durante os testes
    @MockitoBean // Cria um mock de CalculadoraService e aplica ele no controller
    private CalculadoraService calculadoraService; // Service que será simulado nos testes

    // Testa o endpoint de soma
    @Test // Marca este método como teste
    void testSom() throws Exception { //
        when(calculadoraService.somar(5, 3)).thenReturn(8.0); // Define o que será retornado ao utilizar estes números

        // Simula uma requisição GET ao endpoint da soma
        mockMvc.perform(get("/api/calculadora/somar") // Cria uma requisição GET para o endpoint
            .param("a", "5") // Passa o "a" como parâmetro e da a ele 5 como valor
            .param("b", "3")) // Passa o parâmetro "b" com valor 3
            .andExpect(status().isOk()) // Verifica se a resposta HTTP deu certo
            .andExpect(content().string("8.0")); // Verifica se o conteúdo da resposta é exatamente "8.0"
    }

    // Testa o endpoint de subtração
    @Test
    void testSub() throws Exception {
        when(calculadoraService.subtrair(10, 4)).thenReturn(6.0);

        mockMvc.perform(get("/api/calculadora/subtrair")
        .param("a", "10")
        .param("b", "4"))
        .andExpect(status().isOk())
        .andExpect(content().string("6.0"));
    }
}