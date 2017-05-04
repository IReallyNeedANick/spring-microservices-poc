package app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bm on 17.04.2017.
 */
@RestController
public class Level3HelloController {

	private static final Logger logger = LoggerFactory
			.getLogger(Level3HelloController.class);
	@RequestMapping(value = "/level3-hello")
	public String available() {
		logger.info("level 3 hello service called");
		return "greetings from level3!";
	}

}
