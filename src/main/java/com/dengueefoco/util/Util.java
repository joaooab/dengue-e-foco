package com.dengueefoco.util;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {

	private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");

	public static String getData(Calendar data) {
		return formataParaString(data).split("T")[0];
	}

	public static String getHora(Calendar data) {
		return formataParaString(data).split("T")[1].split("-")[0];
	}

	public static String getNotificado(Boolean notificado) {
		return notificado ? "Sim" : "Não";
	}

	public static Calendar formataParaCalendar(String value) {
		try {
			Date date = simpleDateFormat.parse(value);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			return calendar;
		} catch (Exception e) {
			return null;
		}
	}

	public static String formataParaString(Calendar calendar) {
		return simpleDateFormat.format(calendar.getTime());
	}

}