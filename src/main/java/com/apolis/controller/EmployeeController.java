package com.apolis.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apolis.Entity.Employee;

@RestController
public class EmployeeController {
	static List<Employee> list = new ArrayList<>();
	static {
		list.add(new Employee(1, "Jack", "23000"));
		list.add(new Employee(11, "John", "11000"));
		list.add(new Employee(15, "Tom", "18000"));
	}
	
	@GetMapping("/emanage/details")
	public String getDetails() {
		System.out.println("Request recived for getDetails(..)");
		return "All rights of this application has been reserved.";
	}

	@GetMapping("/emanage/getData") 
	public List<Employee> getData() {
		System.out.println("Request recived for getData(..)");
		return list;
	}
	
	@PostMapping("/emanage/addemployee")
	public String addEmployee(@RequestBody Employee emp) {
		list.add(emp);
		return "employee has been successfully added.";
	}
	
	@DeleteMapping("emanage/deleteEmployee")
	public String deleteEmployee(@RequestParam int deleteId) {
		for(Employee employee: list) {
			if(employee.getId() == deleteId) {
				list.remove(employee);
				return "Employee Deleted Successfully";
			}
		}
		return "Employee with id = " + deleteId + " Not found";
	}
	
	@PutMapping("emanage/updateEmployee")
	public String updateEmployee(@RequestBody Employee employee) {
		for(Employee emp: list) {
			if(emp.getId() == employee.getId()) {
				emp.setSalary(employee.getSalary());
				emp.setName(employee.getName());
				return "Employee updated Successfully";
			}
		}
		return "Employee with id = " + employee.getId() + " Not found";
	}
}
