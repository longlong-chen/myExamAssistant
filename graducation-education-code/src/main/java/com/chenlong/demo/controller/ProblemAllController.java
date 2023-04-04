package com.chenlong.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.ApiResult;
import com.chenlong.demo.serviceimpl.ProblemAllServiceImpl;
import com.chenlong.demo.util.ApiResultHandler;
import com.chenlong.demo.vo.ProblemVO;

@RestController
public class ProblemAllController {

	@Autowired
	private ProblemAllServiceImpl problemAllServiceImpl;
	
	@GetMapping("/problems/{page}/{size}")
	public ApiResult findAllProblem(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		System.out.println("查询所有试题题");
		Page<ProblemVO> problemVOPage = new Page<>(page,size);
		IPage<ProblemVO> problemVOIPage = problemAllServiceImpl.findAll(problemVOPage);
		return ApiResultHandler.buildApiResult(200,"查询所有试题题",problemVOIPage);
		
	}
}
