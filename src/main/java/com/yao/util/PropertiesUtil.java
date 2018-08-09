package com.yao.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties�����ļ�������
 * @author user
 *
 */
public class PropertiesUtil {

	/**
	 * ����key��ȡvalue
	 * @param key
	 * @return
	 */
	public static String getValue(String key){
		Properties prop=new Properties();
		InputStream in=new PropertiesUtil().getClass().getResourceAsStream("/yao.properties");
		try {
			prop.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
}
