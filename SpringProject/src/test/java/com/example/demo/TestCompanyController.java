package com.example.demo;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.RESTcontrollers.CompanyController;
import com.example.model.Company;
import com.example.repositories.CompanyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(CompanyController.class)
@Import(CompanyController.class)
public class TestCompanyController {
	 @Autowired
	    MockMvc mockMvc;
	 @Autowired
	 ObjectMapper mapper;
	 
	 @MockBean
	    CompanyRepository companyRepository;
	 
	 Company company1 = new Company("ONE");
	 Company company2 = new Company("TWO");
	 
	 @Test
	 public void getAllCompanies_success() throws Exception {
	     List<Company> records = new ArrayList<>(Arrays.asList(company1,company2));
	     
	     Mockito.when(companyRepository.findAll()).thenReturn(records);
	     
	     mockMvc.perform(MockMvcRequestBuilders
	             .get("/company")
	             .contentType(MediaType.APPLICATION_JSON))
	             .andExpect(status().isAccepted())
	             .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
	             .andExpect(MockMvcResultMatchers.jsonPath("$[1].name", is("TWO")));
	 }
	 
	 
	 @Test
	 public void createCompany_success() throws Exception {
	     Company company = new Company("ONE");
	            

	     Mockito.when(companyRepository.save(company)).thenReturn(company);

	     MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/company")
	             .contentType(MediaType.APPLICATION_JSON)
	             .accept(MediaType.APPLICATION_JSON)
	             .content(this.mapper.writeValueAsString(company));

	     mockMvc.perform(mockRequest)
	             .andExpect(status().isAccepted())
	             .andExpect(jsonPath("$", notNullValue()))
	             .andExpect(jsonPath("$.name", is("ONE")));
	     }
	 
	 
	 
	 
}
