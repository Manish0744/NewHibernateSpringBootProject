package com.test.main.dao;

import java.util.List;

import com.test.main.entity.Address;
import com.test.main.entity.Department;
import com.test.main.entity.Employee;

public interface DepartmentDAO {
    
	public Department addDepartment(Department customer);
	
	public List<Department> getAllDepartment() ;

    public Department getDepartmentByID(long id) ;
    
    public List<Employee> getEmployeeByDeptID(long id);
    
    public Employee getEmployeeEmpID(long id);
    
    public Address getAddressAddID(long id);
 
    public String updateDepartment(long id, String deptName);
    
    public String updateEmployeeByID(long id, String empName);
    
    public String deleteAddressById(long id);
    
    public String deleteEmployeeById(long id);
    
    public String deleteDepartmentById(long id);

	public Address getAddressByNamedQuery();
}
