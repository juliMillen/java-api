package com.application.rest.entity;

import java.util.ArrayList;
import java.util.List;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Fabricante")
public class Maker {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nombre")
	private String name;
	
	@OneToMany(mappedBy = "maker", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<Producto> productList =  new ArrayList<>();

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

	public List<Producto> getProductList() {
		return productList;
	}

	public void setProductList(List<Producto> productList) {
		this.productList = productList;
	}

	public Maker(Long id, String name, List<Producto> productList) {
		super();
		this.id = id;
		this.name = name;
		this.productList = productList;
	}

	public Maker() {
		super();
	}
	
	public Maker(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.productList = builder.productList;
	}
	
	 // Método estático para iniciar el Builder
    public static Builder builder() {
        return new Builder();
    }
    
	// Clase Builder interna
    public static class Builder {
        private Long id;
        private String name;
        private List<Producto> productList;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder productList(List<Producto> productList) {
            this.productList = productList;
            return this;
        }

        public Maker build() {
            return new Maker(this);
        }
    }
	
}
