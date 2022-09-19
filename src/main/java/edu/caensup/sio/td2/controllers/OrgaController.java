package edu.caensup.sio.td2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import edu.caensup.sio.td2.models.Organization;
import edu.caensup.sio.td2.repositories.IOrganizationDAO;

@Controller
@RequestMapping("/orgas")
public class OrgaController {
	
	@Autowired
	private IOrganizationDAO orgarepo;
	
	@GetMapping({"/index", ""})
	public String indexAction() {
		return "/orgas/index";
	}

	@PostMapping("/new")
	public RedirectView newAction(@RequestBody Organization orga) {
		orgarepo.save(orga);
		return new RedirectView("/orgas/index");
	}
}
