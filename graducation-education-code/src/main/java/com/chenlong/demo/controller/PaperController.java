package com.chenlong.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sound.midi.SysexMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chenlong.demo.entity.ApiResult;
import com.chenlong.demo.entity.FillProblem;
import com.chenlong.demo.entity.JudgeProblem;
import com.chenlong.demo.entity.PaperManage;
import com.chenlong.demo.entity.SelectProblem;
import com.chenlong.demo.entity.ShortProblem;
import com.chenlong.demo.serviceimpl.FillServiceImpl;
import com.chenlong.demo.serviceimpl.JudgeServiceImpl;
import com.chenlong.demo.serviceimpl.PaperServiceImpl;
import com.chenlong.demo.serviceimpl.SelectServiceImpl;
import com.chenlong.demo.serviceimpl.ShortServiceImpl;
import com.chenlong.demo.util.ApiResultHandler;

@RestController
public class PaperController {

	@Autowired
	private PaperServiceImpl paperServiceImpl;
	
	@Autowired
	private SelectServiceImpl selectServiceImpl;
	
	@Autowired
	private FillServiceImpl fillServiceImpl;
	
	@Autowired
	private JudgeServiceImpl judgeServiceImpl;
	
	@Autowired
	private ShortServiceImpl shortServiceImpl;
	
	@GetMapping("/papers")
	public ApiResult<PaperManage> findAll() {
		ApiResult res =  ApiResultHandler.buildApiResult(200,"请求成功",paperServiceImpl.findAll());
	    return  res;
	}
	
	@PostMapping("/paperManage")
	public ApiResult add(@RequestBody PaperManage paperManage) {
		int res = paperServiceImpl.add(paperManage);
		if (res != 0) {
            return ApiResultHandler.buildApiResult(200,"添加成功",res);
        }
        return ApiResultHandler.buildApiResult(400,"添加失败",res);
	}
	
	@GetMapping("/paper/{paperId}")
	public Map<Integer, List<?>> findById(@PathVariable("paperId") Integer paperId) {
		List<SelectProblem> multiQuestionRes = selectServiceImpl.findByIdAndType(paperId);   //选择题题库 1
        List<FillProblem> fillQuestionsRes = fillServiceImpl.findByIdAndType(paperId);     //填空题题库 2
        List<JudgeProblem> judgeQuestionRes = judgeServiceImpl.findByIdAndType(paperId);   //判断题题库 3
        List<ShortProblem> shortQuestionRes = shortServiceImpl.findByIdAndType(paperId);	//简答题题库 4
        System.out.println("试卷编号： "+paperId);
        System.out.println("选择题： "+multiQuestionRes);
        System.out.println("填空题： "+fillQuestionsRes);
        System.out.println("判断题： "+judgeQuestionRes);
        System.out.println("简答题： "+shortQuestionRes);
        Map<Integer, List<?>> map = new HashMap<>();
        map.put(1,multiQuestionRes);
        map.put(2,fillQuestionsRes);
        map.put(3,judgeQuestionRes);
        map.put(4, shortQuestionRes);
        return  map;
	}
}
