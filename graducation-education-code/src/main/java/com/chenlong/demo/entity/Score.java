package com.chenlong.demo.entity;

import lombok.Data;

@Data
public class Score {

	private Integer scoreId;
	private Integer paperId;
	private Integer studentId;
	private Integer score;
	private String answerDate;
}
