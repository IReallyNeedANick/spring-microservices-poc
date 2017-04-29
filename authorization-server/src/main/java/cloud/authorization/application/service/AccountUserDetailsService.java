package cloud.authorization.application.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by bm on 16.04.2017.
 */
@Service

public class AccountUserDetailsService implements UserDetailsService {


	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
	User user = new User(
			"boris",
			"marn",
			AuthorityUtils.createAuthorityList("ROLE_USER"));
	User userAdmin = new User(
			"tomaz",
			"gornik",
			AuthorityUtils.createAuthorityList("ROLE_ADMIN", "ROLE_USER"));
		if (user.getUsername().equals(s)) {
			return user;
		} else if (userAdmin.getUsername().equals(s)) {
			return userAdmin;
		}

		throw new UsernameNotFoundException("the user is completely wrong");
	}
}
