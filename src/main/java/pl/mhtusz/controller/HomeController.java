package pl.mhtusz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.mhtusz.service.NBPTableService;




@Controller
public class HomeController {
	
	@Autowired
	private NBPTableService nbpTableService;

	

	@GetMapping("/")
	public ModelAndView refresh() {

		ModelAndView modelAndView = new ModelAndView("nbptables");
		modelAndView.addObject("tableA", nbpTableService.getNBPTable("a"));
		modelAndView.addObject("tableB", nbpTableService.getNBPTable("b"));
		return modelAndView;
	}

}