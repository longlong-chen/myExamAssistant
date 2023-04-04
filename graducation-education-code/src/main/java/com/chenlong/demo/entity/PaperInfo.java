package com.chenlong.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PaperInfo {

	private Integer paperId;
	private String paperName;
	private Integer teacherId;
	private Integer mark;
	private Integer totalTime;
	private String type;
	private String createDate;
	private Boolean publishFlag;
	private String tips;
	
}
