package com.yao.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Util {
	
	//���ｫ��ֵ��Ϊһ����̬����,��½�Լ�һЩ�����ĳ��϶���Ҫʹ�õ�.����ֱ�Ӷ�Ϊ�����ˡ�
	public static final String SALT = "yao";
	
	/**
	 * MD5����,����;
	 * @param source
	 * @param salt
	 * @return
	 */
	public static String md5(String source, String salt){
			
		return new Md5Hash(source, salt).toString();
		
	}
	
	public static void main(String[] args) {
		//userNmae : yao;�û��� �� ����ǰ ������,���� yao;
		String password = "yao";
		System.out.println(md5(password,SALT));
	}
}
