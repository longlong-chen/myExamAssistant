package com.chenlong.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaperManage {

	//private Integer id;
	private Integer paperId;
	private Integer questionType;
	private Integer questionId;
	
}
