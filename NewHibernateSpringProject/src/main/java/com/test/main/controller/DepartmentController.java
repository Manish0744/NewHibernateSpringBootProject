package com.test.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.main.entity.Address;
import com.test.main.entity.Department;
import com.test.main.entity.Employee;
import com.test.main.service.DepartmentService;

@RestController
public class DepartmentController {
	@Autowired
    DepartmentService departmentService;
	
	@PutMapping("/addDepartment")
    public String addDepartment(@RequestBody Department department)
    {
    	departmentService.addDepartment(department);
    	return "Department Data has been Successfully Inserted.";
    }
 
    @GetMapping("/getAllDepartments")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }
    
    @GetMapping("/getDepartmentByID/{deptId}")
    public Department getDepartmentByID(@PathVariable long deptId)
    {
    	return departmentService.getDepartmentByID(deptId);
    }
    
    @GetMapping("/getEmployeeByDeptID/{deptId}")
    public List<Employee> getEmployeeByDeptID(@PathVariable long deptId)
    {
    	return departmentService.getEmployeeByDeptID(deptId);
    }
    
    @GetMapping("/getEmployeeEmpID/{empId}")
    public Employee getEmployeeEmpID(@PathVariable long empId)
    {
    	return departmentService.getEmployeeEmpID(empId);
    }
    
    @GetMapping("/getAddressAddID/{addId}")
    public Address getAddressAddID(@PathVariable long addId)
    {
    	return departmentService.getAddressAddID(addId);
    }
    
    @PutMapping("/updateDepartment/{deptId}/{deptName}")
    public String updateDepartment(@PathVariable long deptId, @PathVariable String deptName)
    {
    	return departmentService.updateDepartment(deptId, deptName);
    }
    
    @PutMapping("/updateEmployeeByID/{empId}/{empName}")
    public String updateEmployeeByID(@PathVariable long empId, @PathVariable String empName)
    {
    	return departmentService.updateEmployeeByID(empId, empName);
    }
    
    @DeleteMapping("/deleteAddressById/{addId}")
    public String deleteAddressById(@PathVariable long addId)
    {
    	return departmentService.deleteAddressById(addId);
    }
    
    @DeleteMapping("/deleteEmployeeById/{empId}")
    public String deleteEmployeeById(@PathVariable long empId)
    {
    	return departmentService.deleteEmployeeById(empId);
    }
    
    @DeleteMapping("/deleteDepartmentById/{deptId}")
    public String deleteDepartmentById(@PathVariable long deptId)
    {
    	return departmentService.deleteDepartmentById(deptId);
    }
    
    @GetMapping("/getAddressByNamedQuery")
    public Address getAddressByNamedQuery()
    {
    	return departmentService.getAddressByNamedQuery();
    }
}
