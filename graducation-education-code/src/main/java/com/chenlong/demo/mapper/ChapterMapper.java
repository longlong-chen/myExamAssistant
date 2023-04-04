package com.chenlong.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chenlong.demo.entity.Chapter;

@Mapper
public interface ChapterMapper {
	
	/**
	 * 分页查询
	 * @param page
	 * @return
	 */
	@Select("select * from chapter")
	public IPage<Chapter> findAll(Page<Chapter> page);
	
	@Select("select * from chapter where chapter_id = #{chapterId}")
	public Chapter findById(Integer chapterId);
	
	//删除章节
	@Delete("delete from chapter where chapter_id = #{chapterId}")
	public int deleteById(Integer chapterId);
	
	//更新章节
	@Update("update chapter set chapter_name = #{chapterName},course_id = #{courseId} where chapter_id = #{chapterId}")
	public int update(Chapter chapter);
	
	//添加章节
	@Options(useGeneratedKeys = true,keyProperty = "chapterId")
	@Insert("insert into chapter(chapter_name,course_id) values(#{chapterName},#{courseId})")
	public int addChapter(Chapter chapter);
	
	/**
	 * 按List查询
	 * @return
	 */
	@Select("select * from chapter")
	public List<Chapter> findAll();
	
	/**
	 * 按课程Id选择章节
	 * @param courseId
	 * @return
	 */
	@Select("select * from chapter where course_id = #{courseId}")
	public List<Chapter> findAllByCourseId(Integer courseId);
	
}
