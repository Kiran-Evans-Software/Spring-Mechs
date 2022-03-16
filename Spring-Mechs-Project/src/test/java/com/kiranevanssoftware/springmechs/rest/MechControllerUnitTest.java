package com.kiranevanssoftware.springmechs.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.kiranevanssoftware.springmechs.controller.MechController;
import com.kiranevanssoftware.springmechs.entity.Mech;
import com.kiranevanssoftware.springmechs.service.MechService;

@SpringBootTest
public class MechControllerUnitTest {

	@Autowired
	private MechController controller;
	
	@MockBean
	private MechService service;
	
	@Test
	public void createMechTest() {
		Mech mech = new Mech(2077, "Ron", "FF44", 9478);
		
		Mockito.when(this.service.create(mech)).thenReturn(mech);
		
		ResponseEntity<Mech> response = new ResponseEntity<Mech>(mech, HttpStatus.CREATED);
		
		assertThat(response).isEqualTo(this.controller.createMech(mech));
		
		Mockito.verify(this.service, times(1)).create(mech);
	}
}