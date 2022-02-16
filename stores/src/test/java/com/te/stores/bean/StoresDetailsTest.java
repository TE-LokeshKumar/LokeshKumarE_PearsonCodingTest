package com.te.stores.bean;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.te.stores.model.StoreDetailsModel;

public class StoresDetailsTest {

	String json = "{\"storeId\":\"1525eec4-7bed-4597-bf5a-e06fcede5f4f\",\"postCode\":\"AB11 5PS\",\"city\":\"Aberdeen\",\"address\":\"LSU 1A Union Square, Guild Street\",\"openedDate\":null,\"hasBeenOpenFor\":23259}";


	ObjectMapper mapper = new ObjectMapper();
	
	@Test
	void testBean() throws JsonMappingException, JsonProcessingException {
		StoreDetailsModel model = new StoreDetailsModel();
		
		model.setStoreId("1525eec4-7bed-4597-bf5a-e06fcede5f4f");
		model.setPostCode("AB11 5PS");
		model.setCity("Aberdeen");
		model.setAddress("LSU 1A Union Square, Guild Street");
		model.setOpenedDate(null);
		model.setHasBeenOpenFor(23259l);
		
		System.out.println(mapper.writeValueAsString(model));
		
		StoreDetailsModel redValue =  mapper.readValue(json, StoreDetailsModel.class);
		
		assertEquals(json, mapper.writeValueAsString(redValue));
		
		
	}
}
