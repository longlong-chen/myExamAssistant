package com.chenlong.demo.service;

import java.util.List;

import com.chenlong.demo.entity.ShortProblem;

public interface ShortService {
	public int addShort(ShortProblem shortProblem);
	public int deleteShort(Integer question_id);
	public int updateShort(ShortProblem shortProblem);
	public ShortProblem findById(Integer question_id);
	public List<ShortProblem> findByIdAndType(Integer paperId);
	public List<Integer> findByNumber(Integer number);
}
