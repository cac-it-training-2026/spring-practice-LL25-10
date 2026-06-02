package jp.co.sss.practice.p06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "fruits_area")
public class FruitsArea {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_fruits_area_gen")
	@SequenceGenerator(name = "seq_fruits_area_gen", sequenceName = "seq_fruits_area", allocationSize = 1)
	@Column(name = "fruit_id")
	private Integer fruitId;

	@Column(name = "fruit_name")
	private String fruitName;

	@ManyToOne
	@JoinColumn(name = "area_id", referencedColumnName = "area_id")
	private Area area;

	/**
	 * @return fruitId
	 */
	public Integer getFruitId() {
		return fruitId;
	}

	/**
	 * @param fruitId セットする fruitId
	 */
	public void setFruitId(Integer fruitId) {
		this.fruitId = fruitId;
	}

	/**
	 * @return fruitName
	 */
	public String getFruitName() {
		return fruitName;
	}

	/**
	 * @param fruitName セットする fruitName
	 */
	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	/**
	 * @return area
	 */
	public Area getArea() {
		return area;
	}

	/**
	 * @param area セットする area
	 */
	public void setArea(Area area) {
		this.area = area;
	}

}
