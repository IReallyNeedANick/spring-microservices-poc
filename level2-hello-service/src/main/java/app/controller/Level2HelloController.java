package app.controller;

import app.client.HelloLevel3Client;
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
public class Level2HelloController {

	@Autowired
	HelloLevel3Client helloLevel3Client;
	@RequestMapping(value = "/give-me-high5")
	public String available() {
		return "level2 service is returning high5 to you.";
	}

	@GetMapping(value = "/level2-hello")
	public String hello2() {
		return "level2 works. calling level3: " + helloLevel3Client.giveMeLevel3Hello();
	}

}
