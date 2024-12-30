package com.application.rest.service;

import java.util.List;
import java.util.Optional;

import com.application.rest.entity.Maker;

public interface IMakerService {
	
	List<Maker> findAll();
	
	Optional<Maker> findById(Long id);
	
	void save(Maker maker);
	
	void deleteById(Long id);

}
