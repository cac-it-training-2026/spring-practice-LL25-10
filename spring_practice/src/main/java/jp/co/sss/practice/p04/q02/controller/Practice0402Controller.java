package jp.co.sss.practice.p04.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Practice0402Controller {
	@RequestMapping("/numguess/start")
	public String showNumguessStart(HttpSession session) {
		Integer hitNumber = (int) (Math.floor(Math.random() * 9) + 1);
		System.out.println("当たりの値:" + hitNumber);

		session.setAttribute("hitNumber", hitNumber);
		return "practice04/02/numguess_start";
	}

	@RequestMapping("/numguess/input")
	public String showNumguessInput() {
		return "practice04/02/numguess_input";
	}

	@RequestMapping("/numguess/hit")
	public String endNumguess(Model model, HttpSession session) {
		Integer hitNumber = (Integer) session.getAttribute("hitNumber");
		String message = "当たり！正解は" + hitNumber + "です。";

		session.removeAttribute("hitNumber");
		model.addAttribute("message", message);
		return "practice04/02/numguess_end";

	}
}
