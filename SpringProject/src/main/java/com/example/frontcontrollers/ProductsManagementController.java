package com.example.frontcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.json.simple.JSONObject;

import com.example.model.Product;
import com.example.proxies.ProductsProxy;

@RequestMapping("/productsmanagement")
@Controller
public class ProductsManagementController {

	private final ProductsProxy productsProxy;

	public ProductsManagementController(ProductsProxy productsProxy) {
		this.productsProxy = productsProxy;
	}

	@GetMapping
	public String showProductsForm(Model model) {

		var products = productsProxy.getProducts();

		model.addAttribute("products", products);
		return "products";
	}

	@PostMapping
	public String processCompany(String name, Product.Type type, String price, Model model) {
		var products = productsProxy.getProducts();
		JSONObject jobject = new JSONObject();
		jobject.put("name", name);
		jobject.put("type", type);
		jobject.put("price", price);
		productsProxy.addProduct(jobject);
		model.addAttribute("products", products);

		return "redirect:/productsmanagement";
	}

}
