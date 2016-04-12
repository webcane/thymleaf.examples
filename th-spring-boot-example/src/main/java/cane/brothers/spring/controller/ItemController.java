package cane.brothers.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cane.brothers.spring.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
    
	@RequestMapping(value = "/items", method=RequestMethod.GET)
	public String items(Model model) {
		model.addAttribute("items", itemService.getAllItems());
		return "items";
	}
}
