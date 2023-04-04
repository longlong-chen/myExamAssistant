package com.chenlong.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.Login;
import com.chenlong.demo.entity.Teacher;
import com.chenlong.demo.mapper.TeacherMapper;
import com.chenlong.demo.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
    private TeacherMapper teacherMapper;
	
	@Override
	public IPage<Teacher> findAll(Page<Teacher> page) {
		// TODO Auto-generated method stub
		return teacherMapper.findAll(page);
	}
	
	@Override
    public List<Teacher> findAll() {
        return teacherMapper.findAll();
    }

    @Override
    public Teacher findById(Integer teacherId) {
        return teacherMapper.findById(teacherId);
    }

    @Override
    public int deleteById(Integer teacherId) {
        return teacherMapper.deleteById(teacherId);
    }

    @Override
    public int update(Teacher teacher) {
        return teacherMapper.update(teacher);
    }
    
    @Override
    public int add(Teacher teacher) {
        return teacherMapper.add(teacher);
    }

    @Override
	public int updatePwd(Login user) {
		// TODO Auto-generated method stub
		return teacherMapper.updatePwd(user);
	}
}
