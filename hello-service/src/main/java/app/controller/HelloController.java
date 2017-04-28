package app.controller;

import app.client.Level2HelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bm on 17.04.2017.
 */
@RestController
public class HelloController {

	@Autowired
	private Level2HelloClient level2HelloClient;


	@GetMapping(value = "/ghostbusters")
	public List<String> available() {

//		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		List<String> movies = new ArrayList<>();
		movies.add("Ghostbusters (1984)");
		movies.add("Ghostbusters (2016)");
		return movies;
	}

	@GetMapping("call-another-hello")
	public String callHello() {
		return "this is first level hello that includes also second level hello: " + level2HelloClient.giveMeLevel2Hello();
	}

	@GetMapping(value = "/hello")
	public String hello() {
		return "this is basic hello.";
	}
}
