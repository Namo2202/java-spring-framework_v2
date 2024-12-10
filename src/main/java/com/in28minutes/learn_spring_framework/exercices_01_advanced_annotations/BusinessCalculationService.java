package com.in28minutes.learn_spring_framework.exercices_01_advanced_annotations;

import java.util.Arrays;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

//@Component
@Service
public class BusinessCalculationService {
	private DataService dataService;

	public BusinessCalculationService(DataService dataService) {
		this.dataService = dataService;
	}

	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}

}
