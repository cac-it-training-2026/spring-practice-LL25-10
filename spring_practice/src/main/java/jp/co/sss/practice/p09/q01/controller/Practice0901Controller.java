package jp.co.sss.practice.p09.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import jp.co.sss.practice.p09.q01.form.PersonalInfoForm;

@Controller
public class Practice0901Controller {

	// 入力画面表示用
	@RequestMapping(path = "/personal_info/input", method = RequestMethod.GET)
	public String showInput(@ModelAttribute PersonalInfoForm personalInfoForm) {

		return "practice09/01/info_input";
	}

	// 入力チェック処理用
	@RequestMapping(path = "/personal_info/check", method = RequestMethod.POST)
	public String checkInput(@Valid @ModelAttribute PersonalInfoForm personalInfoForm, BindingResult result) {

		if (result.hasErrors()) {
			return "practice09/01/info_input";
		}

		return "practice09/01/input_ok";
	}
}
