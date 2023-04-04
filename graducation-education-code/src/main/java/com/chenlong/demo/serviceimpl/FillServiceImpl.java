package com.chenlong.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlong.demo.entity.FillProblem;
import com.chenlong.demo.mapper.FillMapper;
import com.chenlong.demo.service.FillService;

@Service
public class FillServiceImpl implements FillService {

	@Autowired
	private FillMapper fillMapper;
	
	@Override
	public int addFill(FillProblem fillProblem) {
		// TODO Auto-generated method stub
		return fillMapper.addFill(fillProblem);
	}
	
	@Override
	public int deleteFill(Integer question_id) {
		return fillMapper.deleteFill(question_id);
	}
	
	@Override
	public int updateFill(FillProblem fillProblem) {
		return fillMapper.updateFill(fillProblem);
	}
	
	@Override
	public FillProblem findById(Integer question_id) {
		return fillMapper.findById(question_id);
	}
	
	@Override
	public List<FillProblem> findByIdAndType(Integer paperId) {
		return fillMapper.findByIdAndType(paperId);
	}
	
	@Override
	public List<Integer> findByNumber(Integer number) {
		return fillMapper.findByNumber(number);
	}

}
