package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by bm on 29.03.2017.
 */
@SpringBootApplication
@EnableEurekaClient
public class TracingApplication {


	public static void main(String[] args) {
		SpringApplication.run(TracingApplication.class, args);
	}

}