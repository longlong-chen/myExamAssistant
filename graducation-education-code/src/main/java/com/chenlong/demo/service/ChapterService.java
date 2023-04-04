package com.chenlong.demo.service;

import java.util.List;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.Chapter;

public interface ChapterService {
	
	public IPage<Chapter> findAll(Page<Chapter> page);
	public Chapter findById(Integer chapterId);
	public int deleteById(Integer chapterId);
	public int update(Chapter chapter);
	public int addChapter(Chapter chapter);
	public List<Chapter> findAll();
	public List<Chapter> findAllByCourseId(Integer courseId);
}
