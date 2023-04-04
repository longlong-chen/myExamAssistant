package com.chenlong.demo.controller;

//import java.text.SimpleDateFormat;

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
import com.chenlong.demo.entity.PaperInfo;
import com.chenlong.demo.serviceimpl.PaperInfoServiceImpl;
import com.chenlong.demo.util.ApiResultHandler;

@RestController
public class PaperInfoController {

	@Autowired
	private PaperInfoServiceImpl paperInfoServiceImpl;
	
	/**
	 * 2021/5/6
	 * 带有发布位的相关接口
	 * @return
	 */
	@GetMapping("/exams")
	public ApiResult findAllByFlag() {
		System.out.println("带有发布位的不分页查询所有试卷信息");
		return ApiResultHandler.buildApiResult(200, "请求成功！", paperInfoServiceImpl.findAllByFlag());
	}
	
	@GetMapping("/exams/{page}/{size}")
	public ApiResult findAllByFlag(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		System.out.println("带有发布位的分页查询所有试卷信息");
		Page<PaperInfo> paperInfo = new Page<>(page,size);
		IPage<PaperInfo> allPaperInfoIPage = paperInfoServiceImpl.findAllByFlag(paperInfo);
		return ApiResultHandler.buildApiResult(200, "请求成功！", allPaperInfoIPage);
	}
	//分界
	@GetMapping("/paperInfos")
	public ApiResult findAll() {
		System.out.println("不分页查询所有试卷信息");
		return ApiResultHandler.buildApiResult(200, "请求成功！", paperInfoServiceImpl.findAll());
	}
	
	@GetMapping("/paperInfos/{page}/{size}")
	public ApiResult findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
		System.out.println("分页查询所有试卷信息");
		Page<PaperInfo> paperInfo = new Page<>(page,size);
		IPage<PaperInfo> allPaperInfoIPage = paperInfoServiceImpl.findAll(paperInfo);
		return ApiResultHandler.buildApiResult(200, "请求成功！", allPaperInfoIPage);
	}
	
	@GetMapping("/paperInfo/{paperId}")
	public ApiResult findById(@PathVariable("paperId") Integer paperId) {
		System.out.println("根据ID查找");
		PaperInfo res = paperInfoServiceImpl.findById(paperId);
		if(res == null) {
			return ApiResultHandler.buildApiResult(404,"试卷信息编号不存在",null);
		}
		return ApiResultHandler.buildApiResult(200,"请求成功！",res);
	}
	
	@DeleteMapping("/paperInfo/{paperId}")
	public ApiResult deleteById(@PathVariable("paperId") Integer paperId) {
		int res = paperInfoServiceImpl.deleteById(paperId);
		if(res>0)	return ApiResultHandler.buildApiResult(200,"删除成功",res);
		return ApiResultHandler.buildApiResult(400,"删除失败",null);
	}
	
	@PutMapping("/paperInfo")
	public ApiResult updatePaperInfo(@RequestBody PaperInfo paperInfo) {
		System.out.println("更新试卷信息");
		//System.out.print("time: "+paperInfo.getCreateDate());
		//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		//String startTime = sdf.format(paperInfo.getCreateDate());
		//System.out.println("time: "+);
		int res = paperInfoServiceImpl.updatePaperInfo(paperInfo);
		if(res<0)	return ApiResultHandler.buildApiResult(400,"更新失败",null);
		return ApiResultHandler.buildApiResult(200,"更新成功",res);
	}
	
	@PostMapping("/paperInfo")
	public ApiResult addPaperInfo(@RequestBody PaperInfo paperInfo) {
		System.out.print("增加试卷信息");
		int res = paperInfoServiceImpl.addPaperInfo(paperInfo);
		if(res<0)	return  ApiResultHandler.buildApiResult(400,"添加失败",res);
		return ApiResultHandler.buildApiResult(200, "添加成功", res);
	}
	
	@PutMapping("/paperState/{paperId}/{publishFlag}")
	public ApiResult updatePaperState(@PathVariable("paperId") Integer paperId,@PathVariable Boolean publishFlag) {
		System.out.print("更新试卷发布状态");
		int res = paperInfoServiceImpl.updatePaperState(paperId, publishFlag);
		if (res >= 1) {
			return ApiResultHandler.buildApiResult(200,"修改成功",null);
	    }else {
	        return ApiResultHandler.buildApiResult(400,"修改失败",null);
	    }
	}
	
}
