package com.te.stores.service.dao;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.te.stores.bean.StoreDetails;
import com.te.stores.bean.StoresDetailsTest;
import com.te.stores.model.StoreDetailsModel;

public class StoresDaoTest {

	public static JSONObject getDataById(String id) {
		File input = new File("src/main/resources\\stores1.csv");
		JSONObject obj = new JSONObject();
		try {
			CsvSchema inputCSV = CsvSchema.emptySchema().withHeader();
			CsvMapper csvMapper = new CsvMapper();
			MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader().forType(Map.class).with(inputCSV)
					.readValues(input);
			List<Map<?, ?>> dataList = mappingIterator.readAll();

			for (int i = 0; i < dataList.size(); i++) {
				obj = new JSONObject(dataList.get(i));
				if (obj.getString("Store Id").equalsIgnoreCase(id)) {
					// System.out.println("obj:" + obj);

					return obj;

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println("obj:" + obj);
		return obj;
	}

	@Test
	public void testDao() throws JsonProcessingException {

		String json = "{\"Store Id\":\"99d806bf-e630-490d-a769-7a76c0db3d92\",\"Post Code\":\"G82 1LJ\",\"City\":\"Dumbarton\",\"Address\":\"Unit 12 The Artizan Centre\",\"Opened Date\":\"28/01/1970\"}";
		ObjectMapper mapper = new ObjectMapper();
		/*
		 * JSONObject object = new JSONObject(); object.put("Store Id",
		 * "99d806bf-e630-490d-a769-7a76c0db3d92"); object.put("Post Code", "G82 1LJ");
		 * object.put("City", "Dumbarton"); object.put("Address",
		 * "Unit 12 The Artizan Centre");
		 * 
		 * object.put("Opened Date", new SimpleDateFormat("dd/MM/yyyy").parse(
		 * "28/01/1970" ) ); System.out.println(object);
		 */

		JSONObject jsonFromGetData = StoresDaoTest.getDataById("99d806bf-e630-490d-a769-7a76c0db3d92");
		
		StoreDetailsModel storesObject = mapper.readValue(json, StoreDetailsModel.class);
		
			System.out.println(jsonFromGetData);
			System.out.println(mapper.writeValueAsString(storesObject));
			assertEquals(jsonFromGetData, mapper.writeValueAsString(storesObject));
			
		
	}

	/*
	 * {"Store Id":"99d806bf-e630-490d-a769-7a76c0db3d92","Post Code":"G82 1LJ"
	 * ,"City":"Dumbarton",
	 * "Address":"Unit 12 The Artizan Centre","Opened Date":"28/01/1970"}
	 */

}
