package com.kiranevanssoftware.springmechs.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class MechTest {

	// Remember to import the equalsverifier dependency
	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Mech.class).usingGetClass().verify();
	}

	@Test
	public void getAndSetTest() {
		// Create empty mech object
		Mech mech = new Mech();

		// Use the setter methods to add values to each field, so we can check the
		// setters work
		mech.setId(1L);
		mech.setYearManufactured(2100);
		mech.setModel("B32");
		mech.setWeight(4550);
		mech.setName("Firespear");

		// make sure after the setters, they actually set the values and are not null
		assertNotNull(mech.getYearManufactured());
		assertNotNull(mech.getId());
		assertNotNull(mech.getModel());
		assertNotNull(mech.getName());
		assertNotNull(mech.getWeight());

		// make sure that when we use the getters, they get the correct value
		assertEquals(mech.getYearManufactured(), 2100);
		assertEquals(mech.getId(), 1L);
		assertEquals(mech.getModel(), "B32");
		assertEquals(mech.getName(), "Firespear");
		assertEquals(mech.getWeight(), 4550);
	}

	@Test
	public void allArgsConstructor() {
		Mech mech = new Mech(1L, 2562, "Warfly", "F9", 1300);

		// make sure after the setters, they actually set the values and are not null
		assertNotNull(mech.getYearManufactured());
		assertNotNull(mech.getId());
		assertNotNull(mech.getModel());
		assertNotNull(mech.getName());
		assertNotNull(mech.getWeight());

		// make sure that when we use the getters, they get the correct value
		assertEquals(mech.getYearManufactured(), 2562);
		assertEquals(mech.getId(), 1L);
		assertEquals(mech.getModel(), "F9");
		assertEquals(mech.getName(), "Warfly");
		assertEquals(mech.getWeight(), 1300);
	}
}