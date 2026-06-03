package jp.co.sss.practice.p07.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import jp.co.sss.practice.p07.entity.FruitsShopItem;
import jp.co.sss.practice.p07.entity.Type;

public interface FruitsShopItemRepository extends JpaRepository<FruitsShopItem, Integer> {

	//Practice7-03
	@Query("select f from FruitsShopItem f where f.price BETWEEN :min AND :max AND f.type=:type ORDER BY f.price,f.itemId")
	List<FruitsShopItem> findQueryByPriceRangeAndType(Integer min, Integer max, Type type);

	//7-04
	@Query("select t from FruitsShopItem f inner join Type t on f.type.typeId = t.typeId group by t order by count(f.type) desc, t.typeId")
	List<Type> findQuerySortByTypeCount();

}
