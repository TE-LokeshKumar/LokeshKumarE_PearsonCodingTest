package com.te.stores.helper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.te.stores.bean.StoreDetails;

public class Helper {

	public static long countDays(StoreDetails target) {
		Date from = null;
		long difference = 0;

		try {
			from = new SimpleDateFormat("dd/MM/yyyy").parse(target.getOpenedDate());

			Date to = new Date();

			long differenceInMilli = Math.abs(to.getTime() - from.getTime());
			difference = TimeUnit.DAYS.convert(differenceInMilli, TimeUnit.MILLISECONDS);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		return difference;
	}
}
