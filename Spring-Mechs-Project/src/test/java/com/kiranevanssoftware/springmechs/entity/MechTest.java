package com.kiranevanssoftware.springmechs.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class MechTest {

	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Mech.class).usingGetClass().verify();
	}

	@Test
	public void getAndSetTest() {
		Mech mech = new Mech();

		
		mech.setId(1L);
		mech.setYear(2100);
		mech.setModel("B32");
		mech.setWeight(4550);
		mech.setName("Firespear");

		assertNotNull(mech.getYear());
		assertNotNull(mech.getId());
		assertNotNull(mech.getModel());
		assertNotNull(mech.getName());
		assertNotNull(mech.getWeight());

		assertEquals(mech.getYear(), 2100);
		assertEquals(mech.getId(), 1L);
		assertEquals(mech.getModel(), "B32");
		assertEquals(mech.getName(), "Firespear");
		assertEquals(mech.getWeight(), 4550);
	}

	@Test
	public void allArgsConstructor() {
		Mech mech = new Mech(1L, 2562, "Warfly", "F9", 1300);

		assertNotNull(mech.getYear());
		assertNotNull(mech.getId());
		assertNotNull(mech.getModel());
		assertNotNull(mech.getName());
		assertNotNull(mech.getWeight());

		assertEquals(mech.getYear(), 2562);
		assertEquals(mech.getId(), 1L);
		assertEquals(mech.getModel(), "F9");
		assertEquals(mech.getName(), "Warfly");
		assertEquals(mech.getWeight(), 1300);
	}
}