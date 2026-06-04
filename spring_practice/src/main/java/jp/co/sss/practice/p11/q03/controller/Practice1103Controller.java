package jp.co.sss.practice.p11.q03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Practice1103Controller {

	@RequestMapping("/layout/first")
	public String showLayoutFirst() {
		return "Practice11/03/first";
	}

	@RequestMapping("/layout/second")
	public String showLayoutSecond() {
		return "Practice11/03/second";
	}

	@RequestMapping("/layout/third")
	public String showLayoutThird() {
		return "Practice11/03/third";
	}
}
