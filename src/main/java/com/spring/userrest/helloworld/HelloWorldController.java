package com.spring.userrest.helloworld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/hello")
	public String a() {
		return "Hi";
	}

	@GetMapping("/hellobean")
	public HelloBean hellobean(String message) {
		return new HelloBean("abc");
	}

	@GetMapping("/path/{msg}")
	public HelloBean hellobeanpath(@PathVariable String msg) {
		return new HelloBean(String.format("path = %s", msg));
	}

	@GetMapping("/internationalization")
	public String helloInternat(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}

}
