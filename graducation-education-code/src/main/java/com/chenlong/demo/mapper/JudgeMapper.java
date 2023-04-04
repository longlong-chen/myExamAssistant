package com.chenlong.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.chenlong.demo.entity.JudgeProblem;

@Mapper
public interface JudgeMapper {
	
	@Options(useGeneratedKeys = true,keyProperty = "questionId")
	@Insert("insert into right_or_wrong(question,analysis,rightAnswer,"
	 		+ "level,course_id,chapter_id) values " +
	        "(#{question},#{analysis},#{rightAnswer},#{level},#{courseId},#{chapterId})")
	public int addJudge(JudgeProblem judgeProblem);
	
	@Delete("delete from right_or_wrong where question_id = #{questionId}")
	public int deleteJudge(Integer question_id);
	
	@Update("update right_or_wrong set question = #{question},rightAnswer = #{rightAnswer},score = #{score},"
			+ "level = #{level},course_id = #{courseId},chapter_id = #{chapterId} where question_id = #{questionId}")
	public int updateJudge(JudgeProblem judgeProblem);
	
	@Select("select * from right_or_wrong where question_id = #{questionId}")
	public JudgeProblem findById(Integer question_id);
	
	@Select("select * from right_or_wrong where question_id in (select question_id from paper_manage where questionType = 3 and paper_id = #{paperId})")
	public List<JudgeProblem> findByIdAndType(Integer paperId);
	
	@Select("select question_id from right_or_wrong order by rand() desc limit #{number}")
	public List<Integer> findByNumber(Integer number);
}
