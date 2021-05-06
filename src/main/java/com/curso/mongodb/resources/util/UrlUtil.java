package com.curso.mongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class UrlUtil {

	public static String decodeParam(String param) {
		try {
			return URLDecoder.decode(param, StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
	
	public static Date decodeParam(String param, Date defaultValue) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		try {
			return sdf.parse(param);
		} catch (ParseException e) {
			return defaultValue;
		}				
	}
}
