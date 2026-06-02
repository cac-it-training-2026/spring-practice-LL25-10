package jp.co.sss.practice.p05.q04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0504Controller {

	@Autowired
	FruitsSeasonRepository repository;

	// 季節選択画面表示用
	@RequestMapping(path = "/fruits/search/input", method = RequestMethod.GET)
	public String showSearchInput() {

		return "practice05/04/fruits_select_season";
	}

	// 検索処理、結果表示用
	@RequestMapping(path = "/fruits/search/result", method = RequestMethod.GET)
	public String showSearchResult(Integer season, Model model) {

		model.addAttribute("fruits", repository.findBySeasonMonthOrderByFruitIdAsc(season));

		String condition;

		if (season == 13) {
			condition = "通年";
		} else {
			condition = season + "月";
		}

		model.addAttribute("condition", condition);

		return "practice05/04/fruits_list";
	}
}
