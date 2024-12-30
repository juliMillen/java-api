package com.application.rest.entity;

import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;




@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "precio")
	private BigDecimal price;  //mas apropiado para trabajar con dinero
	
	@ManyToOne
	@JoinColumn(name = "idFabricante", nullable = false)
	private Maker maker;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Producto(Long id, String name, BigDecimal price, Maker maker) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.maker = maker;
	}
	
	public Producto(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.price = builder.price;
		this.maker = builder.maker;
	}

	public Producto() {
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

        public Producto build() {
            return new Producto(this);
        }
    }
}
