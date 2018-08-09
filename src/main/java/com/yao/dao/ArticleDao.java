package com.yao.dao;

import java.util.List;
import java.util.Map;

import com.yao.entity.Article;

/**
 * ����Dao�ӿ�
 * @author user
 *
 */
public interface ArticleDao {

	/**
	 * ��ȡ���µ�7������
	 * @return
	 */
	public List<Article> getNewest();
	
	/**
	 * ��ȡ����7���Ƽ�������
	 * @return
	 */
	public List<Article> getRecommend();
	
	/**
	 * ��ȡ����5���õƵ�����
	 * @return
	 */
	public List<Article> getSlide();
	
	/**
	 * ��������������������µ�8������
	 * @param typeId
	 * @return
	 */
	public List<Article> getIndex(Integer typeId);
	
	/**
	 * ͨ��id��ѯ����
	 * @param id
	 * @return
	 */
	public Article findById(Integer id);
	
	/**
	 * ��ȡ��һ������
	 * @param id
	 * @return
	 */
	public Article getLastArticle(Integer id);
	
	/**
	 * ��ȡ��һ������
	 * @param id
	 * @return
	 */
	public Article getNextArticle(Integer id);
	
	/**
	 * ��������
	 * @param article
	 * @return
	 */
	public Integer update(Article article);
	
	/**
	 * ����������ҳ��ѯ����
	 * @param map
	 * @return
	 */
	public List<Article> list(Map<String,Object> map);
	
	/**
	 * ��ȡ�ܼ�¼��
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String,Object> map);
	
	/**
	 * �������
	 * @param article
	 * @return
	 */
	public Integer add(Article article);
	
	/**
	 * ɾ��������Ϣ
	 * @param id
	 * @return
	 */
	public Integer delete(Integer id);
	
	/**
	 * ��ѯָ������µ���������
	 * @param typeId
	 * @return
	 */
	public Integer getNumByTypeId(Integer typeId);
}
