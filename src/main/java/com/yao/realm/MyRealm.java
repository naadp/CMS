package com.yao.realm;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.yao.entity.Manager;
import com.yao.service.ManagerService;

/**
 * �Զ���Realm,���Manager�ĵ�½��֤�����˶��ѣ�
 * @author 20605
 *
 */
public class MyRealm extends AuthorizingRealm {

	@Resource
	private ManagerService managerService;
	
	/**
	 * Ϊ��ǰ�û������ɫ��Ȩ��:����ֻ��һ����½��֤����,�ò������;
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		String userName=(String) token.getPrincipal();
		Manager manager=managerService.getByUserName(userName);
		if(manager!=null){
			SecurityUtils.getSubject().getSession().setAttribute("currentUser", manager);
			AuthenticationInfo authcInfo=new SimpleAuthenticationInfo(manager.getUserName(), manager.getPassword(), "xxx");
			return authcInfo;
		}else{
			return null;
		}
	}

}
