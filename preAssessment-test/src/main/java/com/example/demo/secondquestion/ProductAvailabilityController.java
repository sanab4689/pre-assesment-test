package com.example.demo.secondquestion;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class ProductAvailabilityController {
	
	private static final Logger logger = LoggerFactory.getLogger(ProductAvailabilityController.class);

	@PostMapping("/getProdAvailability")
	public ResponseEntity<APIModel> getProdAvailability(@RequestBody APIModel request)
			throws InterruptedException, ExecutionException {

		ResponseEntity<APIModel> responseEntity = null;
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<Integer> availabilityFuture = executorService.submit(new AvailabilityDaoService(request));
		Future<Integer> capacityFuture = executorService.submit(new CapacityDaoService(request));

		logger.info("availabilityFuture & capacityFuture will get the result seperately");
		
		/*Basis size of this list which is being returned form DAO layer, controller is preparing the value of status field */
		
		if (availabilityFuture.get() == 1 && capacityFuture.get() == 0) {
			request.setStatus("No Capacity");
			responseEntity = new ResponseEntity<APIModel>(request, HttpStatus.OK);
		}
		if (availabilityFuture.get() == 1 && capacityFuture.get() == 1) {
			request.setStatus("Available");
			responseEntity = new ResponseEntity<APIModel>(request, HttpStatus.OK);
		}
		if (availabilityFuture.get() == 0 && capacityFuture.get() == 1) {
			responseEntity = new ResponseEntity<APIModel>(HttpStatus.NO_CONTENT);
		}
		return responseEntity;

	}
}
