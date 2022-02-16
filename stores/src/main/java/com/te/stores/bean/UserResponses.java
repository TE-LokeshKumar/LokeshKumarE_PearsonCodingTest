package com.te.stores.bean;

import java.util.List;

import com.te.stores.model.StoreDetailsModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponses {

	private boolean error;
	
	private List<StoreDetailsModel> data;
}
