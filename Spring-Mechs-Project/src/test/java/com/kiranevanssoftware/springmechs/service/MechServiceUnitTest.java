package com.kiranevanssoftware.springmechs.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.kiranevanssoftware.springmechs.entity.Mech;
import com.kiranevanssoftware.springmechs.repo.MechRepo;

@SpringBootTest
public class MechServiceUnitTest {

	@Autowired
	private MechService service;

	@MockBean
	private MechRepo repo;

	@Test
	public void createMechTest() {
		Mech input = new Mech(2056, "Hyperhawk", "200i", 3400);
		Mech output = new Mech(1L, 2056, "Hyperhawk", "200i", 3400);

		Mockito.when(this.repo.save(input)).thenReturn(output);

		assertEquals(output, this.service.create(input));

		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}
	
	@Test
	public void readByIdTest() {
		Optional<Mech> optionalOutput = Optional.of(new Mech(1L, 2056, "Hyperhawk", "200i", 3400));
		Mech output = new Mech(1L, 2056, "Hyperhawk", "200i", 3400);

		Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalOutput);
		
		assertEquals(output, this.service.readById(Mockito.anyLong()));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
	}
	
	
	@Test
	public void deleteTrueTest() {
		Mockito.when(this.repo.existsById(1L)).thenReturn(false);
		
		assertTrue(this.service.delete(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
	}
	
	
	
}