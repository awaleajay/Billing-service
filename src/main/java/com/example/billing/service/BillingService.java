package com.example.billing.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.billing.model.Billing;
import com.example.billing.model.Customer;

@Service
public class BillingService {

	@Autowired
	RestTemplate template;
	Billing Billing;
	Customer Customer;
	
	


	public ResponseEntity<Billing[]> getProducts() {

		final String url = "http://localhost:8085/product/get-Product";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Billing[]> response = template.exchange(url, HttpMethod.GET, entity, Billing[].class);
		List<Billing> products = Arrays.asList(response.getBody());
		System.out.println(products.toString());

		return response;
	}

	public Object getProductById(int id) {
		final String url = "http://localhost:8085/product/get-product-byid?id=" + id;

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> entity = new HttpEntity<String>(headers);

		ResponseEntity<Billing> response = template.exchange(url, HttpMethod.GET, entity, Billing.class);
		//List<Billing> products = Arrays.asList(response.getBody());
		Billing product = response.getBody();
		System.out.println(product.toString());

		return response; 
	}

	public ResponseEntity<Customer[]> getCustomers() {
		final String url = "http://localhost:8081/customer/get-customer";
		
			HttpHeaders headers = new HttpHeaders();
			headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

			HttpEntity<String> entity = new HttpEntity<String>(headers);

			ResponseEntity<Customer[]> response = template.exchange(url, HttpMethod.GET, entity, Customer[].class);
			List<Customer> Customers = Arrays.asList(response.getBody());
			System.out.println(Customers.toString());

			return response;
			
		
		//return response;
		
	}

}
