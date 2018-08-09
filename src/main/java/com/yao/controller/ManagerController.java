package com.yao.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yao.entity.Manager;
import com.yao.service.ManagerService;
import com.yao.util.Md5Util;
import com.yao.util.ResponseUtil;

/**
 * ����Ա���Ʋ�(�����ӳ��һ��ʼ����Щ manager �ģ����ǻ�� Tomcat ���Ǹ��г�ͻ,��д�����)
 * @author 20605
 *
 */
@Controller
@RequestMapping("/manager2")
public class ManagerController {
	
	@Resource
	private ManagerService managerService;
	
	/**
	 * �û���¼
	 * @param manager
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/login")
	public String login(Manager manager,HttpServletResponse response)throws Exception{
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(manager.getUserName(), Md5Util.md5(manager.getPassword(), Md5Util.SALT));
		JSONObject result=new JSONObject();
		try{
			subject.login(token);	
			result.put("success", true);
		}catch(Exception e){
			result.put("success", false);
			result.put("errorInfo", "�û��������������");
			e.printStackTrace();
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
}
