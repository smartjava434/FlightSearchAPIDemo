package com.flights.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;


/**
 * Constraint to check the Sort type. 
 */
@Constraint(validatedBy = SortTypeValidator.class)
@Target( { ElementType.METHOD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface SortTypeConstraint {
	
	 String message() default "Sort type should be price or duration or price_duration";
	    Class<?>[] groups() default {};
	    Class<? extends Payload>[] payload() default {};

}
