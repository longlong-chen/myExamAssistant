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
import com.chenlong.demo.entity.Teacher;

@Mapper
public interface TeacherMapper {
	@Select("select * from teacher")
    IPage<Teacher>  findAll(Page<Teacher> page);
	

    @Select("select * from teacher")
    public List<Teacher> findAll();

    @Select("select * from teacher where teacher_id = #{teacherId}")
    public Teacher findById(Integer teacherId);

    @Delete("delete from teacher where teacher_id = #{teacherId}")
    public int deleteById(Integer teacherId);

    @Update("update teacher set teacher_name = #{teacherName},teacher_password = #{teacherPassword}," +
            "teacher_phone = #{teacherPhone}, teacher_email = #{teacherEmail},teacher_type = #{teacherType},disabled_flag = #{disabledFlag}," +
            "role = #{role},sex = #{sex} where teacher_id = #{teacherId}")
    public int update(Teacher teacher);

    @Options(useGeneratedKeys = true,keyProperty = "teacherId")
    @Insert("insert into teacher(teacher_name,teacher_password,teacher_phone,teacher_email,teacher_type,disabled_flag,sex,role) " +
            "values(#{teacherName},#{teacherPassword},#{teacherPhone},#{teacherEmail},#{teacherType},#{disabledFlag},#{sex},#{role})")
    public int add(Teacher teacher);
    
    //更改密码
    @Update("update teacher set teacher_password = #{password} where teacher_id = #{username}")
	int updatePwd(Login user);
}
