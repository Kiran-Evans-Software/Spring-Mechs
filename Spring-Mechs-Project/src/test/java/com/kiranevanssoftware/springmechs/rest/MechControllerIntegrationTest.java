package com.kiranevanssoftware.springmechs.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.kiranevanssoftware.springmechs.entity.Mech;

// boots the context
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // creates the MockMVC object
@ActiveProfiles("test") // sets current profile to 'test'
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = { "classpath:mech-schema.sql",
		"classpath:mech-data.sql" })
public class MechControllerIntegrationTest {

	@Autowired // tells Spring to insert this object into the class
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper; // the object Spring uses to convert JSON <-> Java

	@Test
	public void test() {
		assertEquals(2, 1 + 1);
	}
 
	@Test
	public void testCreate() throws Exception {
		
		// URL body method headers
		Mech testMech = new Mech(2055, "Megahammer", "27R", 7433);
		String testMechAsJSON = this.mapper.writeValueAsString(testMech);
		RequestBuilder req = post("/mech/create").content(testMechAsJSON).contentType(MediaType.APPLICATION_JSON);

		Mech testSavedMech = new Mech(2, 2055, "Megahammer", "27R", 7433);
		String testSavedMechAsJSON = this.mapper.writeValueAsString(testSavedMech);
		// this will check the status code of my response
		ResultMatcher checkStatus = status().isCreated();
		// this will check the body of the response
		ResultMatcher checkBody = content().json(testSavedMechAsJSON);

		// run the request and check both matchers
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	public void testCreate2() throws Exception {
		Mech testMech = new Mech(2346, "Ravenhawk", "RH2", 4550);
		String testMechAsJSON = this.mapper.writeValueAsString(testMech);
		RequestBuilder req = post("/mech/create").content(testMechAsJSON).contentType(MediaType.APPLICATION_JSON);

		Mech testSavedMech = new Mech(2, 2346, "Ravenhawk", "RH2", 4550);
		String testSavedMechAsJSON = this.mapper.writeValueAsString(testSavedMech);
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(testSavedMechAsJSON);


		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	public void testReadById() throws Exception {
		RequestBuilder req = get("/mech/readById/1");

		ResultMatcher checkStatus = status().isOk();

		Mech savedMech = new Mech(1, 2765, "Dragonblade", "XDB", 3700);
		String savedMechAsJSON = this.mapper.writeValueAsString(savedMech);

		ResultMatcher checkBody = content().json(savedMechAsJSON);

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testReadAll() throws Exception {
		Mech entry = new Mech(1L, 2765, "Dragonblade", "XDB", 3700);
		List<Mech> mechs = new ArrayList<>();
		mechs.add(entry);
		String mechsOutputAsJson = this.mapper.writeValueAsString(mechs);
		
		this.mvc.perform(get("/mech/readAll")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().json(mechsOutputAsJson));
	}
	
	@Test
	public void updateTest() throws Exception{
		Mech entry = new Mech(1L, 2765, "Dragonblade", "XDB", 3700);
		String entryMechAsJson = this.mapper.writeValueAsString(entry);
		
		Mech result = new Mech(1L, 2765, "Dragonblade", "XDB", 3700);
		String resultMechAsJson = this.mapper.writeValueAsString(result);
		
		this.mvc.perform(put("/mech/update/1")
				.contentType(MediaType.APPLICATION_JSON)
				.content(entryMechAsJson))
		.andExpect(status().isAccepted())
		.andExpect(content().json(resultMechAsJson));
	}
	
	
	
	
	
}