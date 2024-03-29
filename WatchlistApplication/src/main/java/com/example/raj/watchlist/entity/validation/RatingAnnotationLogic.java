package com.example.raj.watchlist.entity.validation;


import javax.validation.ConstraintValidator;

import javax.validation.ConstraintValidatorContext;

public class RatingAnnotationLogic implements ConstraintValidator<Rating, Float> {
public boolean isValid(Float value, ConstraintValidatorContext context) {
  return value > 5.0F && value <= 10.0F;
}
}
