package com.chenlong.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.chenlong.demo.entity.Score;

@Mapper
public interface ScoreMapper {

	@Options(useGeneratedKeys = true,keyProperty = "scoreId")
    @Insert("insert into score(paper_id,student_id,score,answerDate) values(#{paperId},#{studentId},#{score},#{answerDate})")
	int add(Score score);
	
	@Select("select * from score")
	List<Score> findAll();
	
	@Select("select * from score where student_id = #{studentId}")
	List<Score> findById(Integer studentId);
	
	@Select("select max(score) as score from score where paper_id = #{paperId} group by student_id")
	List<Score> findByPaperId(Integer paperId);
}
