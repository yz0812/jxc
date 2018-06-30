package com.java1234.service.impl;


import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.java1234.entity.Goods;
import com.java1234.entity.DamageList;
import com.java1234.entity.DamageListGoods;
import com.java1234.repository.GoodsRepository;
import com.java1234.repository.GoodsTypeRepository;
import com.java1234.repository.DamageListGoodsRepository;
import com.java1234.repository.DamageListRepository;
import com.java1234.service.DamageListService;

/**
 * 商品报损单Service实现类
 * @author Administrator
 *
 */
@Service("damageListService")
public class DamageListServiceImpl implements DamageListService{

	@Resource
	private DamageListRepository damageListRepository;
	
	@Resource
	private GoodsTypeRepository goodsTypeRepository;
	
	@Resource
	private GoodsRepository goodsRepository;
	
	@Resource
	private DamageListGoodsRepository damageListGoodsRepository;

	@Override
	public String getTodayMaxDamageNumber() {
		return damageListRepository.getTodayMaxDamageNumber();
	}

	@Transactional
	public void save(DamageList damageList, List<DamageListGoods> damageListGoodsList) {
		for(DamageListGoods damageListGoods:damageListGoodsList){
			damageListGoods.setType(goodsTypeRepository.findOne(damageListGoods.getTypeId())); // 设置类别
			damageListGoods.setDamageList(damageList); // 设置商品报损单
			damageListGoodsRepository.save(damageListGoods);
			// 修改商品库存
			Goods goods=goodsRepository.findOne(damageListGoods.getGoodsId());
			
			goods.setInventoryQuantity(goods.getInventoryQuantity()-damageListGoods.getNum());
			goods.setState(2);
			goodsRepository.save(goods);
		}
		damageListRepository.save(damageList); // 保存商品报损单
	}

	@Override
	public List<DamageList> list(DamageList damageList, Direction direction, String... properties) {
		return damageListRepository.findAll(new Specification<DamageList>() {
			
			@Override
			public Predicate toPredicate(Root<DamageList> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				Predicate predicate=cb.conjunction();
				if(damageList!=null){
					if(damageList.getbDamageDate()!=null){
						predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get("damageDate"), damageList.getbDamageDate()));
					}
					if(damageList.geteDamageDate()!=null){
						predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get("damageDate"), damageList.geteDamageDate()));
					}
				}
				return predicate;
			}
		},new Sort(direction, properties));
	}

	@Override
	public DamageList findById(Integer id) {
		return damageListRepository.findOne(id);
	}


	

}
