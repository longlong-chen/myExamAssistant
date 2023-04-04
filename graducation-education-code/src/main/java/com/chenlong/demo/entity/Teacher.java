package com.chenlong.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Teacher {
	private Integer teacherId;
    private String teacherName;
    private String teacherPassword;
    private String teacherPhone;
    private String teacherEmail;
    private String teacherType;
    private Integer disabledFlag;
    private Integer role;
    private Integer sex;
}
