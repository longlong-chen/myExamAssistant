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
import com.chenlong.demo.entity.Chapter;
import com.chenlong.demo.serviceimpl.ChapterServiceImpl;
import com.chenlong.demo.util.ApiResultHandler;

@RestController
public class ChapterController {

	@Autowired
    private ChapterServiceImpl chapterService;
	
	@GetMapping("/chapters/{page}/{size}")
    public ApiResult findAll(@PathVariable Integer page, @PathVariable Integer size) {
        Page<Chapter> chapterPage = new Page<>(page,size);
        IPage<Chapter> res = chapterService.findAll(chapterPage);
        return  ApiResultHandler.buildApiResult(200,"分页查询所有章节",res);
    }
	
	@GetMapping("/chapter/{chapterId}")
	  public ApiResult findById(@PathVariable("chapterId") Integer chapterId) {
		Chapter res = chapterService.findById(chapterId);
	      if (res != null) {
	    	  return ApiResultHandler.buildApiResult(200,"请求成功",res);
	      } else {
	          return ApiResultHandler.buildApiResult(404,"查询的章节不存在",null);
	      }
	  }
	
	@DeleteMapping("/chapter/{chapterId}")
	  public ApiResult deleteById(@PathVariable("chapterId") Integer chapterId) {
		  int res = chapterService.deleteById(chapterId);
		  if(res>0)	return ApiResultHandler.buildApiResult(200,"删除成功",res);
		  return ApiResultHandler.buildApiResult(400,"删除失败",null);
	  }
	
	 @PutMapping("/chapter")
	  public ApiResult update(@RequestBody Chapter chapter) {
		  int res = chapterService.update(chapter);
	      if (res != 0) {
	    	  System.out.println("更新成功");
	    	  return ApiResultHandler.buildApiResult(200,"更新成功",res);
	      }
	      System.out.println("更新失败");
	      return ApiResultHandler.buildApiResult(400,"更新失败",res);
	 }
	 
	 @PostMapping("/chapter")
	    public ApiResult addChapter(@RequestBody Chapter chapter){
	    	int res = chapterService.addChapter(chapter);
	    	if(res<1)	return ApiResultHandler.buildApiResult(400,"添加失败",null);
	    	return ApiResultHandler.buildApiResult(200,"添加成功",null);
	    }
	 
	 @GetMapping("/allchapters")
	 public ApiResult findAll() {
		 	List<Chapter> courses = chapterService.findAll();
	        return  ApiResultHandler.buildApiResult(200,"查询所有科目",courses);
	 }
	 
	 @GetMapping("/coursesById/{courseId}")
	 public ApiResult findAllByCourseId(@PathVariable("courseId") Integer courseId) {
		 	List<Chapter> courses = chapterService.findAllByCourseId(courseId);
	        return  ApiResultHandler.buildApiResult(200,"查询所有科目",courses);
	 }
}
