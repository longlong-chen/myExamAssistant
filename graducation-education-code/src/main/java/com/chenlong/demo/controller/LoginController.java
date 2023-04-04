package com.chenlong.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chenlong.demo.entity.Admin;
import com.chenlong.demo.entity.ApiResult;
import com.chenlong.demo.entity.Login;
import com.chenlong.demo.entity.Student;
import com.chenlong.demo.entity.Teacher;
import com.chenlong.demo.serviceimpl.LoginServiceImpl;
import com.chenlong.demo.util.ApiResultHandler;

@RestController
public class LoginController {

	@Autowired
    private LoginServiceImpl loginService;
	
	@PostMapping("/login")
	public ApiResult login(@RequestBody Login login) {
		
        Integer username = login.getUsername();
        String password = login.getPassword();
        System.out.println("username="+username+"password="+password);
        Admin adminRes = loginService.adminLogin(username, password);
        if (adminRes != null) {
            return ApiResultHandler.buildApiResult(200, "请求成功", adminRes);
        }

        Teacher teacherRes = loginService.teacherLogin(username,password);
        if (teacherRes != null) {
            return ApiResultHandler.buildApiResult(200, "请求成功", teacherRes);
        }

        Student studentRes = loginService.studentLogin(username,password);
        if (studentRes != null) {
            return ApiResultHandler.buildApiResult(200, "请求成功", studentRes);
        }

        return ApiResultHandler.buildApiResult(400, "请求失败", null);
    }
}
