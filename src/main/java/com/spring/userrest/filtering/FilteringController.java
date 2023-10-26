package com.spring.userrest.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilteringController {
	
	@GetMapping("/filtering")
	public SomeBean retrieveSomeBean() {
		return new SomeBean("V1","V2","V3");
	}
	
	@GetMapping("/filtering-list")
	public List<SomeBean> retrieveListOfSomeBean() {
		return Arrays.asList(new SomeBean("V1","V2","V3"),new SomeBean("V1","V2","V3"));
	}
}
