package jp.co.sss.practice.p08.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.validation.Valid;
import jp.co.sss.practice.p08.q01.form.BodyTempForm;

@Controller
public class Practice0801Controller {

	// 入力画面表示用
	@RequestMapping(path = "/body_temp/input", method = RequestMethod.GET)
	public String showInput(@ModelAttribute BodyTempForm bodyTempForm) {

		return "practice08/01/bt_input";
	}

	// 入力チェック処理用
	@RequestMapping(path = "/body_temp/check", method = RequestMethod.POST)
	public String checkBodyTemp(@Valid @ModelAttribute BodyTempForm bodyTempForm, BindingResult result) {

		// 入力チェックでエラーがあった場合
		if (result.hasErrors()) {
			return "practice08/01/bt_input";
		}

		// 体温が正常範囲の場合：35.0より高く、37.5より低い
		if (bodyTempForm.getBodyTemp() > 35.0 && bodyTempForm.getBodyTemp() < 37.5) {
			return "practice08/01/bt_ok";
		}

		// 正常範囲外の場合
		return "practice08/01/bt_ng";
	}
}
