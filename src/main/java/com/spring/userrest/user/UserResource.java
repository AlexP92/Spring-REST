package com.spring.userrest.user;

import java.net.URI;

import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import org.springframework.hateoas.*;







@RestController
@RequestMapping("/users")
public class UserResource {

	@Autowired
	private UserDAO userService;

	@GetMapping
	public List<User> getUsers() {
		return userService.findAll();
	}

	@GetMapping("/{id}")
	public EntityModel<User> getUser(@PathVariable int id) {
		User user = userService.findOne(id);
		if(user==null)
			throw new UserNotFoundException("id - "+id);
		
		//HATEOAS // Hypermedia as the engine of application state (HATEOAS) 
		//is a constraint of the REST application architecture that distinguishes it 
		//from other network application architectures. 
		

        // Create a link to retrieve all users
        Link allUsersLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(UserResource.class).getUsers()).withRel("all-users");

        // Create the EntityModel with the user and links
        EntityModel<User> userEntityModel = EntityModel.of(user, allUsersLink);

        return userEntityModel;
	}

	@PostMapping
	public ResponseEntity<User> saveUser(@Valid @RequestBody User user) {

		User savedUser = userService.add(user);

		// 201 created response
		URI location = ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("{/id}")
				.buildAndExpand(savedUser.getId())
				.toUri();

		
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable int id) {
		User user=userService.deleteById(id);
		if(user==null)
			throw new UserNotFoundException("User id = "+id+" not found");
		
	}

}
