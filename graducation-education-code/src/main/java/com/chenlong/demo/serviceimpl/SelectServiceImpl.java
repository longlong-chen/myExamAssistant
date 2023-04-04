package com.chenlong.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlong.demo.entity.SelectProblem;
import com.chenlong.demo.mapper.SelectMapper;
import com.chenlong.demo.service.SelectService;

@Service
public class SelectServiceImpl implements SelectService {

	@Autowired
	private SelectMapper selectMapper;
	
	@Override
	public int addSelect(SelectProblem selectProblem) {
		// TODO Auto-generated method stub
		return selectMapper.addSelect(selectProblem);
	}
	
	@Override
	public int deleteSelect(Integer question_id) {
		return selectMapper.deleteSelect(question_id);
	}
	
	@Override
	public int updateSelect(SelectProblem selectProblem) {
		return selectMapper.updateSelect(selectProblem);
	}
	
	@Override
	public SelectProblem findById(Integer question_id) {
		return selectMapper.findById(question_id);
	}

	@Override
	public List<SelectProblem> findByIdAndType(Integer PaperId) {
		return selectMapper.findByIdAndType(PaperId);
	}
	
	@Override
	public List<Integer> findByNumber(Integer number) {
		return selectMapper.findByNumber(number);
	}
}
