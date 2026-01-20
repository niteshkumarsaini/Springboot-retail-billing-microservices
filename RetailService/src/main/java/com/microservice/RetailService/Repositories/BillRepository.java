package com.microservice.RetailService.Repositories;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservice.RetailService.Entities.Bill;

@Repository
public interface BillRepository extends CrudRepository<Bill, Integer> {
	

}
