package com.itheima.ssm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = simpleDateFormat.parse(source);
			return date;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
