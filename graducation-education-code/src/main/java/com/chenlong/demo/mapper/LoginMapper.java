package com.chenlong.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.chenlong.demo.entity.Admin;
import com.chenlong.demo.entity.Student;
import com.chenlong.demo.entity.Teacher;

@Mapper
public interface LoginMapper {

	@Select("select * from admin where administrator_id = #{username} and administrator_password = #{password}")
    public Admin adminLogin(Integer username, String password);

    @Select("select * from teacher where teacher_id = #{username} and teacher_password = #{password}")
    public Teacher teacherLogin(Integer username, String password);

    @Select("select * from student where student_id = #{username} and student_password = #{password}")
    public Student studentLogin(Integer username,String password);
}
