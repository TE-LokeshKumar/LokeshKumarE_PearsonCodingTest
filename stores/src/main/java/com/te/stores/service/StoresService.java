package com.te.stores.service;

import java.util.List;

import com.te.stores.bean.StoreDetails;
import com.te.stores.model.StoreDetailsModel;

public interface StoresService {

	public StoreDetailsModel getDataById(String id);

	public List<StoreDetailsModel> getOrderedData(String option);
}
