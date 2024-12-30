package com.application.rest.persistence.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.application.rest.entity.Producto;
import com.application.rest.persistence.IProductoDAO;
import com.application.rest.repository.IProductoRepository;

@Component
public class ProductoDAOImpl implements IProductoDAO{
	@Autowired
	private IProductoRepository productoRepository;

	@Override
	public List<Producto> findAll() {

		return (List<Producto>)productoRepository.findAll();
	}

	@Override
	public Optional<Producto> findById(Long id) {

		return productoRepository.findById(id);
	}

	@Override
	public List<Producto> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice) {

		return productoRepository.findProductoByPriceBetween(minPrice, maxPrice);
		
	}

	@Override
	public void save(Producto prod) {
		productoRepository.save(prod);
		
	}

	@Override
	public void deleteByID(Long id) {
		// TODO Auto-generated method stub
		productoRepository.deleteById(id);
	}

}
