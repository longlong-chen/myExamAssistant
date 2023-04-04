package com.chenlong.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.Login;
import com.chenlong.demo.entity.Student;

public interface StudentService {
	IPage<Student> findAll(Page<Student> page);
	//IPage<Student> findStudentByName(Page<Student> page);
	Student findById(Integer studentId);
	int deleteById(Integer studentId);
	int update(Student student);
	int updateState(Integer studentId, Boolean state);
	List<Student> findAllByName(String studentName);
	int addStudent(Student student);
	public int updatePwd(Login user);
}
