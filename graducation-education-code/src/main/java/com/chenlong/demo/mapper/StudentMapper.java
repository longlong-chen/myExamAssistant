package com.chenlong.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.Login;
import com.chenlong.demo.entity.Student;

@Mapper
public interface StudentMapper {

	/**
     * 分页查询所有学生
     * @param page
     * @return List<Student>
     */
    @Select("select * from student")
    IPage<Student> findAll(Page<Student> page);
    
    
    @Select("select * from student where student_id = #{studentId}")
    Student findById(Integer studentId);
    
    @Delete("delete from student where student_id = #{studentId}")
    int deleteById(Integer studentId);
    
    @Update("update student set disabled_flag = #{state} where student_id = #{studentId}")
    int updateState(Integer studentId, Boolean state);
    
    /**
     *更新所有学生信息
     * @param student 传递一个对象
     * @return 受影响的记录条数
     */
    @Update("update student set student_name = #{studentName},student_password = #{studentPassword},student_phone = #{studentPhone},student_email = #{studentEmail}," +
            "role = #{role},student_school = #{studentSchool},disabled_flag = #{disabledFlag},student_major = #{studentMajor},sex = #{sex} " +
            "where student_id = #{studentId}")
    int update(Student student);
    
    @Select("select * from student where student_name = #{studentName}")
    List<Student> findAllByName(String studentName);
    
    @Options(useGeneratedKeys = true,keyProperty = "studentId")
    @Insert("insert into student(student_name,student_password,student_phone,student_email,disabled_flag,student_school,student_major,sex) values " +
            "(#{studentName},#{studentPassword},#{studentPhone},#{studentEmail},#{disabledFlag},#{studentSchool},#{studentMajor},#{sex})")
    int addStudent(Student student);
    
    //更改密码
    @Update("update student set student_password = #{password} where student_id = #{username}")
	int updatePwd(Login user);
}
