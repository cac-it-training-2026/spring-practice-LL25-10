package jp.co.sss.practice.p07.q01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p07.repository.FruitsShopItemRepository;

@Controller
public class Practice0701Controller {

	@Autowired
	FruitsShopItemRepository repository;

	@RequestMapping(path = "/fruits_shop", method = RequestMethod.GET)
	public String showFruitsShop(Model model) {

		model.addAttribute("items", repository.findAll());

		return "practice07/01/items_list";
	}
}
