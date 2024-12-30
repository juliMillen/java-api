package com.application.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.application.rest.controller.DTO.ProductoDTO;
import com.application.rest.entity.Producto;
import com.application.rest.service.IProductoService;

@RestController
@RequestMapping("api/producto")
public class ProductoController {
	@Autowired
	private IProductoService productoService;
	
	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		Optional<Producto> productoOptional = productoService.findById(id);
		
		if(productoOptional.isPresent()) {
			Producto producto = productoOptional.get();
			
		ProductoDTO productoDTO = ProductoDTO.builder()
					.id(producto.getId())
					.name(producto.getName())
					.price(producto.getPrice())
					.maker(producto.getMaker())
					.build();
			return ResponseEntity.ok(productoDTO);
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll(){
		List<ProductoDTO> productoList = productoService.findAll()
				.stream()
				.map(producto -> ProductoDTO.builder()
						.id(producto.getId())
						.name(producto.getName())
						.price(producto.getPrice())
						.maker(producto.getMaker())
						.build())
				.toList();
		return ResponseEntity.ok(productoList);
	}
	

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody ProductoDTO productoDTO) throws URISyntaxException{
		if(productoDTO.getNombre().isBlank() || productoDTO.getPrice() == null || productoDTO.getMaker() == null) {
			return ResponseEntity.badRequest().build();
		}
		
		Producto producto = Producto.builder()
				.name(productoDTO.getNombre())
				.price(productoDTO.getPrice())
				.maker(productoDTO.getMaker())
				.build();
		productoService.save(producto);
		
		return ResponseEntity.created(new URI("/api/producto/save")).build();
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateMaker(@PathVariable Long id, @RequestBody ProductoDTO productoDTO){
		Optional<Producto> productoOptional = productoService.findById(id);
		
		if(productoOptional.isPresent()) {
			Producto producto = productoOptional.get();
			producto.setName(producto.getName());
			producto.setPrice(producto.getPrice());
			producto.setMaker(producto.getMaker());
			productoService.save(producto);
			return ResponseEntity.ok("Registro Actualizado");
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProducto(@PathVariable Long id){
		if(id != null) {
		 productoService.deleteByID(id);
		 return ResponseEntity.ok("Registro eliminado correctamente");
		 }
		return ResponseEntity.badRequest().build();
	}	
	
	
	
}
