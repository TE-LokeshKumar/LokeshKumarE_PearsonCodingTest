package com.te.stores.dao;

import org.json.JSONArray;
import org.json.JSONObject;

public interface StoresDAO {

	public JSONObject getDataById(String id) ;

	public JSONArray getOrderedData();
}
