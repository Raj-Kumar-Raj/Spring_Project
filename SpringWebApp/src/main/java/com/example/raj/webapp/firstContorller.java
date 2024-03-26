package com.example.raj.webapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class firstContorller {
	
@GetMapping()
public String getHelloWorldSpring() {
	return "Spring home page ";
}

@GetMapping("search")
public String getHelloWorld() {
	return "Hello world";
}
@GetMapping("searching")
public String searching(@RequestParam(name = "nameReqParam")String value) {
	return value ;
}

@GetMapping("searchingpath/{raj}")
public String searchingPathVariable(@PathVariable(name = "raj")String value) {
	return value ;
}
@PostMapping(path ="post")
public void postkaro() {
	System.out.println("runing post");
}
}
