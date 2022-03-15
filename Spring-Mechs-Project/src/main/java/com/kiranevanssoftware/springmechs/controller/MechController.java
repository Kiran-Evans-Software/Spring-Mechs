package com.kiranevanssoftware.springmechs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kiranevanssoftware.springmechs.entity.Mech;
import com.kiranevanssoftware.springmechs.service.MechService;

@RestController
@RequestMapping("/mech")
public class MechController {
	private MechService service;

	@Autowired
	public MechController(MechService service) {
		this.service = service;
	}

	// Create
	@PostMapping("/create")
	// Request
	public ResponseEntity<Mech> createMech(@RequestBody Mech Mech) {
		return new ResponseEntity<Mech>(this.service.create(Mech), HttpStatus.CREATED);
	}

	// Read All
	@GetMapping("/readAll")
	public ResponseEntity<List<Mech>> readAllMechs() {
		return new ResponseEntity<List<Mech>>(this.service.readAll(), HttpStatus.OK);
	}

	// Read By Id
	@GetMapping("/readById/{id}")
	public ResponseEntity<Mech> readById(@PathVariable long id) {
		return new ResponseEntity<Mech>(this.service.readById(id), HttpStatus.OK);
	}

	// Update
	@PutMapping("/update/{id}")
	public ResponseEntity<Mech> updateMech(@PathVariable long id, @RequestBody Mech Mech) {
		return new ResponseEntity<Mech>(this.service.update(id, Mech), HttpStatus.ACCEPTED);
	}

	// Delete
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteMech(@PathVariable long id) {
		return (this.service.delete(id)) ? new ResponseEntity<>(HttpStatus.NO_CONTENT)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
