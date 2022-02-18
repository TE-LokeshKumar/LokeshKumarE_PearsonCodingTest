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
					return obj;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsonArray;
	}
}
