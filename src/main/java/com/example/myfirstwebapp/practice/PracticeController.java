package com.example.myfirstwebapp.practice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PracticeController {

	@RequestMapping("practice")
	public String practice() {

		return "Practice";
	}
}
