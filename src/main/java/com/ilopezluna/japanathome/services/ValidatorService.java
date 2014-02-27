package com.ilopezluna.japanathome.services;

import com.ilopezluna.japanathome.entities.Basic;
import com.ilopezluna.japanathome.exceptions.ValidationException;

public interface ValidatorService <T extends Basic> {

	void validate(T t) throws ValidationException;
}
