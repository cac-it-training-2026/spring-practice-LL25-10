package jp.co.sss.practice.p06.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "area")
public class Area {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_area_gen")
	@SequenceGenerator(name = "seq_area_gen", sequenceName = "seq_area", allocationSize = 1)
	@Column(name = "area_id")
	private Integer areaId;

	@Column(name = "area_name")
	private String areaName;

	@Column(name = "detail")
	private String areaDetail;

	/**
	 * @return areaId
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @param areaId セットする areaId
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @return areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * @param areaName セットする areaName
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * @return areaDetail
	 */
	public String getAreaDetail() {
		return areaDetail;
	}

	/**
	 * @param areaDetail セットする areaDetail
	 */
	public void setAreaDetail(String areaDetail) {
		this.areaDetail = areaDetail;
	}

}
