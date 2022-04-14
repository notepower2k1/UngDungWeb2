package com.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.demo.model.Employee;
import com.springboot.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	

    @Autowired
    private EmployeeService employeeService;

    // display list of employees
    @GetMapping("/")
    public String viewHomePage(Model model) {
    	return findPaginated(1, model);
    	
    }
    
    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model) {
    	//create model attribute to bind from data
    	Employee employee = new Employee();
    	model.addAttribute("employee",employee);
    	return "new_employee";
    }
    
    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
    	//save employee to database
    	employeeService.saveEmployee(employee);
    	return "redirect:/";
    }
    
    @GetMapping("/showFormForUpdate/{id}")
    public String showFormForUpdate(@PathVariable (value="id")long id,Model model) {
    	// get employee from the service
		
    	Employee employee = employeeService.getEmployeeById(id);
    	
    	model.addAttribute("employee",employee);
    	
    	return "update_employee";
    	
    }
    
    @GetMapping("/showFormForDelete/{id}")
    public String showFormForDelete(@PathVariable (value="id")long id,Model model) {
    	// get employee from the service
		
    	this.employeeService.deleteEmployee(id);
		return "redirect:/";
    	
    }
    @GetMapping("/page/{pageNo}")
    public String findPaginated(@PathVariable (value="pageNo") int pageNo,Model model) {
    	int pageSize = 5;
    	
    	Page<Employee> page = employeeService.findPaginated(pageNo, pageSize);
    	List<Employee> listEmployees = page.getContent();
    	
    	model.addAttribute("currentPage",pageNo);
    	model.addAttribute("totalPages",page.getTotalPages());
    	model.addAttribute("totalItems",page.getTotalElements());
    	model.addAttribute("listEmployees",listEmployees);
		return "index";
    	
    }
}
