package com.microservice.RetailService.Services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.microservice.RetailService.DTO.ItemRequest;
import com.microservice.RetailService.DTO.ItemResponse;
import com.microservice.RetailService.Entities.Bill;
import com.microservice.RetailService.Exceptions.InvalidRequestException;
import com.microservice.RetailService.Repositories.BillRepository;
import com.microservice.RetailService.Services.BillingService;
import com.microservice.RetailService.Util.ItemType;

@Service
public class BillingServiceImpl implements BillingService {

	@Autowired
	private BillRepository billRepository;

	@Override
	public ItemResponse calculateBill(List<ItemRequest> items) {
		// Validation
		validateBusinessRules(items);

		double tax = items.stream().mapToDouble((item) -> item.getPrice() * ItemType.from(item.getType()).getTaxRate())
				.sum();
		double totalPrice = items.stream().mapToDouble((item) -> item.getPrice()).sum();
		double grandTotal = totalPrice + tax;
		// check for discount
		if (grandTotal > 2000) {
			// giving 5% discount
			grandTotal = grandTotal * 0.95; // this will give only the 95% exclude 5% discount amount
		}
		// Saving to DB
		Bill generatedBill = Bill.builder().grandTotal(grandTotal).totalItems(items.size()).totalTax(tax).build();
		try {
			billRepository.save(generatedBill);
			return ItemResponse.builder().status(HttpStatus.OK).response(generatedBill).build();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return ItemResponse.builder().status(HttpStatus.INTERNAL_SERVER_ERROR)
				.response("Transaction has not been perfomed. DB might be down.").build();
	}

	// Validation
	private void validateBusinessRules(List<ItemRequest> items) {
		if (items.isEmpty()) {
			throw new InvalidRequestException("Item list cannot be empty");
		}
		// validation for free Items to set price 0
		boolean hasFreeItem = items.stream().anyMatch(item -> item.getPrice() == 0);

		if (hasFreeItem) {
			throw new InvalidRequestException("Free items are not allowed");
		}

	}

}