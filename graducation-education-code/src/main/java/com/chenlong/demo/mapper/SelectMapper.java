package com.chenlong.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chenlong.demo.entity.SelectProblem;


@Mapper
public interface SelectMapper {
	
	 @Options(useGeneratedKeys = true,keyProperty = "questionId")
	 @Insert("insert into selectProblem(question,choice_A,choice_B,choice_C,choice_D,analysis,rightAnswer,"
	 		+ "level,course_id,chapter_id) values " +
	        "(#{question},#{choiceA},#{choiceB},#{choiceC},#{choiceD},#{analysis},#{rightAnswer},#{level},#{courseId},#{chapterId})")
	 public int addSelect(SelectProblem selectProblem);
	 
	 @Delete("delete from selectProblem where question_id = #{questionId}")
	 public int deleteSelect(Integer question_id);
	 
	 @Update("update selectProblem set question = #{question},rightAnswer = #{rightAnswer},score = #{score},"
				+ "level = #{level},course_id = #{courseId},chapter_id = #{chapterId} where question_id = #{questionId}")
	 public int updateSelect(SelectProblem selectProblem);
	 
	 @Select("select * from selectProblem where question_id = #{questionId}")
	 public SelectProblem findById(Integer question_id);
	 
	 @Select("select * from selectProblem where question_id in (select question_id from paper_manage where questionType = 1 and paper_id = #{paperId})")
	 List<SelectProblem> findByIdAndType(Integer PaperId);
	 
	 @Select("select question_id from selectProblem order by rand() desc limit #{number}")
	 public List<Integer> findByNumber(Integer number);
}
