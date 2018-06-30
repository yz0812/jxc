package com.java1234.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.java1234.entity.GoodsUnit;

/**
 * 商品单位Repository接口
 * @author Administrator
 *
 */
public interface GoodsUnitRepository extends JpaRepository<GoodsUnit, Integer>{

	
}
