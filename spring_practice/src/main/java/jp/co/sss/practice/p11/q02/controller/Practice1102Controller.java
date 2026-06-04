package jp.co.sss.practice.p11.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Practice1102Controller {

	// 入力画面表示用
	@RequestMapping(path = "/checkbox/input", method = RequestMethod.GET)
	public String showCheckboxInput() {

		return "practice11/02/checkbox_input";
	}

	// 入力値の受け取り処理用
	@RequestMapping(path = "/checkbox/result", method = RequestMethod.POST)
	public String showCheckboxResult(Model model, String[] destPrefs) {

		// 入力値が格納されたdestPrefsをリクエストスコープに保存
		model.addAttribute("destPrefs", destPrefs);

		return "practice11/02/result";
	}
}
