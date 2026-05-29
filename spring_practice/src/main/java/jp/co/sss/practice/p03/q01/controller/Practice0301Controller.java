package jp.co.sss.practice.p03.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Practice0301Controller {

	@RequestMapping("/input")
	public String showInputPage() {
		return "Practice03/01/input_form";
	}

	@RequestMapping("/send/get_method")
	public String getResult(String color) {
		System.out.println("##GETメソッドで受け取りました");
		System.out.println("##パラメータの値:" + color);
		return "Practice03/01/get_result";
	}

	@RequestMapping(path = "/send/post_method", method = RequestMethod.POST)
	public String postResult(String color) {
		System.out.println("==POSTメソッドで受け取りました");
		System.out.println("==パラメータの値:" + color);
		return "Practice03/01/post_result";
	}
}
