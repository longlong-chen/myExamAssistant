package com.chenlong.demo.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.mapper.ProblemAllMapper;
import com.chenlong.demo.service.ProblemAllService;
import com.chenlong.demo.vo.ProblemVO;

@Service
public class ProblemAllServiceImpl implements ProblemAllService {

	@Autowired
	private ProblemAllMapper problemAllMapper;
	
	@Override
	public IPage<ProblemVO> findAll(Page<ProblemVO> page) {
		// TODO Auto-generated method stub
		return problemAllMapper.findAll(page);
	}

}
