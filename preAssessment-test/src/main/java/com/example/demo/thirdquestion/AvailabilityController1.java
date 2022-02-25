package com.example.demo.thirdquestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AvailabilityController1 {
	
	@Autowired
	AvailabilityService1 availabilityService;

	@PostMapping("/getAvailability")
	public ResponseEntity<Request> findStoreAvailability(@RequestBody Request request) {
		
		int availableQuantity = availabilityService.checkAvailability(request.getProductId());
		if (availableQuantity > 0) {
			request.setAvailability(availableQuantity);
			return new ResponseEntity<Request>(request, HttpStatus.OK);
		} else {
			return new ResponseEntity<Request>(HttpStatus.NO_CONTENT);
		}
	}

}
