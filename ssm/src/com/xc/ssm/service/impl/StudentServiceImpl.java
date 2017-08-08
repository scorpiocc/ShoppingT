package com.xc.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.xc.ssm.dao.StudentMapper;
import com.xc.ssm.entity.Student;
import com.xc.ssm.service.StudentService;

/**
 * 注入方式一般有两种，一种是按类型注入：@Resource，还有一种按名称注入@Autowired
 * 使用中注入可以属性属性注入，也可以方法注入
 *
 */
@Service
public class StudentServiceImpl implements StudentService{
	private StudentMapper studentMapper;
	@Resource
	public void setStudentMapper(StudentMapper studentMapper) {
		this.studentMapper = studentMapper;
	}
	
	@Override
	public List<Student> queryAllStudent() {
		return studentMapper.selectStudents();
	}

	@Override
	public Student queryStudentBySid(int id) {
		return studentMapper.selectByPrimaryKey(id);
	}

}
