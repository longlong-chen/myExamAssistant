package com.chenlong.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.ApiResult;
import com.chenlong.demo.entity.Student;
import com.chenlong.demo.serviceimpl.StudentServiceImpl;
import com.chenlong.demo.util.ApiResultHandler;

@RestController
public class StudentController {

	@Autowired
    private StudentServiceImpl studentService;
	
	@GetMapping("/students/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Student> studentPage = new Page<>(page,size);
        IPage<Student> res = studentService.findAll(studentPage);
        //System.out.println("res = "+res);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有学生",res);
    }
	
	@GetMapping("/students/{page}/{size}/{studentName}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size, @PathVariable String studentName) {
        Page<Student> studentPage = new Page<>(page,size);
        List<Student> students = studentService.findAllByName(studentName);
        IPage<Student> res = new Page<>(page,size);
        res.setRecords(students);
        //System.out.println("res = "+res);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有学生",res);
    }
	
	  @GetMapping("/student/{studentId}")
	  public ApiResult findById(@PathVariable("studentId") Integer studentId) {
		  Student res = studentService.findById(studentId);
	      if (res != null) {
	    	  return ApiResultHandler.buildApiResult(200,"请求成功",res);
	      } else {
	          return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
	      }
	  }
	  
	  @DeleteMapping("/student/{studentId}")
	  public ApiResult deleteById(@PathVariable("studentId") Integer studentId) {
		  return ApiResultHandler.buildApiResult(200,"删除成功",studentService.deleteById(studentId));
	  }
	  
	  @PutMapping("/studentState/{studentId}/{state}")
	  public ApiResult updateState(@PathVariable("studentId") Integer studentId,@PathVariable Boolean state) {
		  int res = studentService.updateState(studentId, state);
		  if (res >= 1) {
			  return ApiResultHandler.buildApiResult(200,"修改成功",null);
	      }else {
	          return ApiResultHandler.buildApiResult(400,"修改失败",null);
	      }
	  }
	  
	  @PutMapping("/student")
	  public ApiResult update(@RequestBody Student student) {
		  int res = studentService.update(student);
	      if (res != 0) {
	    	  System.out.println("更新成功");
	    	  return ApiResultHandler.buildApiResult(200,"更新成功",res);
	      }
	      System.out.println("更新失败");
	      return ApiResultHandler.buildApiResult(400,"更新失败",res);
	 }
	  
	  @PostMapping("/student")
	    public ApiResult addStudent(@RequestBody Student student){
	    	int res = studentService.addStudent(student);
	    	if(res<1)	return ApiResultHandler.buildApiResult(400,"添加失败",null);
	    	return ApiResultHandler.buildApiResult(200,"添加成功",null);
	    }
}
