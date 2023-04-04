package com.chenlong.demo.vo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProblemVO {

	private Integer questionId;
	private String question;
	//private String rightAnswer;
	private Integer score;
	private Integer level;
	private Integer courseId;
	private Integer chapterId;
	private String type;
	
}
