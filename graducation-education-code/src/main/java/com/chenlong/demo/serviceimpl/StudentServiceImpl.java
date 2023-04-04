package com.chenlong.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.Login;
import com.chenlong.demo.entity.Student;
import com.chenlong.demo.mapper.StudentMapper;
import com.chenlong.demo.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
    private StudentMapper studentMapper;
	
	@Override
	public IPage<Student> findAll(Page<Student> page) {
		// TODO Auto-generated method stub
		return studentMapper.findAll(page);
	}
	

	@Override
	public Student findById(Integer studentId) {
		// TODO Auto-generated method stub
		return studentMapper.findById(studentId);
	}

	@Override
	public int deleteById(Integer studentId) {
		// TODO Auto-generated method stub
		return studentMapper.deleteById(studentId);
	}

	@Override
	public int updateState(Integer studentId, Boolean state) {
		// TODO Auto-generated method stub
		return studentMapper.updateState(studentId, state);
	}
	
	@Override
	public int update(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.update(student);
	}
	
	@Override
	public List<Student> findAllByName(String studentName) {
		// TODO Auto-generated method stub
		return studentMapper.findAllByName(studentName);
	}
	
	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentMapper.addStudent(student);
	}
	
	@Override
	public int updatePwd(Login user) {
		// TODO Auto-generated method stub
		return studentMapper.updatePwd(user);
	}
}
