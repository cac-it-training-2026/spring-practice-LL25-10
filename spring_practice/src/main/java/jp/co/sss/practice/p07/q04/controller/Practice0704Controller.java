package jp.co.sss.practice.p07.q04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p07.repository.FruitsShopItemRepository;

@Controller
public class Practice0704Controller {

	@Autowired
	FruitsShopItemRepository repository;

	@RequestMapping(path = "/fruits_shop/type/sort/bycount", method = RequestMethod.GET)
	public String showTypeList(Model model) {

		model.addAttribute("types", repository.findQuerySortByTypeCount());

		return "practice07/04/type_list";
	}
}
