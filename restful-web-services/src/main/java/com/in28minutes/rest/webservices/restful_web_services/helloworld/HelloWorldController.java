package com.in28minutes.rest.webservices.restful_web_services.helloworld;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping(method = RequestMethod.GET, path ="/hello-world")
	public String HelloWorld() {
		return "Hello World";
	}
	
	@RequestMapping(method = RequestMethod.GET, path ="/hello-world/path-variable/{name}")
	public HelloWorldBean HelloWorldPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello world, %s ", name));
	}
}
