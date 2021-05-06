package com.curso.mongodb.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class UrlUtil {

	public static String decodeParam(String param) {
		try {
			return URLDecoder.decode(param, StandardCharsets.UTF_8.name());
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
