package com.chenlong.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlong.demo.entity.ShortProblem;
import com.chenlong.demo.mapper.ShortMapper;
import com.chenlong.demo.service.ShortService;

@Service
public class ShortServiceImpl implements ShortService {

	@Autowired
	private ShortMapper shortMapper;
	
	@Override
	public int addShort(ShortProblem shortProblem) {
		// TODO Auto-generated method stub
		return shortMapper.addShort(shortProblem);
	}
	
	@Override
	public int deleteShort(Integer question_id) {
		return shortMapper.deleteShort(question_id);
	}
	
	@Override
	public int updateShort(ShortProblem shortProblem) {
		return shortMapper.updateShort(shortProblem);
	}
	
	@Override
	public ShortProblem findById(Integer question_id) {
		return shortMapper.findById(question_id);
	}

	@Override
	public List<ShortProblem> findByIdAndType(Integer paperId) {
		return shortMapper.findByIdAndType(paperId);
	}
	
	@Override
	public List<Integer> findByNumber(Integer number) {
		return shortMapper.findByNumber(number);
	}
}
