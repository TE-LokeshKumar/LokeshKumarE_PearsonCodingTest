package com.te.stores.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Helper {

	public static long countDays(String date) {
		Date from = null;
		long difference = 0;

		try {
			from = new SimpleDateFormat("dd/MM/yyyy").parse(date);

			Date to = new Date();

			long differenceInMilli = Math.abs(to.getTime() - from.getTime());
			difference = TimeUnit.DAYS.convert(differenceInMilli, TimeUnit.MILLISECONDS);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return difference;
	}
}
