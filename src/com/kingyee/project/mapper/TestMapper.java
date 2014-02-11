package com.kingyee.project.mapper;

import java.util.HashMap;

import org.apache.ibatis.annotations.Select;

import com.kingyee.project.mapper.bean.User;

public interface TestMapper {
	@Select("select * from user")
	HashMap getUser();
	
	void insertUser(User u);
	
	HashMap get2();
}
