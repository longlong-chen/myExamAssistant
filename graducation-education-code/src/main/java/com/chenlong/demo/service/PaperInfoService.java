package com.chenlong.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.PaperInfo;

public interface PaperInfoService {

	List<PaperInfo> findAll();
	IPage<PaperInfo> findAll(Page<PaperInfo> page);
	/**
	 * 新增带有发布位的查询
	 * @return
	 */
	List<PaperInfo> findAllByFlag();
	IPage<PaperInfo> findAllByFlag(Page<PaperInfo> page);
	
	PaperInfo findById(Integer paperId);
	int deleteById(Integer paperId);
	int updatePaperInfo(PaperInfo paperInfo);
	int addPaperInfo(PaperInfo paperInfo);
	int updatePaperState(Integer paperId, Boolean state);
}
