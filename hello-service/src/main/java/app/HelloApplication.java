package app;

import app.property.PropertyConfig;
import feign.RequestInterceptor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;

/**
 * Created by bm on 29.03.2017.
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableConfigurationProperties(PropertyConfig.class)
public class HelloApplication {


	public static void main(String[] args) {
		SpringApplication.run(HelloApplication.class, args);
	}

	@Bean
	public RequestInterceptor requestTokenBearerInterceptor() {
		return requestTemplate -> {
			OAuth2AuthenticationDetails details = (OAuth2AuthenticationDetails)
					SecurityContextHolder.getContext().getAuthentication().getDetails();
			requestTemplate.header("Authorization", "Bearer " + details.getTokenValue());
		};
	}
}