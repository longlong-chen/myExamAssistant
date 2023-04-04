package com.chenlong.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.Course;

public interface CourseService {

	public IPage<Course> findAll(Page<Course> page);
	public Course findById(Integer courseId);
	public int deleteById(Integer courseId);
	public int update(Course course);
	public int addCourse(Course course);
	public List<Course> findAll();
	
}
