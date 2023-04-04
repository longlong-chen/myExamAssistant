package com.chenlong.demo.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chenlong.demo.entity.JudgeProblem;
import com.chenlong.demo.mapper.JudgeMapper;
import com.chenlong.demo.service.JudgeService;

@Service
public class JudgeServiceImpl implements JudgeService {

	@Autowired
	private JudgeMapper judgeMapper;
	
	@Override
	public int addJudge(JudgeProblem judgeProblem) {
		// TODO Auto-generated method stub
		return judgeMapper.addJudge(judgeProblem);
	}
	
	@Override
	public int deleteJudge(Integer question_id) {
		return judgeMapper.deleteJudge(question_id);
	}
	
	@Override
	public int updateJudge(JudgeProblem judgeProblem) {
		return judgeMapper.updateJudge(judgeProblem);
	}
	
	@Override
	public JudgeProblem findById(Integer question_id) {
		return judgeMapper.findById(question_id);
	}

	@Override
	public List<JudgeProblem> findByIdAndType(Integer paperId) {
		return judgeMapper.findByIdAndType(paperId);
	}
	
	@Override
	public List<Integer> findByNumber(Integer number) {
		return judgeMapper.findByNumber(number);
	}
}
