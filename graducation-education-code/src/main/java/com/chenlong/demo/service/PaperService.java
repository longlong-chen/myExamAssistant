package com.chenlong.demo.service;

import java.util.List;

import com.chenlong.demo.entity.PaperManage;

public interface PaperService {

	public List<PaperManage> findAll();

	public List<PaperManage> findById(Integer paperId);

	public int add(PaperManage paperManage);
}
