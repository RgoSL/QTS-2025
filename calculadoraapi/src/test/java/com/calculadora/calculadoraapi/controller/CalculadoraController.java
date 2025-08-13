package com.calculadora.calculadoraapi.controller;


import com.calculadora.calculadoraapi.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculadora")
public class CalculadoraController {
    @Autowired
    private CalculadoraService calculadoraService;

    @GetMappgin("/somar")
    public double somar(@RequestParam double a, @RequestParam double b){
        return calculadoraService.somar(a,b);
    }


@GetMapping("/subtrair")
public double subtrair(@RequestParam double a, @RequestParam double b){
 return calculadoraService.subtrair(a,b);
}

@GetMapping("/multiplicar")
public double multiplicar(@RequestParam double a, @RequestParam double b){
     return calculadoraService.multiplicar(a,b);
}

@GetMapping("/dividir")
public double dividir(@RequestParam double a, @RequestParam double b){
     return calculadoraService.dividir(a,b);
    }
}
