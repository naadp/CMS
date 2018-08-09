package com.yao.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yao.dao.ArticleDao;
import com.yao.entity.Article;
import com.yao.service.ArticleService;

/**
 * 帖子Service实现类
 * @author user
 *
 */
@Service("articleService")
public class ArticleServiceImpl implements ArticleService{

	@Resource
	private ArticleDao articleDao;
	
	public List<Article> getNewest() {
		return articleDao.getNewest();
	}

	public List<Article> getRecommend() {
		return articleDao.getRecommend();
	}

	public List<Article> getSlide() {
		return articleDao.getSlide();
	}

	public List<Article> getIndex(Integer typeId) {
		return articleDao.getIndex(typeId);
	}

	public Article findById(Integer id) {
		return articleDao.findById(id);
	}

	public Article getLastArticle(Integer id) {
		return articleDao.getLastArticle(id);
	}

	public Article getNextArticle(Integer id) {
		return articleDao.getNextArticle(id);
	}

	public Integer update(Article article) {
		return articleDao.update(article);
	}

	public List<Article> list(Map<String, Object> map) {
		return articleDao.list(map);
	}

	public Long getTotal(Map<String, Object> map) {
		return articleDao.getTotal(map);
	}

	public Integer add(Article article) {
		return articleDao.add(article);
	}

	public Integer delete(Integer id) {
		return articleDao.delete(id);
	}

	public Integer getNumByTypeId(Integer typeId) {
		return articleDao.getNumByTypeId(typeId);
	}

}
