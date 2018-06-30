package com.java1234.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java1234.entity.GoodsType;

/**
 * 商品类别Repository接口
 * @author Administrator
 *
 */
public interface GoodsTypeRepository extends JpaRepository<GoodsType, Integer>{

	
	/**
	 * 根据父节点查找所有子节点
	 * @param parentId
	 * @return
	 */
	@Query(value="select * from t_goodstype where p_id=?1",nativeQuery=true)
	public List<GoodsType> findByParentId(int parentId);
}
