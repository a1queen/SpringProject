package com.example.frontcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/success")
@Controller
public class SuccessController {
	@GetMapping
	public String success() {
		return "success";
	}
}
