package com.chenlong.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlong.demo.entity.Admin;
import com.chenlong.demo.entity.Login;
import com.chenlong.demo.mapper.AdminMapper;
import com.chenlong.demo.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
    private AdminMapper adminMapper;

	@Override
	public int updatePwd(Login user) {
		// TODO Auto-generated method stub
		return adminMapper.updatePwd(user);
	}
	
	@Override
	public Admin findById(Integer administratorId) {
		// TODO Auto-generated method stub
		return adminMapper.findById(administratorId);
	}
	
	@Override
	public int update(Admin admin) {
		return adminMapper.update(admin);
	}

}
