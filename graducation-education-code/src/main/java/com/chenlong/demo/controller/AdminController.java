package com.chenlong.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chenlong.demo.entity.Admin;
import com.chenlong.demo.entity.ApiResult;
import com.chenlong.demo.serviceimpl.AdminServiceImpl;
import com.chenlong.demo.util.ApiResultHandler;

@RestController
public class AdminController {

	@Autowired
    private AdminServiceImpl adminService;
	
	@GetMapping("/admin/{administratorId}")
	public ApiResult findById(@PathVariable("administratorId") Integer administratorId) {
		 Admin adminRes = adminService.findById(administratorId);
		 if (adminRes != null) {
	    	  return ApiResultHandler.buildApiResult(200,"请求成功",adminRes);
	      } else {
	          return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
	      }
	}
	
	@PutMapping("/admin")
	public ApiResult update(@RequestBody Admin admin) {
		  int res = adminService.update(admin);
	      if (res != 0) {
	    	  System.out.println("更新成功");
	    	  return ApiResultHandler.buildApiResult(200,"更新成功",res);
	      }
	      System.out.println("更新失败");
	      return ApiResultHandler.buildApiResult(400,"更新失败",res);
	 }
}
