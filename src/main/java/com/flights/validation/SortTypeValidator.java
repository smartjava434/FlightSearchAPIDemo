package com.flights.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import static com.flights.Constants.SORT_TYPE_DURATION;
import static com.flights.Constants.SORT_TYPE_PRICE;
import static com.flights.Constants.SORT_TYPE_PRICE_AND_DURATION;

/**
 * Constraint validator for sort type
 */
public class SortTypeValidator implements ConstraintValidator<SortTypeConstraint, String> {

	@Override
	public void initialize(SortTypeConstraint sortType) {
	}

	@Override
	public boolean isValid(String sortType, ConstraintValidatorContext cxt) {

		
		  if (StringUtils.isBlank(sortType)) { return true; }
		 
		return (SORT_TYPE_DURATION.equalsIgnoreCase(sortType) || SORT_TYPE_PRICE.equalsIgnoreCase(sortType)
				|| SORT_TYPE_PRICE_AND_DURATION.equalsIgnoreCase(sortType));

	}
}
