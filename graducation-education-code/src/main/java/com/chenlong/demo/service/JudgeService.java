package com.chenlong.demo.service;

import java.util.List;

import com.chenlong.demo.entity.JudgeProblem;

public interface JudgeService {
	public int addJudge(JudgeProblem judgeProblem);
	public int deleteJudge(Integer question_id);
	public int updateJudge(JudgeProblem judgeProblem);
	public JudgeProblem findById(Integer question_id);
	public List<JudgeProblem> findByIdAndType(Integer paperId);
	public List<Integer> findByNumber(Integer number);
}
