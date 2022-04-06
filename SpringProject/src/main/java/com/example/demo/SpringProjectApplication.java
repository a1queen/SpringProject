package com.example.demo;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Company;
import com.example.model.NewOrder;
import com.example.model.Product;
import com.example.repositories.CompanyRepository;
import com.example.repositories.OrderDetailsRepository;
import com.example.repositories.OrderRepository;
import com.example.repositories.ProductRepository;

@SpringBootApplication
public class SpringProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringProjectApplication.class, args);
	}

	
	/*
	 * @Bean CommandLineRunner runner(ProductRepository productRepository,
	 * OrderRepository orderRepository, CompanyRepository companyRepository,
	 * OrderDetailsRepository detailsRepository) { return args -> { Product product
	 * = new Product("Apple pie", Product.Type.DESSERT, new
	 * BigDecimal(String.valueOf(12.00))); productRepository.save(product); Product
	 * product2 = new Product("Cheesecake", Product.Type.DESSERT, new
	 * BigDecimal(String.valueOf(14.50))); productRepository.save(product2); Product
	 * product3 = new Product("Chicken soup", Product.Type.SOUP, new
	 * BigDecimal(String.valueOf(11.00))); productRepository.save(product3); Product
	 * product4 = new Product("Thai curry soup", Product.Type.SOUP, new
	 * BigDecimal(String.valueOf(15.00))); productRepository.save(product4); Product
	 * product5 = new Product("Tomato soup", Product.Type.SOUP, new
	 * BigDecimal(String.valueOf(11.00))); productRepository.save(product5); Product
	 * product6 = new Product("Beef enchilada", Product.Type.MAIN, new
	 * BigDecimal(String.valueOf(20.00))); productRepository.save(product6); Product
	 * product7 = new Product("Lamb gyros with tzatziki sauce", Product.Type.MAIN,
	 * new BigDecimal(String.valueOf(22.00))); productRepository.save(product7);
	 * Product product8 = new Product("Pesto chicken", Product.Type.MAIN, new
	 * BigDecimal(String.valueOf(19.00))); productRepository.save(product8); Product
	 * product9 = new Product("Vegan chickpea shakshuka", Product.Type.MAIN, new
	 * BigDecimal(String.valueOf(15.00))); productRepository.save(product9); Product
	 * product10 = new Product("Black bean–stuffed sweet potatoes",
	 * Product.Type.MAIN, new BigDecimal(String.valueOf(16.00)));
	 * productRepository.save(product10); Product product11 = new Product("Tea",
	 * Product.Type.DRINK, new BigDecimal(String.valueOf(6.00)));
	 * productRepository.save(product11); Product product12 = new
	 * Product("Apple juice", Product.Type.DRINK, new
	 * BigDecimal(String.valueOf(4.00))); productRepository.save(product12); Product
	 * product13 = new Product("Coffee", Product.Type.DRINK, new
	 * BigDecimal(String.valueOf(7.00))); productRepository.save(product13);
	 * 
	 * List<Product> products = Arrays.asList( new Product("Tea",
	 * Product.Type.DRINK, new BigDecimal(String.valueOf(6.00))), new
	 * Product("Pesto chicken", Product.Type.MAIN, new
	 * BigDecimal(String.valueOf(19.00))));
	 * 
	 * NewOrder testOrder = new NewOrder();
	 * testOrder.setTypes(NewOrder.Type.INADVANCE); testOrder.setProducts(products);
	 * NewOrder testOrder2 = new NewOrder(); products = Arrays.asList(new
	 * Product("Coffee", Product.Type.DRINK, new BigDecimal(String.valueOf(7.00))),
	 * new Product("Pesto chicken", Product.Type.MAIN, new
	 * BigDecimal(String.valueOf(19.00))));
	 * testOrder2.setTypes(NewOrder.Type.ONDELIVERY);
	 * testOrder2.setProducts(products);
	 * 
	 * Company testCompany = new Company("The Great One");
	 * companyRepository.save(testCompany); testCompany = new
	 * Company("The smaller two"); companyRepository.save(testCompany);
	 * 
	 * }; }
	 */
	 

}
