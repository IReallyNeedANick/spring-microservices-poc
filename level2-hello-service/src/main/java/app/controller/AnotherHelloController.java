package app.controller;

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
public class AnotherHelloController {

	@RequestMapping(value = "/give-me-hello")
	public String available() {
		return "This is a very complex, second level hello!";
	}

}
