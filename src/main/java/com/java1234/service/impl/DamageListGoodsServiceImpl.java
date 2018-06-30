package com.java1234.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.entity.DamageListGoods;
import com.java1234.repository.DamageListGoodsRepository;
import com.java1234.service.DamageListGoodsService;

/**
 * 商品报损单商品Service实现类
 * @author Administrator
 *
 */
@Service("damageListGoodsService")
public class DamageListGoodsServiceImpl implements DamageListGoodsService{

	@Resource
	private DamageListGoodsRepository damageListGoodsRepository;

	@Override
	public List<DamageListGoods> listByDamageListId(Integer damageListId) {
		return damageListGoodsRepository.listByDamageListId(damageListId);
	}

	
	
}
