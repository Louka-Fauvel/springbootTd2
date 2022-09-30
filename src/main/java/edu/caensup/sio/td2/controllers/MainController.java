package edu.caensup.sio.td2.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.caensup.sio.td2.models.User;

@Controller
@RequestMapping("")
public class MainController {

	@RequestMapping("")
	public String index(@AuthenticationPrincipal User authUser, ModelMap model) {
		
		model.put("authUser", authUser);
		return "index";
		
	}
}
