package com.chenlong.demo.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Admin {
	 	private Integer administratorId;
	    private String administratorName;
	    private String administratorPassword;
	    private String administratorPhone;
	    private String administratorEmail;
	    private Boolean disabledFlag;
	    private Integer role;
	    private Integer sex;
}
