---
criação: 2025-08-06
atualização: 2025-08-06
tags:
  - etec
  - aula
  - programação
  - java
  - junit
descrição curta: 
referências:
  - "[[03 - Trabalho/ETEC/1 - Conteúdos/Desenvolvimento de Sistemas/Java|Java]]"
---
# TDD

TDD (Test-Driven Development) é uma metodologia de desenvolvimento onde você escreve os testes ANTES do código de produção.
## Ciclo Red-Green-Refactor

O TDD segue um ciclo de 3 etapas:
1. **🔴 RED**: Escreva um teste que falha
2. **🟢 GREEN**: Escreva o mínimo de código para o teste passar
3. **🟡 REFACTOR**: Melhore o código mantendo os testes passando
## Vantagens do TDD

- **Código mais confiável** - 100% coberto por testes
- **Design melhor** - testes forçam código mais limpo
- **Menos bugs** - problemas descobertos cedo
- **Refatoração segura** - testes garantem que nada quebrou
- **Documentação viva** - testes mostram como usar o código
# Configuração do ambiente

## Java
Necessário ter o JDK do Java instalado na máquina

### Links
**JDK:** https://adoptium.net/pt-BR/temurin/releases

## VS Code

Ter o Visual Studio Code e os pacotes de extensões necessárias para trabalhar com o Java e Spring Boot.
Depois de instalar o VS Code, você encontra os pacotes de extensões no menu `Extensões` do VS Code.

![[Pasted image 20250806141508.png]]

VS Code: https://code.visualstudio.com/

# Criando o projeto

## Opção 1: Via Command Palette (Ctrl+Shift+P)

1. Digite "Spring Initializr: Create a Maven Project"
2. Selecione a versão do Spring Boot
3. Linguagem: Java
4. Group Id: `com.exemplo`
5. Artifact Id: `calculadora-api`
6. Packaging Type: Jar
7. Java Version: 17 ou superior
8. Dependências:
    - Spring Web
    - Spring Boot DevTools
## Opção 2: Via [https://start.spring.io](https://start.spring.io)

1. Acesse start.spring.io
2. Configure:
    - Project: Maven
    - Language: Java
    - Spring Boot: 3.2.x
    - Group: com.exemplo
    - Artifact: calculadora-api
    - Packaging: Jar
    - Java: 17
3. Adicione dependências: Spring Web, DevTools, Test
4. Generate e extraia o ZIP

# Estrutura do projeto

calculadoraapi/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── exemplo/
│   │   │           └── calculadoraapi/
│   │   │               ├── CalculadoraApiApplication.java
│   │   │               ├── controller/
│   │   │               │   └── CalculadoraController.java
│   │   │               └── service/
│   │   │                   └── CalculadoraService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── com/
│               └── exemplo/
│                   └── calculadoraapi/
│                       ├── controller/
│                       │   └── CalculadoraControllerTest.java
│                       └── service/
│                           └── CalculadoraServiceTest.java
├── target/
├── .gitignore
├── pom.xml
└── README.md

# Código da Aplicação

## Classe Principal (CalculadoraApiApplication.java)

```java
package com.exemplo.calculadoraapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CalculadoraApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CalculadoraApiApplication.class, args);
    }
}
```

## Service (CalculadoraService.java)

```java
package com.exemplo.calculadoraapi.service;

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
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida");
        }
        return a / b;
    }
}
```

## Controller (CalculadoraController.java)

```java
package com.exemplo.calculadoraapi.controller;

import com.exemplo.calculadoraapi.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {
    
    @Autowired
    private CalculadoraService calculadoraService;
    
    @GetMapping("/somar")
    public double somar(@RequestParam double a, @RequestParam double b) {
        return calculadoraService.somar(a, b);
    }
    
    @GetMapping("/subtrair")
    public double subtrair(@RequestParam double a, @RequestParam double b) {
        return calculadoraService.subtrair(a, b);
    }
    
    @GetMapping("/multiplicar")
    public double multiplicar(@RequestParam double a, @RequestParam double b) {
        return calculadoraService.multiplicar(a, b);
    }
    
    @GetMapping("/dividir")
    public double dividir(@RequestParam double a, @RequestParam double b) {
        return calculadoraService.dividir(a, b);
    }
}
```

## Testes

### Teste do Service (CalculadoraServiceTest.java)

```java
package com.exemplo.calculadoraapi.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraServiceTest {
    
    private CalculadoraService calculadoraService;
    
    @BeforeEach
    void setUp() {
        calculadoraService = new CalculadoraService();
    }
    
    @Test
    void testSomar() {
        double resultado = calculadoraService.somar(5, 3);
        assertEquals(8, resultado);
    }
    
    @Test
    void testSubtrair() {
        double resultado = calculadoraService.subtrair(10, 4);
        assertEquals(6, resultado);
    }
    
    @Test
    void testMultiplicar() {
        double resultado = calculadoraService.multiplicar(6, 7);
        assertEquals(42, resultado);
    }
    
    @Test
    void testDividir() {
        double resultado = calculadoraService.dividir(15, 3);
        assertEquals(5, resultado);
    }
    
    @Test
    void testDividirPorZero() {
        assertThrows(IllegalArgumentException.class, () -> {
            calculadoraService.dividir(10, 0);
        });
    }
}
```

### Teste do Controller (CalculadoraControllerTest.java)

```java
package com.exemplo.calculadoraapi.controller;

import com.exemplo.calculadoraapi.service.CalculadoraService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CalculadoraController.class)
class CalculadoraControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @MockitoBean
    private CalculadoraService calculadoraService;
    
    @Test
    void testSomar() throws Exception {
        when(calculadoraService.somar(5, 3)).thenReturn(8.0);
        
        mockMvc.perform(get("/api/calculadora/somar")
                .param("a", "5")
                .param("b", "3"))
                .andExpect(status().isOk())
                .andExpect(content().string("8.0"));
    }
    
    @Test
    void testSubtrair() throws Exception {
        when(calculadoraService.subtrair(10, 4)).thenReturn(6.0);
        
        mockMvc.perform(get("/api/calculadora/subtrair")
                .param("a", "10")
                .param("b", "4"))
                .andExpect(status().isOk())
                .andExpect(content().string("6.0"));
    }
}
```

# Executar Testes

1. **Via Command Palette:** Ctrl+Shift+P → "Java: Run Tests"
2. **Via Explorer:** Clique no ícone de teste na barra lateral
3. **Via Terminal:** `./mvnw test`
4. **Teste Individual:** Clique no ícone "Run Test" acima de cada método de teste

# Testando a API

Com a aplicação rodando, teste os endpoints:

- GET `http://localhost:8080/api/calculadora/somar?a=5&b=3`
- GET `http://localhost:8080/api/calculadora/subtrair?a=10&b=4`
- GET `http://localhost:8080/api/calculadora/multiplicar?a=6&b=7`
- GET `http://localhost:8080/api/calculadora/dividir?a=15&b=3`