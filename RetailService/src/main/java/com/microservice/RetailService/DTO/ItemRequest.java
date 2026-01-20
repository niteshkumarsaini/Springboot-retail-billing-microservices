package com.microservice.RetailService.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemRequest {
	@NotBlank(message = "Item name is required")
	private String name;
	@NotNull
	@NotBlank(message = "Item type is required")
	private String type;
	@NotNull(message = "Price is required")
	@Positive(message = "Price must be greater than zero")
	private Double price;

}
