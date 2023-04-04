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
import com.chenlong.demo.entity.PaperInfo;

@Mapper
public interface PaperInfoMapper {
	
	@Select("select * from test_paper_info")
	List<PaperInfo> findAll();
	
	@Select("select * from test_paper_info")
	IPage<PaperInfo> findAll(Page page);
	
	/**
	 * 
	 * 新增带有发布位的查询
	 * @return
	 */
	@Select("select * from test_paper_info where publish_flag = '1'")
	List<PaperInfo> findAllByFlag();
	
	@Select("select * from test_paper_info where publish_flag = '1'")
	IPage<PaperInfo> findAllByFlag(Page<PaperInfo> page);
	
	/**
	 * 分界
	 * @param paperId
	 * @return
	 */
	@Select("select * from test_paper_info where paper_id = #{paperId}")
	PaperInfo findById(Integer paperId);
	
	@Delete("delete from test_paper_info where paper_id = #{paperId}")
	int deleteById(Integer paperId);
	
	@Update("update test_paper_info set paper_name = #{paperName},mark = #{mark},totalTime = #{totalTime},"
			+ "type = #{type},publish_flag = #{publishFlag},create_date = #{createDate},tips = #{tips} where paper_id = #{paperId}")
	int updatePaperInfo(PaperInfo paperInfo);
	
	@Options(useGeneratedKeys = true,keyProperty = "paperId")
	@Insert("insert into test_paper_info(paper_name,mark,totalTime,type,publish_flag,create_date,tips) "
			+ "values(#{paperName},#{mark},#{totalTime},#{type},#{publishFlag},#{createDate},#{tips})")
	int addPaperInfo(PaperInfo paperInfo);
	
	@Update("update test_paper_info set publish_flag = #{state} where paper_id = #{paperId}")
	int updatePaperState(Integer paperId, Boolean state);
	
}
