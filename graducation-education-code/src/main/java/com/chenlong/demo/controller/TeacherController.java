package com.chenlong.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.ApiResult;
import com.chenlong.demo.entity.Teacher;
import com.chenlong.demo.serviceimpl.TeacherServiceImpl;
import com.chenlong.demo.util.ApiResultHandler;

@RestController
public class TeacherController {

		@Autowired
		private TeacherServiceImpl teacherService;
	
	 	@GetMapping("/teachers/{page}/{size}")
	 	public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size){
	 		Page<Teacher> teacherPage = new Page<>(page,size);
	 		IPage<Teacher> teacherIPage = teacherService.findAll(teacherPage);
	 		return ApiResultHandler.buildApiResult(200,"查询所有教师",teacherIPage);
	 	}
	 
	 	@GetMapping("/teacher/{teacherId}")
	    public ApiResult findById(@PathVariable("teacherId") Integer teacherId){
	        return ApiResultHandler.success(teacherService.findById(teacherId));
	    }

	    @DeleteMapping("/teacher/{teacherId}")
	    public ApiResult deleteById(@PathVariable("teacherId") Integer teacherId){
	        return ApiResultHandler.success(teacherService.deleteById(teacherId));
	    }

	    @PutMapping("/teacher")
	    public ApiResult update(@RequestBody Teacher teacher){
	        return ApiResultHandler.success(teacherService.update(teacher));
	    }
	    
	    @PostMapping("/teacher")
	    public ApiResult add(@RequestBody Teacher teacher){
	    	//System.out.println("489499999999999999999999");
	    	int res = teacherService.add(teacher);
	    	System.out.println("res="+res);
	    	if(res<1)	return ApiResultHandler.buildApiResult(400,"添加失败",null);
	    	//return ApiResultHandler.success(teacherService.add(teacher));
	    	return ApiResultHandler.buildApiResult(200,"添加成功",null);
	    }
}
