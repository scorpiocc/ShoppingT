package com.xc.ssm.handler;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xc.ssm.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentHandler {
	@Resource
	private StudentService studentService;

	@RequestMapping("/list")
	public String getAllStudents(Model model,HttpServletRequest request, HttpServletResponse response){
		model.addAttribute("students", studentService.queryAllStudent());
		
		
		return "list";
	}
}
