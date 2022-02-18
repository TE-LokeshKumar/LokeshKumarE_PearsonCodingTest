package com.te.stores.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.stores.bean.UserResponse;
import com.te.stores.bean.UserResponses;
import com.te.stores.customexception.CustomException;
import com.te.stores.model.ExceptionResponse;
import com.te.stores.service.ServiceImplimentation;

@RestController
public class StoresController {

	@Autowired
	private ServiceImplimentation service;

	@GetMapping("/getbyid")
	public ResponseEntity<UserResponse> getDataById(@RequestParam String id) {
		UserResponse response = new UserResponse(false, service.getDataById(id));
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);

	}

	@GetMapping("/orderedby")
	public ResponseEntity<UserResponses> getOrderedData(@RequestParam String option) {
		UserResponses responses = new UserResponses(false, service.getOrderedData(option));
		return new ResponseEntity<UserResponses>(responses, HttpStatus.OK);

	}

}
