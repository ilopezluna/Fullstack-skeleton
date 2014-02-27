package com.ilopezluna.japanathome.services;

import com.google.inject.Inject;
import com.ilopezluna.japanathome.entities.Basic;
import com.ilopezluna.japanathome.exceptions.ValidationException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

public class ValidatorServiceImpl<T extends Basic> implements ValidatorService<T>
{
	private final Validator validator;

	@Inject
	public ValidatorServiceImpl(Validator validator) {
		this.validator = validator;
	}

	@Override
	public void validate(T t) throws ValidationException {

		Set<ConstraintViolation<T>> validate = validator.validate(t);

		if ( !validate.isEmpty() )
			throw new ValidationException(validate.toString());

	}
}
