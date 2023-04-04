package com.chenlong.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chenlong.demo.entity.ApiResult;
import com.chenlong.demo.entity.ShortProblem;
import com.chenlong.demo.serviceimpl.ShortServiceImpl;
import com.chenlong.demo.util.ApiResultHandler;

@RestController
public class ShortController {

	@Autowired
	private ShortServiceImpl shortServiceImpl;
	
	@PostMapping("/short")
	public ApiResult addShort(@RequestBody ShortProblem shortProblem) {
		System.out.println("添加简答题");
		//System.out.println("相关数据： "+selectProblem);
		int res = shortServiceImpl.addShort(shortProblem);
		if(res<1)	return ApiResultHandler.buildApiResult(400,"添加失败",null);
    	return ApiResultHandler.buildApiResult(200,"添加成功",null);
	}
	
	@PutMapping("/short")
	public ApiResult update(@RequestBody ShortProblem shortProblem) {
		int res = shortServiceImpl.updateShort(shortProblem);
		if (res != 0) {
	    	  System.out.println("更新成功");
	    	  return ApiResultHandler.buildApiResult(200,"更新成功",res);
	      }
	      System.out.println("更新失败");
	      return ApiResultHandler.buildApiResult(400,"更新失败",res);
	}
}
