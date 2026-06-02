package jp.co.sss.practice.p06.q02.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p06.entity.Area;
import jp.co.sss.practice.p06.repository.AreaRepository;
import jp.co.sss.practice.p06.repository.FruitsAreaRepository;

@Controller
public class Practice0602Controller {

	@Autowired
	FruitsAreaRepository fruitsAreaRepository;

	@Autowired
	AreaRepository areaRepository;

	// 種別選択画面表示用
	@RequestMapping(path = "/fruits/select/area", method = RequestMethod.GET)
	public String showAreaSelect(Model model) {

		model.addAttribute("areas", areaRepository.findAllByOrderByAreaIdAsc());

		return "practice06/02/area_select";
	}

	// 検索処理、結果表示用
	@RequestMapping(path = "/fruits/select/area/result", method = RequestMethod.GET)
	public String showFruitsAreaResult(Integer areaId, Model model) {

		Optional<Area> result = areaRepository.findById(areaId);

		if (result.isPresent()) {
			Area area = result.get();

			model.addAttribute("areaName", area.getAreaName());
		}

		model.addAttribute("fruits", fruitsAreaRepository.findByAreaAreaIdOrderByFruitIdAsc(areaId));

		return "practice06/02/fruits_list";
	}
}
