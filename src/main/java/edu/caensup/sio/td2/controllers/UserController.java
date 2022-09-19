package edu.caensup.sio.td2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import edu.caensup.sio.td2.models.User;
import edu.caensup.sio.td2.repositories.IUserDAO;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private IUserDAO userDAO;
	
	@GetMapping({"/index", ""})
	public String index(ModelMap model) {
		
		Iterable<User> users = userDAO.findAll(Sort.by(Direction.DESC, "lastname"));
		model.put("users", users);
		return "/users/index";
		
	}
	
	@GetMapping("/users/add/{firstname}/{lastname}")
	public RedirectView addUser(@PathVariable String firstname, @PathVariable String lastname) {
		
		User u = new User();
		u.setFirstname(firstname);
		u.setLastname(lastname);
		userDAO.save(u);
		return new RedirectView("/users");
		
	}
	
}
