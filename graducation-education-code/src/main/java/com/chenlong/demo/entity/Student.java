package com.chenlong.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
	private Integer studentId;
	private String studentName;
	private String studentPassword;
	private String studentPhone;
    private String studentEmail;
    private Integer role;
    private Boolean disabledFlag;
    private String studentSchool;
    private String studentMajor;
    private Integer sex;
}
