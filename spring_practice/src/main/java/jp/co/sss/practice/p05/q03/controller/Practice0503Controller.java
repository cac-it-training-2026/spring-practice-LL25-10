package jp.co.sss.practice.p05.q03.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0503Controller {
	@Autowired
	FruitsSeasonRepository repository;

	// 一覧画面表示用
	@RequestMapping(path = "/fruits/list/sort/id", method = RequestMethod.GET)
	public String showFruitsList(Model model) {

		model.addAttribute("fruits", repository.findAllByOrderByFruitIdAsc());

		return "practice05/03/fruits_list";
	}

	// 主キーでの検索処理、結果表示用
	@RequestMapping(path = "/fruits/detail/{fruitId}", method = RequestMethod.GET)
	public String showFruitDetail(@PathVariable Integer fruitId, Model model) {

		// 主キー検索
		Optional<FruitsSeason> result = repository.findById(fruitId);

		// JavaBeanのオブジェクトを生成
		FruitsSeasonBean bean = new FruitsSeasonBean();

		// 検索結果が存在する場合、EntityからBeanへコピー
		if (result.isPresent()) {
			FruitsSeason fruit = result.get();

			bean.setFruitId(fruit.getFruitId());
			bean.setFruitName(fruit.getFruitName());
			bean.setSeasonMonth(fruit.getSeasonMonth());
		}

		// JavaBeanのオブジェクトをリクエストスコープに保存
		model.addAttribute("fruit", bean);

		return "practice05/03/fruit_detail";
	}
}
