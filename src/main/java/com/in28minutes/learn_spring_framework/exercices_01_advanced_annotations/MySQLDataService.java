package com.in28minutes.learn_spring_framework.exercices_01_advanced_annotations;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository
public class MySQLDataService implements DataService {

	@Override
	public int[] retrieveData() {
		return new int[] {1, 2, 3, 4, 5};
	}
}