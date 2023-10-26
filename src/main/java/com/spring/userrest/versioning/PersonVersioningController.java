package com.spring.userrest.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

		
		@GetMapping(value="/person/param",params="version=1")
		public PersonV1 personV1() {
			return new PersonV1("Bob charlie");
		}
		
		@GetMapping(value="/person/param",params="version=2")
		public PersonV2 personV2() {
			return new PersonV2(new Name("Bob" ,"charlie"));
		}
		
		@GetMapping(value="/person/header",headers="version=1")
		public PersonV1 headerV1() {
			return new PersonV1("Bob charlie");
		}
		
		@GetMapping(value="/person/header",headers="version=2")
		public PersonV2 headerV2() {
			return new PersonV2(new Name("Bob" ,"charlie"));
		}
}
