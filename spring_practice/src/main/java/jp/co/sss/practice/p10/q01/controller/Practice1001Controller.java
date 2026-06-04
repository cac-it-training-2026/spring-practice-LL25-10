package jp.co.sss.practice.p10.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Practice1001Controller {

	// 通常遷移用
	@RequestMapping(path = "/filter/def", method = RequestMethod.GET)
	public String showFilterView() {

		return "practice10/01/filter_view";
	}

	// リダイレクトの動作確認用
	@RequestMapping(path = "/filter/xyz", method = RequestMethod.GET)
	public String showFilterRedirect() {

		return "practice10/01/filter_redirect";
	}

}
