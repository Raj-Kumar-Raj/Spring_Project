package com.example.raj.watchlist.entity.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriorityAnnotationLogic.class)
public @interface Priority {
//custom annotations 
	String message() default "please enter L H M omly";
	Class<?>[] groups() default {};

	   Class<? extends Payload>[] payload() default {};
}
