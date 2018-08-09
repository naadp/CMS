package com.yao.dao;

import java.util.List;
import java.util.Map;

import com.yao.entity.ArcType;

/**
 * 帖子类别Dao接口
 * @author user
 *
 */
public interface ArcTypeDao {

	/**
	 * 根据条件分页查询帖子类别集合
	 * @param map
	 * @return
	 */
	public List<ArcType> list(Map<String,Object> map);
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * 根据id查询实体
	 * @param id
	 * @return
	 */
	public ArcType findById(Integer id);
	
	/**
	 * 添加帖子类别
	 * @param arcType
	 * @return
	 */
	public Integer add(ArcType arcType);
	
	/**
	 * 修改帖子类别
	 * @param arcType
	 * @return
	 */
	public Integer update(ArcType arcType);
	
	/**
	 * 删除帖子类别
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
}
