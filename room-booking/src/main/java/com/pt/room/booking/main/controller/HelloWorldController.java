/**
 * 
 */
package com.pt.room.booking.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pt.room.booking.main.entity.HelloWorldBean;

/**
 * @author SAMARESH
 *
 */
@RestController
public class HelloWorldController {

	@GetMapping( path = "/hello-world")
	public String sayHelloWorld() {
		return "Hello World";
	}
	
	@GetMapping( path = "/hello-world-bean")
	public HelloWorldBean sayHelloWorldBean() {
		return new HelloWorldBean("Hello World");
	}
	
	@GetMapping( path = "/hello-world-bean/path-variable/{name}")
	public HelloWorldBean sayHelloPathVariable(@PathVariable String name) {
		return new HelloWorldBean("Hello "+name);
	}
}
