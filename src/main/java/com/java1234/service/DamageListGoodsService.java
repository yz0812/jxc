package com.java1234.service;

import java.util.List;

import com.java1234.entity.DamageListGoods;

/**
 * 商品报损单商品Service接口
 * @author Administrator
 *
 */
public interface DamageListGoodsService {

	/**
	 * 根据商品报损单id查询所有商品报损单商品
	 * @param damageListId
	 * @return
	 */
	public List<DamageListGoods> listByDamageListId(Integer damageListId);
	
}
