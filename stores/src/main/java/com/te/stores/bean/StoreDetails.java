package com.te.stores.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonValueFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDetails implements Serializable {

	@JsonProperty("Store Id")
	private String storeId;

	@JsonProperty("Post Code")
	private String postCode;

	@JsonProperty("City")
	private String city;

	@JsonProperty("Address")
	private String address;

	@JsonProperty("Opened Date")
	private String openedDate;

	private Long hasBeenOpenFor;
}
