package com.flights.validation;


import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


import com.flights.Constants;

class SortTypeValidationTest {

  @Test
  void testForValidSortType() {
	  SortTypeValidator validator = new SortTypeValidator();
	  assertTrue(validator.isValid(Constants.SORT_TYPE_PRICE, null));
	  assertTrue(validator.isValid(Constants.SORT_TYPE_DURATION, null));
	  assertTrue(validator.isValid(Constants.SORT_TYPE_PRICE_AND_DURATION, null));
  }
  
  
  @Test
  void testForInvalidSortType() {
	  SortTypeValidator validator = new SortTypeValidator();
	  assertFalse(validator.isValid("notprice", null));
	  	 
  }
}
