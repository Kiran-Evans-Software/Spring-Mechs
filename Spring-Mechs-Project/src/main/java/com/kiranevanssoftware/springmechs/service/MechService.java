package com.kiranevanssoftware.springmechs.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kiranevanssoftware.springmechs.entity.Mech;
import com.kiranevanssoftware.springmechs.repo.MechRepo;

@Service
public class MechService implements ServiceMethods<Mech>{

	private MechRepo repo;
	
	
	//Constructor
	public MechService(MechRepo repo) {
		this.repo = repo;
	}

	@Override
	public Mech create(Mech mech) {
		return this.repo.save(mech);
	}

	@Override
	public List<Mech> readAll() {
		return this.repo.findAll();
	}

	@Override
	public Mech readById(long id) {
		Optional<Mech> getMech = this.repo.findById(id);
		if(getMech.isPresent()) {
			return getMech.get();
		}
		return null;
	}


	@Override
	public Mech update(long id, Mech mech) {
		Optional<Mech> existingMech = this.repo.findById(id);
		if(existingMech.isPresent()) {
			Mech exists = existingMech.get();
			exists.setYearManufactured(mech.getYearManufactured());
			exists.setName(mech.getName());
			exists.setModel(mech.getModel());
			exists.setWeight(mech.getWeight());
			
			return this.repo.saveAndFlush(exists);
		}
		return null;
	}

	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}