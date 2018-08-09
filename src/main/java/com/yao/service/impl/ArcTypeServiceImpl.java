package com.yao.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yao.dao.ArcTypeDao;
import com.yao.entity.ArcType;
import com.yao.service.ArcTypeService;

/**
 * 帖子类别Service实现类
 * @author user
 *
 */
@Service("arcTypeService")
public class ArcTypeServiceImpl implements ArcTypeService{

	@Resource
	private ArcTypeDao arcTypeDao;
	
	public List<ArcType> list(Map<String, Object> map) {
		return arcTypeDao.list(map);
	}

	public ArcType findById(Integer id) {
		return arcTypeDao.findById(id);
	}

	public Long getTotal(Map<String, Object> map) {
		return arcTypeDao.getTotal(map);
	}

	public Integer add(ArcType arcType) {
		return arcTypeDao.add(arcType);
	}

	public Integer update(ArcType arcType) {
		return arcTypeDao.update(arcType);
	}

	public Integer delete(Integer id) {
		return arcTypeDao.delete(id);
	}

}
