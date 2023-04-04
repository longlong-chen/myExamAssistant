package com.chenlong.demo.controller;

import java.util.List;

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
import com.chenlong.demo.entity.Course;
import com.chenlong.demo.serviceimpl.CourseServiceImpl;
import com.chenlong.demo.util.ApiResultHandler;

@RestController
public class CourseController {

	@Autowired
    private CourseServiceImpl courseService;
	
	@GetMapping("/courses/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Course> coursePage = new Page<>(page,size);
        IPage<Course> res = courseService.findAll(coursePage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有科目",res);
    }
	
	@GetMapping("/course/{courseId}")
	  public ApiResult findById(@PathVariable("courseId") Integer courseId) {
		  Course res = courseService.findById(courseId);
	      if (res != null) {
	    	  return ApiResultHandler.buildApiResult(200,"请求成功",res);
	      } else {
	          return ApiResultHandler.buildApiResult(404,"查询的科目不存在",null);
	      }
	  }
	
	@DeleteMapping("/course/{courseId}")
	  public ApiResult deleteById(@PathVariable("courseId") Integer courseId) {
		  int res = courseService.deleteById(courseId);
		  if(res>0)	return ApiResultHandler.buildApiResult(200,"删除成功",res);
		  return ApiResultHandler.buildApiResult(400,"删除失败",null);
	  }
	
	 @PutMapping("/course")
	  public ApiResult update(@RequestBody Course course) {
		  int res = courseService.update(course);
	      if (res != 0) {
	    	  System.out.println("更新成功");
	    	  return ApiResultHandler.buildApiResult(200,"更新成功",res);
	      }
	      System.out.println("更新失败");
	      return ApiResultHandler.buildApiResult(400,"更新失败",res);
	 }
	 
	 @PostMapping("/course")
	    public ApiResult addCourse(@RequestBody Course course){
	    	int res = courseService.addCourse(course);
	    	if(res<1)	return ApiResultHandler.buildApiResult(400,"添加失败",null);
	    	return ApiResultHandler.buildApiResult(200,"添加成功",null);
	    }
	 
	 @GetMapping("/courses")
	 public ApiResult findAll() {
		 	List<Course> courses = courseService.findAll();
	        return  ApiResultHandler.buildApiResult(200,"查询所有科目",courses);
	 }
}
