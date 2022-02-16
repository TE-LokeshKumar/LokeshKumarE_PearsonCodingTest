package com.te.stores.dao;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.te.stores.bean.StoreDetails;

@Component
public class DaoImplimentation implements StoresDAO {

	@Override
	public JSONObject getDataById(String id) {
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
					System.out.println("obj:" + obj);
					
					return obj;
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("obj:" + obj);
		return obj;
	}

	@Override
	public JSONArray getOrderedData() {
		File input = new File("src/main/resources\\stores1.csv");
		JSONArray jsonArray = new JSONArray();
		try {
			CsvSchema inputCSV = CsvSchema.emptySchema().withHeader();
			CsvMapper csvMapper = new CsvMapper();
			MappingIterator<Map<?, ?>> mappingIterator = csvMapper.reader().forType(Map.class).with(inputCSV)
					.readValues(input);
			List<Map<?, ?>> dataList = mappingIterator.readAll();

			for (int i = 0; i < dataList.size(); i++) {

				JSONObject obj = new JSONObject(dataList.get(i));
				jsonArray.put(obj);
			}
			System.out.println(jsonArray);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}
}
