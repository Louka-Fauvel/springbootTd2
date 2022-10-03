package edu.caensup.sio.td2.controllers;

import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import edu.caensup.sio.td2.models.User;
import edu.caensup.sio.td2.repositories.IUserDAO;
import edu.caensup.sio.td2.services.UserService;

@Controller
@RolesAllowed({"ADMIN", "USER_ADMIN"})
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private UserDetailsService uService;
	
	@GetMapping({"/index", ""})
	public String index(ModelMap model) {
		
		Iterable<User> users = userDAO.findAll(Sort.by(Direction.DESC, "lastname"));
		model.put("users", users);
		return "/users/index";
		
	}
	
	@GetMapping("/add")
	public String addUser() {
		return "/users/form";
	}
	
	@PostMapping("/add")
	public RedirectView addUser(@ModelAttribute User user) {
		
		User u = ((UserService) uService).CreateUser(user.getFirstname(), user.getLastname(), user.getEmail(), user.getPassword());
		userDAO.save(u);
		return new RedirectView("/");
		
	}
	
}
