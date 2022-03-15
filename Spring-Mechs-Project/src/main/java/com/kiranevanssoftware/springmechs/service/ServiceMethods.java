package com.kiranevanssoftware.springmechs.service;

import java.util.List;

public interface ServiceMethods<T> {
		//Create
		T create(T mech);
		
		//Read All
		List<T> readAll();
}
