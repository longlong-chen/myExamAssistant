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
import com.chenlong.demo.entity.Course;

@Mapper
public interface CourseMapper {

	/**
         * 分页查询所有课程
     * @param page
     * @return List<Course>
     */
	@Select("select * from course")
	public IPage<Course> findAll(Page<Course> page);
	
	/**
	 * 按id查询课程
	 * @param courseId
	 * @return
	 */
	@Select("select * from course where course_id = #{courseId}")
	public Course findById(Integer courseId);
	
	//删除课程
	@Delete("delete from course where course_id = #{courseId}")
	public int deleteById(Integer courseId);
	
	//更新课程
	@Update("update course set course_name = #{courseName} where course_id = #{courseId}")
	public int update(Course course);
	
	//添加课程
	@Options(useGeneratedKeys = true,keyProperty = "courseId")
    @Insert("insert into course(course_name) values(#{courseName})")
	public int addCourse(Course course);
	
	/**
	 * 查询所有课程
	 * @return List<Course>
	 */
	@Select("select * from course")
	public List<Course> findAll();
}
