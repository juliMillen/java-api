package com.application.rest.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.rest.entity.Producto;
import com.application.rest.persistence.IProductoDAO;
import com.application.rest.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoDAO productoDAO;
	
	@Override
	public List<Producto> findAll() {

		return productoDAO.findAll();
	}

	@Override
	public Optional<Producto> findById(Long id) {

		return productoDAO.findById(id);
	}

	@Override
	public List<Producto> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {

		return productoDAO.findByPriceInRange(minPrice, maxPrice);
	}

	@Override
	public void save(Producto prod) {

		productoDAO.save(prod);
		
	}

	@Override
	public void deleteByID(Long id) {
		
		productoDAO.deleteByID(id);
	}

}
