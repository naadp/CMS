package com.yao.util;

import org.apache.shiro.crypto.hash.Md5Hash;

public class Md5Util {
	
	//这里将盐值定为一个静态常量,登陆以及一些其他的场合都需要使用到.所以直接定为常量了。
	public static final String SALT = "yao";
	
	/**
	 * MD5加密,加盐;
	 * @param source
	 * @param salt
	 * @return
	 */
	public static String md5(String source, String salt){
			
		return new Md5Hash(source, salt).toString();
		
	}
	
	public static void main(String[] args) {
		//userNmae : yao;用户名 和 加密前 的密码,都是 yao;
		String password = "yao";
		System.out.println(md5(password,SALT));
	}
}
