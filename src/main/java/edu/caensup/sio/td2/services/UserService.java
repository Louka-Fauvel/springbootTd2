package edu.caensup.sio.td2.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import edu.caensup.sio.td2.models.User;
import edu.caensup.sio.td2.repositories.IUserDAO;

public class UserService implements UserDetailsService {

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private IUserDAO UserDAO;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
        Optional<User> opt = UserDAO.findByEmail(username);
        
        if (opt.isPresent()) {
            return opt.get();
        }
        
        throw new UsernameNotFoundException("Utilisateur non trouvé");
        
    }
	
	public User CreateUser(String firstname, String lastname, String email, String password) {
		
        User u = new User();
        u.setFirstname(firstname);
        u.setLastname(lastname);
        u.setEmail(email);
        u.setPassword(passwordEncoder.encode(password)); // (3)
        return u;
        
    }
	
}
