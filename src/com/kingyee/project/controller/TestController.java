package com.kingyee.project.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kingyee.project.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("go")
	public ModelAndView go() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");

		HashMap m = testService.getUser();
		mv.addObject("m", m);
		
		return mv;
	}
	
	@RequestMapping("insert")
	public ModelAndView insert() throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("insert");
		
		testService.add();

		return mv;
	}
}
