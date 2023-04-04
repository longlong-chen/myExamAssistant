package com.chenlong.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.Login;
import com.chenlong.demo.entity.Teacher;

public interface TeacherService {
	IPage<Teacher> findAll(Page<Teacher> page);
	public List<Teacher> findAll();
	public Teacher findById(Integer teacherId);
	public int deleteById(Integer teacherId);
	public int update(Teacher teacher);
	public int add(Teacher teacher);
	public int updatePwd(Login user);
}
