package edu.caensup.sio.td2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class MainController {

	@RequestMapping("")
	public String index() {
		
		return "index";
		
	}
}