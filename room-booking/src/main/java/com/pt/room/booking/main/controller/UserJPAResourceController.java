/**
 * 
 */
package com.pt.room.booking.main.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.pt.room.booking.main.entity.User;
import com.pt.room.booking.main.exception.UserNotFoundException;
import com.pt.room.booking.main.service.JPAUserService;
import com.pt.room.booking.main.service.UserService;

/**
 * @author SAMARESH
 *
 */
@RestController
public class UserJPAResourceController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	private JPAUserService service;

	// retrive all user
	@GetMapping(path = "/jpa/users")
	public List<User> retrieveAllUsers() {
		return service.findAll();
	}

	// retrive a particular user
	@GetMapping(path = "/jpa/users/{id}")
	public Resource<User> retriveUser(@PathVariable int id) {
		User user = service.findOne(id);
		if (null == user) {
			throw new UserNotFoundException("id : " + id);
		}
		Resource<User> resource = new Resource<User>(user);
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));
		return resource;
	}

	// save a user
	@PostMapping(path = "/jpa/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
		User savedUser = service.saveUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).body(savedUser);
	}

	@DeleteMapping(path = "/jpa/users/{id}")
	public void deleteById(@PathVariable int id) {
		service.deleteById(id);
	}

	@GetMapping(path = "/jpa/hello-world-internationalized")
	public String helloWorld(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}

	@GetMapping(path = "/jpa/hello-world-internationalized-one")
	public String greet() {
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
}
