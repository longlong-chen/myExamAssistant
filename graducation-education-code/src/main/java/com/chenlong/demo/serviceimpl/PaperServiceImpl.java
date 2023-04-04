package com.chenlong.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlong.demo.entity.PaperManage;
import com.chenlong.demo.mapper.PaperMapper;
import com.chenlong.demo.service.PaperService;

@Service
public class PaperServiceImpl implements PaperService {

	@Autowired
	private PaperMapper paperMapper;
	
	@Override
	public List<PaperManage> findAll() {
		// TODO Auto-generated method stub
		return paperMapper.findAll();
	}

	@Override
	public List<PaperManage> findById(Integer paperId) {
		// TODO Auto-generated method stub
		return paperMapper.findById(paperId);
	}

	@Override
	public int add(PaperManage paperManage) {
		// TODO Auto-generated method stub
		return paperMapper.add(paperManage);
	}

}
