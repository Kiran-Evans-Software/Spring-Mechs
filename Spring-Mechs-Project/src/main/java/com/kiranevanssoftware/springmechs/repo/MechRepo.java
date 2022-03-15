package com.kiranevanssoftware.springmechs.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kiranevanssoftware.springmechs.entity.Mech;

@Repository
public interface MechRepo extends JpaRepository<Mech, Long> {

}
