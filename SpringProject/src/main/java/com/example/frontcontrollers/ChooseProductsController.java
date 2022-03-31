package com.example.frontcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.model.NewOrder;
import com.example.proxies.NewOrderProxy;
import com.example.proxies.ProductsProxy;

@RequestMapping("/chooseproducts")
@Controller
public class ChooseProductsController {

	private final ProductsProxy productsProxy;
	private final NewOrderProxy ordersProxy;

	public ChooseProductsController(ProductsProxy productsProxy, NewOrderProxy ordersProxy) {
		this.productsProxy = productsProxy;
		this.ordersProxy = ordersProxy;
	}

	@GetMapping
	public String showProductsForm(Model model) {
		model.addAttribute("products", productsProxy.getProducts());
		model.addAttribute("types", NewOrder.Type.values());
		model.addAttribute("order", new NewOrder());
		return "design";
	}

	@PostMapping
	public String processOrder(Model model, NewOrder order, RedirectAttributes attributes) {
		ordersProxy.addOrder(order);
		model.addAttribute(order);
		attributes.addFlashAttribute("order", order);
		return ("redirect:/sendorder");
	}

}
