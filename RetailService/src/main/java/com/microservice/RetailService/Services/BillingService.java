package com.microservice.RetailService.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.microservice.RetailService.DTO.ItemRequest;
import com.microservice.RetailService.Entities.Bill;

public interface BillingService {

	Bill calculateBill(List<ItemRequest>items);

}
