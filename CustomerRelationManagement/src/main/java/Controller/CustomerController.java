package Controller;

import java.util.List; 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.CustomerService;
import entity.Customer;



@Controller
@RequestMapping("/customer")
public class CustomerController {

	
	@Autowired
	private CustomerService customerservice;
	
	@GetMapping("/list")
	public String findAllcustomer(Map<String, List<Customer>> map, Map<String, String> map1)
	{
		List<Customer> customer = CustomerService.findAllcustomer();
		map.put("customer", customer);
		map1.put("name", "Harshit Choudary");
		return "customerlist";
	}
	@GetMapping("/showform")
	public String showFormForSave(Model model )
	{
		
		Customer customer = new Customer();
		model.addAttribute(customer);
		return "Customerform";
	}
	@GetMapping("/edit/{id}")
	public String showFormForSave(Model model, @PathVariable int id )
	{
		
		Customer customer = this.customerservice.findCustomerById(id);
		model.addAttribute(customer);
		return "customerform";
	}
	
	
	@PostMapping("/save")
	public String saveorupdate(Customer customer)
	{
		Customer savedcustomer = null;
		System.out.println(customer);
		if(customer.getId() != 0)
		{
			savedcustomer = customerservice.findCustomerById(customer.getId());
			savedcustomer.setFirstname( customer.getFirstname());
			savedcustomer.setLastname(customer.getFirstname());
			savedcustomer.setEmail(customer.getEmail());
			System.out.println("if");
		}
		else
			savedcustomer = new Customer(customer.getId(),customer.getFirstname(), customer.getLastname(), customer.getEmail());
		this.customerservice.saveOrUpdate(savedcustomer);
		return "redirect:list";
	}
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id)
	{
		this.customerservice.delete(id);
		return "redirect:/books/list";
	}
	
}
