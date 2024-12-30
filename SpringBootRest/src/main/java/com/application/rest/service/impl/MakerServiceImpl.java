package com.application.rest.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.rest.entity.Maker;
import com.application.rest.persistence.IMakerDAO;
import com.application.rest.service.IMakerService;

@Service
public class MakerServiceImpl implements IMakerService {

	@Autowired
	private IMakerDAO makerDAO;
	
	@Override
	public List<Maker> findAll() {

		return (List<Maker>)makerDAO.findAll();
	}

	@Override
	public Optional<Maker> findById(Long id) {

		return makerDAO.findById(id);
	}

	@Override
	public void save(Maker maker) {
         
		makerDAO.save(maker);
		
	}

	@Override
	public void deleteById(Long id) {

		makerDAO.deleteById(id);
		
	}

}
