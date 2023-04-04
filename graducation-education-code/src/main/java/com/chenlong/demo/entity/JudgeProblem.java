package com.chenlong.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JudgeProblem {

	private Integer questionId;
	private String question;
	private String analysis;
	private String rightAnswer;
	private Integer score;
	private Integer level;
	private Integer teacherId;
	private Integer courseId;
	private Integer chapterId;
}
