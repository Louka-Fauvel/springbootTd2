package edu.caensup.sio.td2.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import edu.caensup.sio.td2.models.Organization;
import edu.caensup.sio.td2.models.User;
import edu.caensup.sio.td2.repositories.IOrganizationDAO;
import edu.caensup.sio.td2.services.UserService;
import edu.caensup.sio.td2.ui.UILink;
import edu.caensup.sio.td2.ui.UIMessage;

@Controller
@RequestMapping("/orgas")
public class OrgaController {
	
	@Autowired
	private IOrganizationDAO orgarepo;
	
	@GetMapping({"/index", ""})
	public String indexAction(ModelMap model, @RequestAttribute(name = "msg", required = false) UIMessage msg) {
		
		Iterable<Organization> organizations = orgarepo.findAll();
		model.put("orgas", organizations);
		return "/orgas/index";
	}

	@GetMapping("/new")
	public String newAction(ModelMap model) {
		model.put("orga", new Organization());
		return "/orgas/form";
	}
	
	@PostMapping("/new")
	public RedirectView newAction(@ModelAttribute Organization orga) {
		orgarepo.save(orga);
		return new RedirectView("/orgas/index");
	}
	
	@GetMapping("/delete/{id}")
	public RedirectView deleteAction(@PathVariable int id, RedirectAttributes attrs) {
		
		Optional<Organization> opt = orgarepo.findById(id);
		if(opt.isPresent()) {
			attrs.addFlashAttribute("msg", 
					UIMessage.errorConfirmation("Suppression", "Voulez-vous le supprimmer " + opt.get().getName(), 
							"/orgas/delete/force/" + id, "/orgas/index"));
		}
		
		return new RedirectView("/orgas/index");
		
	}
	
	@GetMapping("/delete/force/{id}")
	public RedirectView deleteActionForce(@PathVariable int id) {
		
		orgarepo.deleteById(id);
		return new RedirectView("/orgas/index");
		
	}
	
	@GetMapping("/edit/{id}")
	public String editAction(ModelMap model, @PathVariable int id) {
		orgarepo.findById(id).ifPresent(orga -> model.put("orga", orga));
		return "/orgas/form";
	}
	
	@GetMapping("/display/{id}")
	public String displayAction(ModelMap model, @PathVariable int id) {
		
		orgarepo.findById(id).ifPresent(orga -> model.put("orga", orga));
		return "/orgas/display";
		
	}
	
	@PostMapping("/search")
	public String searchAction(ModelMap model, @ModelAttribute Organization orga) {
		
		Iterable<Organization> organizations = orgarepo.findByNameContaining(orga.getName());
		model.put("orgas", organizations);
		return "/orgas/index";
		
	}
}
