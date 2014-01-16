package com.ilopezluna.fullstack.services;

import com.ilopezluna.fullstack.entities.Element;

import java.util.Collection;

public interface ElementService {

	Collection<Element> fetchAll();

	Element saveOrUpdate(Element element);

	Element fetch(String id);

	void remove(String id);

}
