package com.chenlong.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chenlong.demo.entity.FillProblem;

@Mapper
public interface FillMapper {

	@Options(useGeneratedKeys = true,keyProperty = "questionId")
	@Insert("insert into filling(question,analysis,rightAnswer,"
	 		+ "level,course_id,chapter_id) values " +
	        "(#{question},#{analysis},#{rightAnswer},#{level},#{courseId},#{chapterId})")
	public int addFill(FillProblem fillProblem);
	
	@Delete("delete from filling where question_id = #{questionId}")
	int deleteFill(Integer question_id);
	
	@Update("update filling set question = #{question},rightAnswer = #{rightAnswer},score = #{score},"
			+ "level = #{level},course_id = #{courseId},chapter_id = #{chapterId} where question_id = #{questionId}")
	int updateFill(FillProblem fillProblem);
	
	@Select("select * from filling where question_id = #{questionId}")
	public FillProblem findById(Integer question_id);
	
	@Select("select * from filling where question_id in (select question_id from paper_manage where questionType = 2 and paper_id = #{paperId})")
	public List<FillProblem> findByIdAndType(Integer paperId);
	
	@Select("select question_id from filling order by rand() desc limit #{number}")
	public List<Integer> findByNumber(Integer number);
}
