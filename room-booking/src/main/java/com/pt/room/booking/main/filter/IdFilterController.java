/**
 * 
 */
package com.pt.room.booking.main.filter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.pt.room.booking.main.entity.DynamicUserFilterBean;
import com.pt.room.booking.main.entity.UserFilterBean;

/**
 * @author SAMARESH
 *
 */
@RestController
public class IdFilterController {

	@GetMapping("/filter")
	public UserFilterBean filterUser() {
		return new UserFilterBean(1001, "Samaresh", LocalDate.now().toString());
	}

	@GetMapping("/filtering-list")
	public List<UserFilterBean> retrieveListOfUsers() {
		return Arrays.asList(new UserFilterBean(1002, "Bharat", LocalDate.now().toString()),
				new UserFilterBean(1003, "Ramesh", LocalDate.now().toString()));
	}

	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue retrieveDynamicListOfUsers() {
		List<DynamicUserFilterBean> lstObj = Arrays.asList(
				new DynamicUserFilterBean(1002, "Bharat", LocalDate.now().toString()),
				new DynamicUserFilterBean(1003, "Ramesh", LocalDate.now().toString()));
//		DynamicUserFilterBean obj = new DynamicUserFilterBean(1002, "Bharat", LocalDate.now().toString());
		SimpleBeanPropertyFilter simpleFilter = SimpleBeanPropertyFilter.filterOutAllExcept("username", "dob");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicUserFilter", simpleFilter);
		MappingJacksonValue mappings = new MappingJacksonValue(lstObj);
		mappings.setFilters(filters);
		return mappings;
	}

	@GetMapping("/dynamic-filtering-list2")
	public MappingJacksonValue retrieveDynamicListOfUsers2() {
		List<DynamicUserFilterBean> lstObj = Arrays.asList(
				new DynamicUserFilterBean(1002, "Bharat", LocalDate.now().toString()),
				new DynamicUserFilterBean(1003, "Ramesh", LocalDate.now().toString()));
		SimpleBeanPropertyFilter simpleFilter = SimpleBeanPropertyFilter.filterOutAllExcept("username");
		FilterProvider filters = new SimpleFilterProvider().addFilter("DynamicUserFilter", simpleFilter);
		MappingJacksonValue mappings = new MappingJacksonValue(lstObj);
		mappings.setFilters(filters);
		return mappings;
	}

}
