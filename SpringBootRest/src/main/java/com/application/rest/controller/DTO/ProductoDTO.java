package com.application.rest.controller.DTO;

import java.math.BigDecimal;
import com.application.rest.entity.Maker;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductoDTO {

	private Long id;
	
	private String nombre;
	
	private BigDecimal price;
	
	private Maker maker;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Maker getMaker() {
		return maker;
	}

	public void setMaker(Maker maker) {
		this.maker = maker;
	}

	public ProductoDTO(Long id,String nombre, BigDecimal price, Maker maker) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.price = price;
		this.maker = maker;
	}

	public ProductoDTO(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.name;
		this.price = builder.price;
		this.maker = builder.maker;
	}
	public ProductoDTO() {
		super();
	}
	
	 // Método estático para iniciar el Builder
    public static Builder builder() {
        return new Builder();
    }
    
	// Clase Builder interna
    public static class Builder {
        private Long id;
        private String name;
        private BigDecimal price;
        private Maker maker;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder maker(Maker maker) {
            this.maker = maker;
            return this;
        }
        
        public Builder price(BigDecimal price) {
        	this.price=price;
        	return this;
        }

        public ProductoDTO build() {
            return new ProductoDTO(this);
        }
    }
}
