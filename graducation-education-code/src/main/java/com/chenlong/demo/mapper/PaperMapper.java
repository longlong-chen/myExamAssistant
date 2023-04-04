package com.chenlong.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.chenlong.demo.entity.PaperManage;

@Mapper
public interface PaperMapper {

	@Select("select paper_id, questionType,question_id from paper_manage")
	List<PaperManage> findAll();
	
	@Select("select paper_id, questionType,question_id from paper_manage where question_id = #{paperId}")
	List<PaperManage> findById(Integer paperId);
	
	@Insert("insert into paper_manage(paper_id,questionType,question_id) values " +
	            "(#{paperId},#{questionType},#{questionId})")
	int add(PaperManage paperManage);
	
}
