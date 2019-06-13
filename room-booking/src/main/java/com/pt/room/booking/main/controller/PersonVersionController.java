/**
 * 
 */
package com.pt.room.booking.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pt.room.booking.main.entity.Name;
import com.pt.room.booking.main.version.PersonV1;
import com.pt.room.booking.main.version.PersonV2;

/**
 * @author SAMARESH
 *
 */
@RestController
public class PersonVersionController {

	@GetMapping(path = "/v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Samaresh Pradhan");
	}

	@GetMapping(path = "/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Samaresh", "Pradhan"));
	}

	@GetMapping(path = "/person/param", params = "version=1")
	public PersonV1 getParam1() {
		return new PersonV1("Samaresh Pradhan");
	}

	@GetMapping(path = "/person/param", params = "version=2")
	public PersonV2 getParam2() {
		return new PersonV2(new Name("Samaresh", "Pradhan"));
	}

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 getHeader1() {
		return new PersonV1("Samaresh Pradhan");
	}

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 getHeader2() {
		return new PersonV2(new Name("Samaresh", "Pradhan"));
	}

	@GetMapping(path = "/person/header", produces = "application/vnd.company.app-v1+json")
	public PersonV1 getProduces1() {
		return new PersonV1("Samaresh Pradhan");
	}

	@GetMapping(path = "/person/header", produces = "application/vnd.company.app-v2+json")
	public PersonV2 getProduces2() {
		return new PersonV2(new Name("Samaresh", "Pradhan"));
	}
}
