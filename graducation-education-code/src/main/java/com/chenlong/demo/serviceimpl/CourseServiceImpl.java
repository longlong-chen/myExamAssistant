package com.chenlong.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.Course;
import com.chenlong.demo.mapper.CourseMapper;

@Service
public class CourseServiceImpl implements com.chenlong.demo.service.CourseService {

	@Autowired
	private CourseMapper courseMapper;
	
	@Override
	public IPage<Course> findAll(Page<Course> page) {
		return courseMapper.findAll(page);
	}
	
	@Override
	public Course findById(Integer courseId) {
		return courseMapper.findById(courseId);
	}
	
	@Override
	public int deleteById(Integer courseId) {
		return courseMapper.deleteById(courseId);
	}
	
	@Override
	public int update(Course course) {
		return courseMapper.update(course);
	}
	
	@Override
	public int addCourse(Course course) {
		return courseMapper.addCourse(course);
	}
	
	@Override
	public List<Course> findAll() {
		return	courseMapper.findAll();
	}
}
