package com.xc.ssm.entity;

import org.springframework.stereotype.Component;

@Component
public class Student {
    private Integer id;

    private String sName;

    private Integer sAge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName == null ? null : sName.trim();
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

	@Override
	public String toString() {
		return "Student [id=" + id + ", sName=" + sName + ", sAge=" + sAge + "]";
	}
    
}