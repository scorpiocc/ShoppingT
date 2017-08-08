package com.xc.ssm.service;

import java.util.List;

import com.xc.ssm.entity.Student;

public interface StudentService {
	public List<Student> queryAllStudent();
	
	public Student queryStudentBySid(int id);
}
