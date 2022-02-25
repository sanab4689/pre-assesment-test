package com.example.demo.thirdquestion;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AvailabilityService1 {
	
	private static List<Avail> availList = new ArrayList<>();
	private static List<Calender> CalenderList = new ArrayList<>();

	static {
		availList.add(new Avail("Product1", 10.0));
		availList.add(new Avail("Product2", 5.0));
	}
	static {
		CalenderList.add(new Calender("Product1", 2.0));
		CalenderList.add(new Calender("Product2", 5.0));
	}

	public int checkAvailability(String productId) {

		

		int availability = 0;

		Avail availObj = availList.stream().filter(supply -> productId.equals(supply.getProductId())).findAny()
				.orElse(null);
		Calender calenderObj = CalenderList.stream().filter(demand -> productId.equals(demand.getProductId())).findAny()
				.orElse(null);

		if (availObj != null && calenderObj != null)
			availability = (int) (availObj.getQuantity() - calenderObj.getQuantity());
		return availability;

	}

}
