package com.application.rest.controller.DTO;

import java.util.ArrayList;
import java.util.List;

import com.application.rest.entity.Producto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;




@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MakerDTO {
	
	private Long id;
	private String name;
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
	public MakerDTO(Long id, String name, List<Producto> productList) {
		super();
	}
	public MakerDTO(Builder builder) {
		this.id = builder.id;
		this.name = builder.name;
		this.productList = builder.productList;
	}
	public MakerDTO() {
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

        public MakerDTO build() {
            return new MakerDTO(this);
        }
    }
    
    
}
