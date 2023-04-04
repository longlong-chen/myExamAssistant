package com.chenlong.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlong.demo.entity.Admin;
import com.chenlong.demo.entity.Student;
import com.chenlong.demo.entity.Teacher;
import com.chenlong.demo.mapper.LoginMapper;
import com.chenlong.demo.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
    private LoginMapper loginMapper;

	@Override
	public Admin adminLogin(Integer username, String password) {
		// TODO Auto-generated method stub
		return loginMapper.adminLogin(username,password);
	}

	@Override
	public Teacher teacherLogin(Integer username, String password) {
		// TODO Auto-generated method stub
		return loginMapper.teacherLogin(username,password);
	}

	@Override
	public Student studentLogin(Integer username, String password) {
		// TODO Auto-generated method stub
		return loginMapper.studentLogin(username,password);
	}

}
