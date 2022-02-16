package com.te.stores.bean;

import com.te.stores.model.StoreDetailsModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

	private boolean error;
	
	private StoreDetailsModel data;
}
