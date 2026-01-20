package com.microservice.RetailService.Entities;

import java.util.List;
import java.util.UUID;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int totalItems;
	private Double totalTax;
	private Double grandTotal;

}
