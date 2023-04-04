package com.chenlong.demo.service;

import com.chenlong.demo.entity.Admin;
import com.chenlong.demo.entity.Login;

public interface AdminService {
	//更新密码
	public int updatePwd(Login user);
	//根据Id查找
	public Admin findById(Integer administratorId);
	//更新
	public int update(Admin admin);
}
