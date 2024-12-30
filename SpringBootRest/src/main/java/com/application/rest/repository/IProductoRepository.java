package com.application.rest.repository;

import java.math.BigDecimal;
import java.util.List;

//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.application.rest.entity.Producto;


@Repository
public interface IProductoRepository extends CrudRepository<Producto, Long>{

	//Forma de realizarlo mediante Consulta QUERY
	//@Query("SELECT p FROM productos p WHERE p.price BETWEEN ?1 AND ?2")
	//List<Producto> findProductoByPriceInRange(BigDecimal minPrice, BigDecimal maxPrice);
	
	//Forma de realizarlo mediante QUERY METHOD y el nombre del metodo
	List<Producto> findProductoByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
	
}
