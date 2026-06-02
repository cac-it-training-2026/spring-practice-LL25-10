package jp.co.sss.practice.p05.q06.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.bean.FruitsSeasonBean;
import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.form.FruitsSeasonForm;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller
public class Practice0506Controller {

	@Autowired
	FruitsSeasonRepository repository;

	// メソッド1：フルーツ名選択画面表示用
	@RequestMapping(path = "/fruits/update", method = RequestMethod.GET)
	public String updateSelect(Model model) {

		// フルーツ情報一覧をDBから取得し、リクエストスコープに保存
		model.addAttribute("fruits", repository.findAllByOrderByFruitIdAsc());

		return "practice05/06/fruit_select";
	}

	// メソッド2：入力画面表示用
	@RequestMapping(path = "/fruits/update/input", method = RequestMethod.POST)
	public String updateInput(Integer fruitId, Model model) {

		// パラメータとして受け取ったフルーツIDで主キー検索
		Optional<FruitsSeason> result = repository.findById(fruitId);

		// JavaBeanのオブジェクトを生成
		FruitsSeasonBean fruitBean = new FruitsSeasonBean();

		// 検索結果をJavaBeanにコピー
		if (result.isPresent()) {
			FruitsSeason fruit = result.get();

			fruitBean.setFruitId(fruit.getFruitId());
			fruitBean.setFruitName(fruit.getFruitName());
			fruitBean.setSeasonMonth(fruit.getSeasonMonth());
		}

		// JavaBeanをリクエストスコープに保存
		model.addAttribute("fruit", fruitBean);

		return "practice05/06/fruit_input";
	}

	// メソッド3：更新受付、更新処理、更新完了画面表示用
	@RequestMapping(path = "/fruits/update/complete/{fruitId}", method = RequestMethod.POST)
	public String updateComplete(@PathVariable Integer fruitId, FruitsSeasonForm fruitForm, Model model) {

		// FruitsSeasonエンティティの生成
		FruitsSeason fruit = new FruitsSeason();

		// EntityにIDと入力値をコピー
		fruit.setFruitId(fruitId);
		fruit.setFruitName(fruitForm.getFruitName());
		fruit.setSeasonMonth(fruitForm.getSeasonMonth());

		// DBの該当レコードを更新
		FruitsSeason savedFruit = repository.save(fruit);

		// JavaBeanのオブジェクトを生成
		FruitsSeasonBean fruitBean = new FruitsSeasonBean();

		// 更新結果をJavaBeanにコピー
		fruitBean.setFruitId(savedFruit.getFruitId());
		fruitBean.setFruitName(savedFruit.getFruitName());
		fruitBean.setSeasonMonth(savedFruit.getSeasonMonth());

		// JavaBeanをリクエストスコープに保存
		model.addAttribute("fruit", fruitBean);

		return "practice05/06/fruit_detail";
	}
}
