package com.chenlong.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.vo.ProblemVO;

@Mapper
public interface ProblemAllMapper {

	@Select("select question_id, question, score,level,course_id,chapter_id, \"选择题\" as type from selectProblem " +
            "union select question_id, question, score,level,course_id,chapter_id, \"判断题\" as type  from right_or_wrong " +
            "union select question_id, question, score,level,course_id,chapter_id, \"填空题\" as type from filling "
            + "union select question_id, question, score,level,course_id,chapter_id, \"简答题\" as type from short_question")
	IPage<ProblemVO> findAll(Page<ProblemVO> page);
}
