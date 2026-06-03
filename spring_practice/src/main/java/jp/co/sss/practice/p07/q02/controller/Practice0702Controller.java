package jp.co.sss.practice.p07.q02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jp.co.sss.practice.p07.entity.FruitsShopItem;
import jp.co.sss.practice.p07.entity.Type;
import jp.co.sss.practice.p07.repository.TypeRepository;

@Controller
public class Practice0702Controller {

	@Autowired
	TypeRepository typeRepository;

	@Autowired
	EntityManager entityManager;

	// 検索条件入力画面表示用
	@RequestMapping(path = "/fruits_shop/named/input", method = RequestMethod.GET)
	public String showSearchInput(Model model) {

		model.addAttribute("types", typeRepository.findAll());

		return "practice07/02/search_input";
	}

	// 表示情報の取得、結果表示用
	@RequestMapping(path = "/fruits_shop/named/result", method = RequestMethod.GET)
	public String showSearchResult(Integer minPrice, Integer maxPrice, Integer typeId, Model model) {

		// Typeエンティティのオブジェクトを生成し、入力されたtypeIdをセット
		Type type = new Type();
		type.setTypeId(typeId);

		// NamedQueryを利用してQueryオブジェクトを生成
		TypedQuery<FruitsShopItem> query = entityManager.createNamedQuery(
				"findNamedQueryByPriceRangeAndType",
				FruitsShopItem.class);

		// JPQLのパラメータに値をセット
		query.setParameter("min", minPrice);
		query.setParameter("max", maxPrice);
		query.setParameter("type", type);

		// JPQLを実行し、検索結果を取得
		List<FruitsShopItem> items = query.getResultList();

		// 検索結果をリクエストスコープに保存
		model.addAttribute("items", items);

		return "practice07/02/items_list";
	}
}
