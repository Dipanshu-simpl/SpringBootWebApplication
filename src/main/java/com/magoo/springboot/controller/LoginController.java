package com.magoo.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("name")
public class LoginController {
	
	
	
	/*@Autowired
	LoginService loginService;*/
	

	@RequestMapping(value="/", method=RequestMethod.GET)
	//@ResponseBody
	public String loginMessage(ModelMap model)
	{
		
		model.put("name", "in28Minutes");
		//model.put("name", name);
		//System.out.println(name);
		return "welcome";
	}
}
