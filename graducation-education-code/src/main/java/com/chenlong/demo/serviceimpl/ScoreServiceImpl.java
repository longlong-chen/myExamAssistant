package com.chenlong.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlong.demo.entity.Score;
import com.chenlong.demo.mapper.ScoreMapper;
import com.chenlong.demo.service.ScoreService;

@Service
public class ScoreServiceImpl implements ScoreService {

	 @Autowired
	 private ScoreMapper scoreMapper;
	 
	@Override
	public int add(Score score) {
		// TODO Auto-generated method stub
		return scoreMapper.add(score);
	}

	@Override
	public List<Score> findAll() {
		// TODO Auto-generated method stub
		return scoreMapper.findAll();
	}

	@Override
	public List<Score> findById(Integer studentId) {
		// TODO Auto-generated method stub
		return scoreMapper.findById(studentId);
	}

	@Override
	public List<Score> findByPaperId(Integer paperId) {
		// TODO Auto-generated method stub
		return scoreMapper.findByPaperId(paperId);
	}

}
