package com.chenlong.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.chenlong.demo.entity.ApiResult;
import com.chenlong.demo.entity.PaperManage;
import com.chenlong.demo.service.PaperService;
import com.chenlong.demo.serviceimpl.FillServiceImpl;
import com.chenlong.demo.serviceimpl.JudgeServiceImpl;
import com.chenlong.demo.serviceimpl.SelectServiceImpl;
import com.chenlong.demo.serviceimpl.ShortServiceImpl;
import com.chenlong.demo.util.ApiResultHandler;
import com.chenlong.demo.vo.Item;

@RestController
public class ItemController {

	@Autowired
	private SelectServiceImpl selectServiceImpl;
	
	@Autowired
	private FillServiceImpl fillServiceImpl;
	
	@Autowired
	private JudgeServiceImpl judgeServiceImpl;
	
	@Autowired
	private ShortServiceImpl shortServiceImpl;
	
	@Autowired
    PaperService paperService;
	
	@PostMapping("/item")
	public ApiResult ItemController(@RequestBody Item item) {
		System.out.println("进来了吗？");
		// 选择题
        Integer changeNumber = item.getChangeNumber();
        // 填空题
        Integer fillNumber = item.getFillNumber();
        // 判断题
        Integer judgeNumber = item.getJudgeNumber();
        //简答题
        Integer shortNumber = item.getShortNumber();
        //出卷id
        Integer paperId = item.getPaperId();
        
        // 选择题数据库获取
        List<Integer>  changeNumbers = selectServiceImpl.findByNumber(changeNumber);
        if(changeNumbers==null){
            return ApiResultHandler.buildApiResult(400,"选择题数据库获取失败",null);
        }
        for (Integer number : changeNumbers) {
        	PaperManage paperManage = new PaperManage(paperId,1,number);
        	int index = paperService.add(paperManage);
        	if(index==0)
                return ApiResultHandler.buildApiResult(400,"选择题组卷保存失败",null);
        }
        
        // 填空题
        List<Integer> fills = fillServiceImpl.findByNumber(fillNumber);
        if(fills==null)
            return ApiResultHandler.buildApiResult(400,"填空题数据库获取失败",null);
        for (Integer fillNum : fills) {
        	PaperManage paperManage = new PaperManage(paperId,2,fillNum);
            int index = paperService.add(paperManage);
            if(index==0)
                return ApiResultHandler.buildApiResult(400,"填空题题组卷保存失败",null);
        }
        
        // 判断题
        List<Integer> judges = judgeServiceImpl.findByNumber(judgeNumber);
        if(judges==null)
            return ApiResultHandler.buildApiResult(400,"判断题数据库获取失败",null);
        for (Integer judge : judges) {
            PaperManage paperManage = new PaperManage(paperId,3,judge);
            int index = paperService.add(paperManage);
            if(index==0)
                return ApiResultHandler.buildApiResult(400,"判断题题组卷保存失败",null);
        }
        
        //简答题
        List<Integer> shorts = shortServiceImpl.findByNumber(shortNumber);
        if(shorts==null)
            return ApiResultHandler.buildApiResult(400,"简答题数据库获取失败",null);
        for (Integer shrt : shorts) {
        	PaperManage paperManage = new PaperManage(paperId,4,shrt);
        	int index = paperService.add(paperManage);
        	if(index==0)
                return ApiResultHandler.buildApiResult(400,"简答题题组卷保存失败",null);
        }
        return ApiResultHandler.buildApiResult(200,"试卷组卷成功",null);
        
	}
}
