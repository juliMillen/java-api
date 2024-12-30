package com.application.rest.persistence;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import com.application.rest.entity.Producto;

public interface IProductoDAO {
	
	List<Producto> findAll();
	
	Optional<Producto> findById(Long id);
	
	List<Producto> findByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
	
	void save(Producto prod);
	
	void deleteByID(Long id);

}
