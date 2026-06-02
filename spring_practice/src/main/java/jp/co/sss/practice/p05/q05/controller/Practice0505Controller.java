package jp.co.sss.practice.p05.q05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0505Controller {

	@Autowired
	FruitsSeasonRepository repository;

	// 入力画面表示用
	@RequestMapping(path = "/fruits/add/input", method = RequestMethod.GET)
	public String showFruitInput() {

		return "practice05/05/fruit_input";
	}

	// 登録受付、登録処理、登録完了画面表示用
	@RequestMapping(path = "/fruits/add/complete", method = RequestMethod.POST)
	public String addFruitComplete(FruitsSeasonForm fruitForm, Model model) {

		// FruitsSeasonエンティティの生成
		FruitsSeason fruit = new FruitsSeason();

		// Formの内容をEntityにコピー
		fruit.setFruitName(fruitForm.getFruitName());
		fruit.setSeasonMonth(fruitForm.getSeasonMonth());

		// DBに登録
		FruitsSeason savedFruit = repository.save(fruit);

		// JavaBeanのオブジェクトを生成
		FruitsSeasonBean fruitBean = new FruitsSeasonBean();

		// 登録結果EntityをJavaBeanにコピー
		fruitBean.setFruitId(savedFruit.getFruitId());
		fruitBean.setFruitName(savedFruit.getFruitName());
		fruitBean.setSeasonMonth(savedFruit.getSeasonMonth());

		// JavaBeanをリクエストスコープに保存
		model.addAttribute("fruit", fruitBean);

		return "practice05/05/fruit_detail";
	}
}
