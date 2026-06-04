package jp.co.sss.practice.p11.q01.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Practice1101Controller {

	@RequestMapping(path = "/fortune", method = RequestMethod.GET)
	public String showFortune(Model model) {

		// 1～5のランダムな値を生成
		Integer fortune = (int) (Math.random() * 5) + 1;

		// 確認用にコンソールへ出力
		System.out.println("おみくじの結果：" + fortune);

		// おみくじの結果をリクエストスコープに保存
		model.addAttribute("fortune", fortune);

		// 動作時の日付を取得し、リクエストスコープに保存
		model.addAttribute("today", new Date());

		return "practice11/01/fortune";
	}
}
