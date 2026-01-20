package com.microservice.RetailService.Controllers;

import java.util.List;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.RetailService.DTO.ItemRequest;
import com.microservice.RetailService.Entities.Bill;
import com.microservice.RetailService.Services.BillingService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/billing")
public class BillingController {

	private BillingService billingService;

	public BillingController(BillingService billingService) {
		this.billingService = billingService;

	}

	@PostMapping("/calculate")
	public ResponseEntity<?> calculateBilling(@Valid @RequestBody List<@Valid ItemRequest> items) {
		return ResponseEntity.ok(this.billingService.calculateBill(items));

	}

}
