package com.bootcamp.sti.wall.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.sti.wall.dao.CustomerDao;
import com.bootcamp.sti.wall.dto.CommonResponse;
import com.bootcamp.sti.wall.dto.CustomerDto;
import com.bootcamp.sti.wall.dto.UserDto;
import com.bootcamp.sti.wall.exception.EntityNotFoundException;
import com.bootcamp.sti.wall.exception.RegisteredException;
import com.bootcamp.sti.wall.model.Customer;


@CrossOrigin
@RestController
public class CustomerController {
	public static final String URL_CUSTOMER = "customer";
	public static final String URL_LOGIN = "login";
	public static final String URL_REGISTRATION = "registration";
	public static final String URL_REQUEST_CUSTOMER_BY_ID = "/customer/{id}";
	public static final String URL_IDCARD = "checkidcard";
	
	  @Autowired
	  private CustomerDao customerService;
	  
	  @PostMapping(value=URL_CUSTOMER+"/"+URL_LOGIN)
		public CommonResponse<Customer> login(@RequestBody UserDto user) throws EntityNotFoundException{
			CommonResponse<Customer> resp = new CommonResponse<>();
			String tempUserId = user.getIdUser();
			if(tempUserId == null) {
				throw new EntityNotFoundException();
				}else {
				resp.setData(customerService.getByIdUser(tempUserId));
			
			}
			return resp;
			
			
		}
	  
	  @PostMapping(value=URL_CUSTOMER+"/"+URL_REGISTRATION)
		public CommonResponse<Customer> createCustomer(@RequestBody CustomerDto customer) throws EntityNotFoundException {
		  CommonResponse<Customer> resp = new CommonResponse<>();
			resp.setData(customerService.createCustomer(customer));

			return resp;

		}
	  
	  @GetMapping(value = URL_CUSTOMER+"/"+URL_REQUEST_CUSTOMER_BY_ID)
		public CommonResponse<Customer> getByCustomerId(@PathVariable(name = "id") String id) throws EntityNotFoundException{
			Customer customer = customerService.getByCustomerId(id);
			CommonResponse<Customer> resp = new CommonResponse<>();
			if (customer == null) {
				throw new EntityNotFoundException();
			} else {
				resp.setData(customer);
			}
			return resp;
		}
	  
	  @GetMapping(value = URL_REQUEST_CUSTOMER_BY_ID)
		public CommonResponse<Customer> getByIdCard(@PathVariable(name = "idcard") String idCard) throws EntityNotFoundException {
			Customer customer = customerService.getByIdcard(idCard);
			CommonResponse<Customer> resp = new CommonResponse<>();
			if (customer == null) {
				throw new EntityNotFoundException();
			} else {
				resp.setData(customer);
			}
			return resp;
		}
	  
	  @PostMapping(value = URL_CUSTOMER+"/"+URL_IDCARD)
		public CommonResponse<Customer> getCustomerByIdCard(@RequestBody CustomerDto customer) throws RegisteredException{
			CommonResponse<Customer> resp = new CommonResponse<>();
			String userTemp = customer.getIdCard();
			
			if(customerService.getByIdcard(userTemp)!= null) {
				throw new RegisteredException();
			}else {
				resp.setCode("01");
				resp.setDescription("Success");
			}
			
			return resp;
		}
}
