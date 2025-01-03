package com.in28minutes.rest.webservices.restful_web_services.user;
// import khi sd WebMvcLinkBuilder
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import java.net.URI;
import java.util.List;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.in28minutes.rest.webservices.restful_web_services.jpa.UserRepository;

import jakarta.validation.Valid;

@RestController //dung` de xuy ly cac yeu cau http tra ve JSON hoac XML
public class UserResource {
	
	private UserDaoService service;
	
	
	
	public UserResource(UserDaoService service) {
		super();
		this.service = service;
		
	}
	
	//Get /user
	@GetMapping("/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//EntityModel(193-step22)
	//WebMvcLinkBuilder
	@GetMapping("/users/{id}")
	public EntityModel<User> retrieveUsers(@PathVariable int id){
		User user = service.findOne(id);
		// xu ly ngoai le khi khong tim thay id -> tra ve http 404
		if(user == null)
			throw new UserNotFoundException("id:" + id);
		EntityModel<User> entityModel = EntityModel.of(user);
		
		WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		entityModel.add(link.withRel("all-users"));
		return entityModel;
	}
	
	//Delete /user
	@DeleteMapping("/users/{id}")
	public void deleteUsers(@PathVariable int id){
		service.deleteUser(id);
	}
	
	
	
	//POST /user
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.save(user);
		// tao uri cho nguoi moi duoc tao them
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/id")
				.buildAndExpand(savedUser.getId())
				.toUri();
		
		return ResponseEntity.created(location).build();
		
	}
}
