package com.chenlong.demo.service;

import java.util.List;

import com.chenlong.demo.entity.SelectProblem;

public interface SelectService {
	public int addSelect(SelectProblem selectProblem);
	public int deleteSelect(Integer question_id);
	public int updateSelect(SelectProblem selectProblem);
	public SelectProblem findById(Integer question_id);
	public List<SelectProblem> findByIdAndType(Integer PaperId);
	public List<Integer> findByNumber(Integer number);
}
