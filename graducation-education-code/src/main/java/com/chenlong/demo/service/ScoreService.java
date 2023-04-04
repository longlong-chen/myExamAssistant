package com.chenlong.demo.service;

import java.util.List;

import com.chenlong.demo.entity.Score;

public interface ScoreService {

	int add(Score score);
	
	List<Score> findAll();
	
	List<Score> findById(Integer studentId);
	
	List<Score> findByPaperId(Integer paperId);
}
