package app.controller;

import app.client.Level2HelloClient;
import app.property.PropertyConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bm on 17.04.2017.
 */
@RestController
public class HelloController {

	private static final Logger logger = LoggerFactory
			.getLogger(HelloController.class);
	@Autowired
	private Level2HelloClient level2HelloClient;

	@Autowired
	private PropertyConfig propertyConfig;

	@GetMapping(value = "/ghostbusters")
	public List<String> available() {

//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		List<String> movies = new ArrayList<>();
		movies.add("Ghostbusters (1984)");
		movies.add("Ghostbusters (2016)");
		return movies;
	}

	@GetMapping("/hi5")
	public String callHello() {
		logger.info("we will call hi5 service now.");
		return "high 5 to you level2 service: " + level2HelloClient.giveMeHigh5();
	}

	@GetMapping(value = "/hello")
	public String hello() {
		return "this is basic hello.";
	}

	@GetMapping(value = "/property-change")
	public String propertyChange() {
		return "this is the value of foo.bar: " + propertyConfig.getBar();
	}


	@GetMapping(value = "/level1-hello")
	public String hello2() {
		logger.info("level1 log called.");
		return "level1 works. calling level2: " + level2HelloClient.hello2();
	}
}
