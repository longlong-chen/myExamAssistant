package com.chenlong.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.ApiResult;
import com.chenlong.demo.entity.Message;
import com.chenlong.demo.serviceimpl.MessageServiceImpl;
import com.chenlong.demo.util.ApiResultHandler;

@RestController
public class MessageController {

	 @Autowired
	    private MessageServiceImpl messageService;

	    @GetMapping("/messages/{page}/{size}")
	    public ApiResult<Message> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size) {
	        Page<Message> messagePage = new Page<>(page,size);
	        IPage<Message> all = messageService.findAll(messagePage);
	        return ApiResultHandler.buildApiResult(200,"查询所有留言",all);
	    }

	    @GetMapping("/message/{id}")
	    public ApiResult findById(@PathVariable("id") Integer id) {
	        Message res = messageService.findById(id);
	        return ApiResultHandler.buildApiResult(200,"根据Id查询",res);
	    }

	    @DeleteMapping("/message/{id}")
	    public int delete(@PathVariable("id") Integer id) {
	        int res = messageService.delete(id);
	        return res;
	    }

	    @PostMapping("/message")
	    public ApiResult add(@RequestBody Message message) {
	        int res = messageService.add(message);
	        if (res == 0) {
	            return ApiResultHandler.buildApiResult(400,"添加失败",res);
	        } else {
	            return ApiResultHandler.buildApiResult(200,"添加成功",res);
	        }
	    }
}
