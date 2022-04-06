package com.example.frontcontrollers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.proxies.CompanyProxy;

@RequestMapping("/companiesmanagement")
@Controller
public class CompaniesManagementController {

	private final CompanyProxy companyProxy;

	public CompaniesManagementController(CompanyProxy companyProxy) {
		this.companyProxy = companyProxy;
	}

	@GetMapping
	public String showCompaniesForm(Model model) {

		var companies = companyProxy.getCompanies();
		model.addAttribute("companies", companies);
		return "companies";
	}

	@PostMapping
	public String processCompany(String name, Model model) {
		companyProxy.addCompanyDetails(name);
		var companies = companyProxy.getCompanies();
		
		model.addAttribute("companies", companies);
		
		return "redirect:/companiesmanagement";
	}
}
