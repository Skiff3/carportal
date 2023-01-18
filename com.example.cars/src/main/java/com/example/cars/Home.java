package com.example.cars;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.*;
@Controller
public class Home {
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView m = new ModelAndView("index");
		return m;
		
	}
	
	private List<String> getList()
	{
		List<String> list = new ArrayList<String>();
		list.add("Toyota");
		list.add("Honda");
		list.add("Honda");
		list.add("Toyota");
		list.add("Mitsubishi");
		return list;
		
	}
	@RequestMapping("/home")
	public ModelAndView home(@RequestParam String cname) {
		ModelAndView mv = new ModelAndView("home");
		List<String> l = getList();
		mv.addObject("lists",l);
		mv.addObject("cname", cname);
		return mv;
	}
	
	@RequestMapping("/description")
	public ModelAndView description(@RequestParam String temp) {
		ModelAndView mv = new ModelAndView("description");
		return mv;
	}
	
	
}
