package com.example.demo.secondquestion;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class AvailabilityDaoService implements Callable<Integer> {
	private static final Logger logger = LoggerFactory.getLogger(AvailabilityDaoService.class);
	APIModel request;

	AvailabilityDaoService() {
	}

	AvailabilityDaoService(APIModel request) {
		this.request = request;
	}

	private static List<Availability> availabilityList = new ArrayList<>();

	static {

		try {
			availabilityList.add(
					new Availability("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-19"), 1.0));
			availabilityList.add(
					new Availability("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-20"), 3.0));
			availabilityList.add(
					new Availability("Store001", "Prod1", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-21"), 0.0));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Integer call() throws Exception {
		logger.info("Availability Thread started Executing");
		Date reqDate = new SimpleDateFormat("yyyy-MM-dd").parse(this.request.getReqDate());
		// TODO Auto-generated method stub
		
		/*Two Filters applied -- first is on date(coming in request) and second is on availQty(basis which we need to provide final result). 
		 * Once filter is applied we will have List which can contain zero or one availability
		 * 
		 *  */
		
		return availabilityList.stream().filter(availability -> availability.getDate().compareTo(reqDate) == 0)
				.filter(availability -> availability.getAvailQty() > 0).collect(Collectors.toList()).size();
	}
}
