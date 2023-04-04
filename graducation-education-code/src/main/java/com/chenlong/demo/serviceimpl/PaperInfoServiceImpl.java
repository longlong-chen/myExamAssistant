package com.chenlong.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.PaperInfo;
import com.chenlong.demo.mapper.PaperInfoMapper;
import com.chenlong.demo.service.PaperInfoService;

@Service
public class PaperInfoServiceImpl implements PaperInfoService {

	@Autowired
	private PaperInfoMapper paperInfoMapper;
	
	@Override
	public List<PaperInfo> findAll() {
		// TODO Auto-generated method stub
		return paperInfoMapper.findAll();
	}

	@Override
	public IPage<PaperInfo> findAll(Page<PaperInfo> page) {
		// TODO Auto-generated method stub
		return paperInfoMapper.findAll(page);
	}

	/**
	 * 
	 * 新增带有发布位的查询
	 * @return
	 */
	@Override
	public List<PaperInfo> findAllByFlag(){
		return paperInfoMapper.findAllByFlag();
	}
	@Override
	public IPage<PaperInfo> findAllByFlag(Page<PaperInfo> page){
		return paperInfoMapper.findAllByFlag(page);
	}
	
	//分界
	@Override
	public PaperInfo findById(Integer paperId) {
		// TODO Auto-generated method stub
		return paperInfoMapper.findById(paperId);
	}

	@Override
	public int deleteById(Integer paperId) {
		// TODO Auto-generated method stub
		return paperInfoMapper.deleteById(paperId);
	}

	@Override
	public int updatePaperInfo(PaperInfo paperInfo) {
		// TODO Auto-generated method stub
		return paperInfoMapper.updatePaperInfo(paperInfo);
	}

	@Override
	public int addPaperInfo(PaperInfo paperInfo) {
		// TODO Auto-generated method stub
		return paperInfoMapper.addPaperInfo(paperInfo);
	}
	
	@Override
	public int updatePaperState(Integer paperId, Boolean state) {
		// TODO Auto-generated method stub
		return paperInfoMapper.updatePaperState(paperId, state);
	}

}
