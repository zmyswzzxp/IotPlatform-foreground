package com.iot.demo.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileNameCreator {
	
	/**
	 * 
	 * @param url http://localhost:8080/file_server/upload/
	 * @param fileName a.jpg
	 * @return http://localhost:8080/file_server/123132143243543a.jpg
	 */
	public static String createRandomName(String url,String fileName){
		DateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmSSS");
		String format = fmt.format(new Date());	
		//Ҫ����ĵ�ַ
		url = url + format + fileName;
		return url;
	}
}
