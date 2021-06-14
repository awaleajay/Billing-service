package com.example.billing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.billing.service.BillingService;

@CrossOrigin(origins = "http://localhost:8086", maxAge = 3600)
@RestController
@RequestMapping("/billing")
public class BillingController {
	
	@Autowired
	BillingService billingService;
	
	
	@GetMapping("/get-products")
	public Object getProducts() {
		
		return billingService.getProducts();
		
	}
	
	@GetMapping("get-product-by-id")
	public Object getProductById(@RequestParam int id) {
		return billingService.getProductById(id);
	}
}
