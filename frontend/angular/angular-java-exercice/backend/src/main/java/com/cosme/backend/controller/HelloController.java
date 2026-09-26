package com.cosme.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api")
public class HelloController {
  public record Greeting(String message) {};
  
  @GetMapping("/hello")
  public Greeting hello() {
    return new Greeting ("Hello from Spring!");
  }

  @GetMapping("/saludo/{name}/{edad}")
  public Greeting saludo(@PathVariable String name, @PathVariable int edad) {
    return new Greeting("Hello from spring, " + name + " your age is " + edad);
  }
}
