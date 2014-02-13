package com.kingyee.project.controller;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.util.WebUtil;
import spring.util.SpringContext;

import com.kingyee.project.mapper.bean.User;
import com.kingyee.project.service.TestService;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("go")
	public ModelAndView go(HttpServletRequest req) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
		WebApplicationContext wcx = WebUtil.getMVCApplicationContext();
		ApplicationContext cx = SpringContext.getAppContext();
		
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
	
	// test with 
	// curl -H "Accept:application/json,text/html" http://localhost:8080/springmvc/getGson.do
	// spring 3.1 : produces = MediaType.APPLICATION_JSON_VALUE
	// spring 3.0 : headers="Accept=application/json"
	@ResponseBody
	@RequestMapping(value="/getGson", produces = MediaType.APPLICATION_JSON_VALUE)
	public HashMap getGson() {
		HashMap m = testService.getUser();
		return m;
	}
	
	@RequestMapping(value="/xml")
	public ModelAndView xml(@RequestParam("xml") User u) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("insert");
		
		return mv;
	}
}
