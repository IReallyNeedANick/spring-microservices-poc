package cloud.authorization.application;

import cloud.authorization.application.service.AccountUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by jdruwe on 15/06/16.
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Import(AccountUserDetailsService.class)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


	@Autowired
	private AccountUserDetailsService accountUserDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.formLogin()
				.and()
				.httpBasic().disable()
				.anonymous().disable()
				.authorizeRequests().anyRequest().authenticated()
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.NEVER)
				.and()
				.csrf().disable()
		;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
				.userDetailsService(accountUserDetailsService)
//				.passwordEncoder(new PlaintextPasswordEncoder())
		;
	}

}
