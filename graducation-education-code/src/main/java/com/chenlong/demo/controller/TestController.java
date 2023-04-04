package com.chenlong.demo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chenlong.demo.util.FileUploadUtil;


@RestController
@RequestMapping(value = "/test")
@CrossOrigin
public class TestController {

	@PostMapping(value = "/upload")
    // @RequestParam中的file名应与前端的值保持一致
    public String upload(@RequestParam("file") MultipartFile multipartFile) {
        // replaceAll 用来替换windows中的\\ 为 /
		System.out.println("访问");
        return FileUploadUtil.upload(multipartFile).replaceAll("\\\\", "/");
    }
}
