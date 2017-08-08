package com.xc.ssm.handler;

import javax.annotation.Resource;
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
	public String getAllStudents(Model model){
		model.addAttribute("students", studentService.queryAllStudent());
		return "list";
	}
}
