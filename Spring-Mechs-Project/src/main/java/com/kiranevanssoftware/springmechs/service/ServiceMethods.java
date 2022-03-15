package com.kiranevanssoftware.springmechs.service;

import java.util.List;

public interface ServiceMethods<T> {
		//Create
		T create(T mech);
		
		//Read All
		List<T> readAll();
		
		//Read By Id
		T readById(long id);
		
		//Update
		T update(long id, T mech);
}
