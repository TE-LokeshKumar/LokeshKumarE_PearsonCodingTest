package com.te.stores.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.stores.bean.StoreDetails;
import com.te.stores.dao.StoresDAO;
import com.te.stores.helper.Helper;
import com.te.stores.model.StoreDetailsModel;

@Service
public class ServiceImplimentation implements StoresService {

	@Autowired
	private StoresDAO dao;

	private StoreDetails target;

	@Override
	public StoreDetailsModel getDataById(String id) {

		JSONObject source = dao.getDataById(id);
		String jsonString = source.toString();
		ObjectMapper mapper = new ObjectMapper();

		try {
			target = mapper.readValue(jsonString, StoreDetails.class);
		} catch (Exception e) {
			e.printStackTrace();
		}

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date1 = target.getOpenedDate();
		LocalDate localDate = LocalDate.parse(date1, formatter);
		StoreDetailsModel model = new StoreDetailsModel();
		model.setStoreId(target.getStoreId());
		model.setPostCode(target.getPostCode());
		model.setCity(target.getCity());
		model.setAddress(target.getAddress());
		model.setOpenedDate(localDate);

		long days = Helper.countDays(target);
		target.setHasBeenOpenFor(days);

		model.setHasBeenOpenFor(days);
		System.out.println(localDate);

		return model;

	}

	@Override
	public List<StoreDetailsModel> getOrderedData(String option) {
		JSONArray source = dao.getOrderedData();
		String jsonString = source.toString();
		ObjectMapper mapper = new ObjectMapper();
		List<StoreDetails> details = new ArrayList<StoreDetails>();
		List<StoreDetailsModel> result = new ArrayList<StoreDetailsModel>();
		try {
			details = Arrays.asList(mapper.readValue(jsonString, StoreDetails[].class));
		} catch (Exception e) {
			e.printStackTrace();
		}

		for (StoreDetails storeDetails : details) {

			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String date1 = storeDetails.getOpenedDate();
			LocalDate localDate = LocalDate.parse(date1, formatter);

			long days = Helper.countDays(storeDetails);

			StoreDetailsModel model = new StoreDetailsModel(storeDetails.getStoreId(), storeDetails.getPostCode(),
					storeDetails.getCity(), storeDetails.getAddress(), localDate, days);
			result.add(model);
		}

		if (option.equalsIgnoreCase("city")) {
			result = result.stream().sorted((x, y) -> x.getCity().compareTo(y.getCity())).collect(Collectors.toList());
		} else if (option.equalsIgnoreCase("opened date")) {
			result = result.stream().sorted((x, y) -> x.getOpenedDate().compareTo(y.getOpenedDate()))
					.collect(Collectors.toList());
			System.out.println(result);

		}

		return result;

	}

}
