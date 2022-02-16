package com.te.stores.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StoreDetailsModel {

	private String storeId;

	private String postCode;

	private String city;

	private String address;

	private LocalDate openedDate;

	private Long hasBeenOpenFor;
}
