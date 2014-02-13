package com.kingyee.project.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.mvc.util.RequestUtil;

import com.kingyee.project.mapper.TestMapper;
import com.kingyee.project.mapper.UserMapper;
import com.kingyee.project.mapper.bean.User;

@Service
public class TestService {
	@Autowired
	private TestMapper testMapper;
	@Autowired
	private UserMapper userMapper;
	
	
	public HashMap getUser() {
//		return testMapper.getUser();
		
		return testMapper.get2();
	}
	
	public void add() throws Exception {
		User u = new User();
		u.setId(2);
		u.setName("ycc");
		u.setSex("s");

		userMapper.insert(u);
		
//		testMapper.insertUser(u);
		
		throw new Exception();
	}
}
