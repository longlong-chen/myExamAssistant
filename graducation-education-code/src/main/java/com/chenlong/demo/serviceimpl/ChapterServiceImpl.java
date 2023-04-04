package com.chenlong.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.Chapter;
import com.chenlong.demo.mapper.ChapterMapper;
import com.chenlong.demo.service.ChapterService;

@Service
public class ChapterServiceImpl implements ChapterService {

	@Autowired
	private ChapterMapper chapterMapper;
	
	@Override
	public IPage<Chapter> findAll(Page<Chapter> page) {
		// TODO Auto-generated method stub
		return chapterMapper.findAll(page);
	}

	@Override
	public Chapter findById(Integer chapterId) {
		// TODO Auto-generated method stub
		return chapterMapper.findById(chapterId);
	}

	@Override
	public int deleteById(Integer chapterId) {
		// TODO Auto-generated method stub
		return chapterMapper.deleteById(chapterId);
	}

	@Override
	public int update(Chapter chapter) {
		// TODO Auto-generated method stub
		return chapterMapper.update(chapter);
	}

	@Override
	public int addChapter(Chapter chapter) {
		// TODO Auto-generated method stub
		return chapterMapper.addChapter(chapter);
	}

	@Override
	public List<Chapter> findAll() {
		// TODO Auto-generated method stub
		return chapterMapper.findAll();
	}

	@Override
	public List<Chapter> findAllByCourseId(Integer courseId){
		// TODO Auto-generated method stub
		return chapterMapper.findAllByCourseId(courseId);
	}
	
}
