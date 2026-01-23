package com.microservice.RetailService.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.RetailService.DTO.ItemRequest;
import com.microservice.RetailService.DTO.ItemResponse;

public interface BillingService {

	ItemResponse calculateBill(List<ItemRequest> items);

}
