package com.yao.service;

import com.yao.entity.Manager;

/**
 * ����ԱService�ӿ�
 * @author user
 *
 */
public interface ManagerService {

	/**
	 * ͨ���û�����ѯ�û�
	 * @param userName
	 * @return
	 */
	public Manager getByUserName(String userName);
	
	/**
	 * ���¹���Ա��Ϣ
	 * @param manager
	 * @return
	 */
	public Integer update(Manager manager);
}
