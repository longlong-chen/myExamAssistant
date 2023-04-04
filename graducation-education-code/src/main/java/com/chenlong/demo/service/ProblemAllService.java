package com.chenlong.demo.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.vo.ProblemVO;

public interface ProblemAllService {
	IPage<ProblemVO> findAll(Page<ProblemVO> page);
}
