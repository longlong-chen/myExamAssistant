package com.chenlong.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chenlong.demo.entity.ShortProblem;

@Mapper
public interface ShortMapper {

	@Options(useGeneratedKeys = true,keyProperty = "questionId")
	@Insert("insert into short_question(question,analysis,rightAnswer,"
	 		+ "level,course_id,chapter_id) values " +
	        "(#{question},#{analysis},#{rightAnswer},#{level},#{courseId},#{chapterId})")
	public int addShort(ShortProblem shortProblem);
	
	@Delete("delete from short_question where question_id = #{questionId}")
	public int deleteShort(Integer question_id);
	
	@Update("update short_question set question = #{question},rightAnswer = #{rightAnswer},score = #{score},"
			+ "level = #{level},course_id = #{courseId},chapter_id = #{chapterId} where question_id = #{questionId}")
	public int updateShort(ShortProblem shortProblem);
	
	@Select("select * from short_question where question_id = #{questionId}")
	public ShortProblem findById(Integer question_id);
	
	@Select("select * from short_question where question_id in (select question_id from paper_manage where questionType = 4 and paper_id = #{paperId})")
	public List<ShortProblem> findByIdAndType(Integer paperId);
	
	@Select("select question_id from short_question order by rand() desc limit #{number}")
	public List<Integer> findByNumber(Integer number);
}
