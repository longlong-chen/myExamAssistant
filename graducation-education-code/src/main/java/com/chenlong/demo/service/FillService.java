package com.chenlong.demo.service;

import java.util.List;

import com.chenlong.demo.entity.FillProblem;

public interface FillService {
	public int addFill(FillProblem fillProblem);
	public int deleteFill(Integer question_id);
	public int updateFill(FillProblem fillProblem);
	public FillProblem findById(Integer question_id);
	public List<FillProblem> findByIdAndType(Integer paperId);
	public List<Integer> findByNumber(Integer number);
}
