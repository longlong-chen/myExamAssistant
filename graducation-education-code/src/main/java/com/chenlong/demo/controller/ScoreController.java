package com.chenlong.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chenlong.demo.entity.ApiResult;
import com.chenlong.demo.entity.Score;
import com.chenlong.demo.serviceimpl.ScoreServiceImpl;
import com.chenlong.demo.util.ApiResultHandler;

@RestController
public class ScoreController {

	@Autowired
	private ScoreServiceImpl scoreServiceImpl;
	
	@GetMapping("/scores")
	public ApiResult findAll() {
        List<Score> res = scoreServiceImpl.findAll();
        return ApiResultHandler.buildApiResult(200,"查询所有学生成绩",res);
    }
	
	 @GetMapping("/score/{studentId}")
	 public ApiResult findById(@PathVariable("studentId") Integer studentId) {
		 List<Score> res = scoreServiceImpl.findById(studentId);
	     if (!res.isEmpty()) {
	    	 return ApiResultHandler.buildApiResult(200,"根据ID查询成绩",res);
	     }else {
	    	 return ApiResultHandler.buildApiResult(400,"ID不存在",res);
	     }
	 }
	 
	 @PostMapping("/score")
	 public ApiResult add(@RequestBody Score score) {
		 int res = scoreServiceImpl.add(score);
	     if (res == 0) {
	    	 return ApiResultHandler.buildApiResult(400,"成绩添加失败",res);
	     }else {
	         return ApiResultHandler.buildApiResult(200,"成绩添加成功",res);
	     }
	 }

	 @GetMapping("/scores/{paperId}")
	 public ApiResult findByExamCode(@PathVariable("paperId") Integer paperId) {
		 List<Score> scores = scoreServiceImpl.findByPaperId(paperId);
	     return ApiResultHandler.buildApiResult(200,"查询成功",scores);
	 }
}
