package com.cosme.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/api")
public class HelloController {
  
  @GetMapping("/hello")
  public String hello() {
    return "Hello from Spring!";
  }

  @GetMapping("/saludo/{name}/{edad}")
  public String saludo(@PathVariable String name, @PathVariable int edad) {
    return "Hello from spring, " + name + " your age is " + edad;
  }
}
