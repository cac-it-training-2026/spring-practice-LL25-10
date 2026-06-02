package jp.co.sss.practice.p06.q01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p06.repository.FruitsAreaRepository;

@Controller
public class Practice0601Controller {

	@Autowired
	FruitsAreaRepository repository;

	@RequestMapping(path = "/fruits/area/list/all", method = RequestMethod.GET)
	public String showFruitsAreaList(Model model) {

		model.addAttribute("fruits", repository.findAll());

		return "practice06/01/fruits_list";
	}
}
