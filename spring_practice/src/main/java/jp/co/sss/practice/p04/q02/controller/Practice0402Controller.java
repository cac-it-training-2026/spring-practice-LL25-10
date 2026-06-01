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

	@RequestMapping("/numguess/judge")
	public String endNumguess(HttpSession session, Integer inputNum) {
		Integer hitNumber = (Integer) session.getAttribute("hitNumber");
		if (hitNumber != null && hitNumber.equals(inputNum)) {

			return "redirect:/numguess/hit";

		} else {

			return "practice04/02/numguess_judge";
		}

	}

	@RequestMapping("/numguess/hit")
	public String hit(Model model, HttpSession session) {

		Integer hitNumber = (Integer) session.getAttribute("hitNumber");

		String message = "当たりです！ 正解は" + hitNumber + "でした。";

		model.addAttribute("message", message);

		session.removeAttribute("hitNumber");

		return "practice04/02/numguess_end";
	}

}
