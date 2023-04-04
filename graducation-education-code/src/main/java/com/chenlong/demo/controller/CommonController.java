package com.chenlong.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chenlong.demo.entity.Admin;
import com.chenlong.demo.entity.ApiResult;
import com.chenlong.demo.entity.FillProblem;
import com.chenlong.demo.entity.JudgeProblem;
import com.chenlong.demo.entity.Login;
import com.chenlong.demo.entity.SelectProblem;
import com.chenlong.demo.entity.ShortProblem;
import com.chenlong.demo.entity.Student;
import com.chenlong.demo.entity.Teacher;
import com.chenlong.demo.serviceimpl.AdminServiceImpl;
import com.chenlong.demo.serviceimpl.FillServiceImpl;
import com.chenlong.demo.serviceimpl.JudgeServiceImpl;
import com.chenlong.demo.serviceimpl.SelectServiceImpl;
import com.chenlong.demo.serviceimpl.ShortServiceImpl;
import com.chenlong.demo.serviceimpl.StudentServiceImpl;
import com.chenlong.demo.serviceimpl.TeacherServiceImpl;
import com.chenlong.demo.util.ApiResultHandler;


@RestController
public class CommonController {

	@Autowired
    private AdminServiceImpl adminService;
	
	@Autowired
    private StudentServiceImpl studentService;
	
	@Autowired
    private TeacherServiceImpl teacherService;
	
	//2021/4/26
	@Autowired
	private SelectServiceImpl selectServiceImpl;
	
	@Autowired
	private JudgeServiceImpl judgeServiceImpl;
	
	@Autowired
	private FillServiceImpl fillServiceImpl;
	
	@Autowired
	private ShortServiceImpl shortServiceImpl;
	
	//update user password
	@PostMapping("/settingPWD")
	public ApiResult login(@RequestBody Login login) {
		
        Integer username = login.getUsername();
        String password = login.getPassword();
        System.out.println("username="+username+"password="+password);
        
        Admin adminRes = adminService.findById(username);
        if (adminRes != null) {
        	System.out.println("更改管理员密码");
        	int res = adminService.updatePwd(login);
        	if(res>0)	return ApiResultHandler.buildApiResult(200, "更新成功", null);
        	return ApiResultHandler.buildApiResult(400, "更新失败", null);
        }
        Student studentRes = studentService.findById(username);
        if (studentRes != null) {
        	System.out.println("更改学生密码");
        	int res = studentService.updatePwd(login);
        	if(res>0)	return ApiResultHandler.buildApiResult(200, "更新成功", null);
        	return ApiResultHandler.buildApiResult(400, "更新失败", null);
        }
        Teacher teacherRes = teacherService.findById(username);
        if (teacherRes != null) {
        	System.out.println("更改教师密码");
        	int res = teacherService.updatePwd(login);
        	if(res>0)	return ApiResultHandler.buildApiResult(200, "更新成功", null);
        	return ApiResultHandler.buildApiResult(400, "更新失败", null);
        }
        return ApiResultHandler.buildApiResult(400, "更新失败", null);
    }
	
	//2021/4/26
	@GetMapping("/problem/{questionId}/{type}")
	public ApiResult findById(@PathVariable Integer questionId, @PathVariable String type) {
		System.out.println("查询题型为： "+type);
		if(type.equals("选择题")) {
			System.out.println("查询选择题");
			SelectProblem resSelectProblem = selectServiceImpl.findById(questionId);
			return ApiResultHandler.buildApiResult(200,"请求成功",resSelectProblem);
		}
		else if(type.equals("填空题")) {
			System.out.println("查询填空题");
			FillProblem resFillProblem = fillServiceImpl.findById(questionId);
			return ApiResultHandler.buildApiResult(200,"请求成功",resFillProblem);
		}
		else if(type.equals("判断题")) {
			System.out.println("查询判断题");
			JudgeProblem resJudgeProblem = judgeServiceImpl.findById(questionId);
			return ApiResultHandler.buildApiResult(200,"请求成功",resJudgeProblem);
		}
		else if(type.equals("简答题")) {
			System.out.println("查询简答题");
			ShortProblem reShortProblem = shortServiceImpl.findById(questionId);
			return ApiResultHandler.buildApiResult(200,"请求成功",reShortProblem);
		}
		return ApiResultHandler.buildApiResult(404,"查询的用户不存在",null);
	}
	/*
	@PutMapping("/problem/{questionId}/{type}")
	public ApiResult updateProblem(@PathVariable Integer questionId, @PathVariable String type) {
		System.out.println("更新题型为： "+type);
		if(type == "选择题") {
			System.out.println("更新选择题");
			int res1 = selectServiceImpl.
		}
		else if(type == "填空题") {
			System.out.println("更新填空题");
		}
		else if(type == "判断题") {
			System.out.println("更新判断题");
		}
		else if(type == "简答题") {
			System.out.println("更新简答题");
		}
		return ApiResultHandler.buildApiResult(400,"更新失败",null);
	}
	*/
}
