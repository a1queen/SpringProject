package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.frontcontrollers.ChooseProductsController;
import com.example.frontcontrollers.CompaniesManagementController;
import com.example.frontcontrollers.HomeController;
import com.example.frontcontrollers.ProductsManagementController;
import com.example.frontcontrollers.SendOrderController;
import com.example.frontcontrollers.SuccessController;

@SpringBootTest
class UnitTests {

	
	@Autowired
	private HomeController homeController;
	
	@Autowired
	private ChooseProductsController cpController;
	
	@Autowired
	private CompaniesManagementController cmController;
	
	@Autowired
	private ProductsManagementController pmController;
	
	@Autowired
	private SendOrderController soController;
	
	@Autowired
	private SuccessController sController;
	
	

	@Test
	public void homeContextLoads() throws Exception {
		assertThat(homeController).isNotNull();
	}
	
	@Test
	public void chooseProductsContextLoads() throws Exception {
		assertThat(cpController).isNotNull();
	}
	
	@Test
	public void companiesManagementContextLoads() throws Exception {
		assertThat(cmController).isNotNull();
	}
	
	@Test
	public void productsManagementContextLoads() throws Exception {
		assertThat(pmController).isNotNull();
	}
	
	@Test
	public void sendOrderContextLoads() throws Exception {
		assertThat(soController).isNotNull();
	}
	
	@Test
	public void successContextLoads() throws Exception {
		assertThat(sController).isNotNull();
	}
}
