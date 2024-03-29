/**
 * 
 */
package com.pt.room.booking.main;

import static java.util.Arrays.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author SAMARESH
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	public static final Contact DEFAULT_CONTACT = new Contact("Samaresh", "www.samsoft.com", "samarshpro@gmail.com");
	public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Awesome Api Documentation", "Detail Api Description",
			"1.0", "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
			new ArrayList<VendorExtension>());
	private static final Set<String> DEFAULT_PRODUCES_AND_CONSUME = new HashSet<String>(
			asList("application/json", "application/xml"));

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(DEFAULT_API_INFO).produces(DEFAULT_PRODUCES_AND_CONSUME)
				.consumes(DEFAULT_PRODUCES_AND_CONSUME);
	}
}
