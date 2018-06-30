package com.java1234.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.entity.GoodsUnit;
import com.java1234.repository.GoodsUnitRepository;
import com.java1234.service.GoodsUnitService;

/**
 * 商品单位Service实现类
 * @author Administrator
 *
 */
@Service("goodsUnitService")
public class GoodsUnitServiceImpl implements GoodsUnitService{

	@Resource
	private GoodsUnitRepository goodsUnitRepository;


	@Override
	public void save(GoodsUnit goodsUnit) {
		goodsUnitRepository.save(goodsUnit);
	}

	@Override
	public void delete(Integer id) {
		goodsUnitRepository.delete(id);
	}

	@Override
	public GoodsUnit findById(Integer id) {
		return goodsUnitRepository.findOne(id);
	}

	@Override
	public List<GoodsUnit> listAll() {
		return goodsUnitRepository.findAll();
	}




}
