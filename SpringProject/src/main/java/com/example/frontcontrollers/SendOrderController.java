package com.example.frontcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.model.NewOrder;
import com.example.model.OrderDetails;
import com.example.proxies.CompanyProxy;
import com.example.proxies.NewOrderProxy;
import com.example.proxies.OrderDetailsProxy;

@RequestMapping("/sendorder")
@Controller
public class SendOrderController {

	private final CompanyProxy companyProxy;
	private final OrderDetailsProxy detailsProxy;

	public SendOrderController(CompanyProxy companyProxy, OrderDetailsProxy detailsProxy, NewOrderProxy ordersProxy) {
		this.companyProxy = companyProxy;
		this.detailsProxy = detailsProxy;
	}

	@GetMapping
	public String showSendOrderForm(Model model, @ModelAttribute("order") NewOrder order) {
		model.addAttribute("order", order);
		OrderDetails details = new OrderDetails();
		model.addAttribute("details", details);

		model.addAttribute("companies", companyProxy.getCompanies());
		return "orderDetails";
	}

	@PostMapping
	public String processTaco(OrderDetails details) {
		detailsProxy.addOrderDetails(details);
		return "redirect:/success";
	}

}
