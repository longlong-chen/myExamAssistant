package com.chenlong.demo.service;


import com.chenlong.demo.entity.Admin;
import com.chenlong.demo.entity.Student;
import com.chenlong.demo.entity.Teacher;

public interface LoginService {
	
	public Admin adminLogin(Integer username, String password);

    public Teacher teacherLogin(Integer username, String password);

    public Student studentLogin(Integer username, String password);
}
