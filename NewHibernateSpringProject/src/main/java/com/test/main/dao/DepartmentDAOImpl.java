package com.test.main.dao;

import java.util.List;

import javax.transaction.Transaction;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.main.entity.Address;
import com.test.main.entity.Department;
import com.test.main.entity.Employee;
@Repository
public class DepartmentDAOImpl implements DepartmentDAO{

	@Autowired
    private SessionFactory sessionFactory;
 
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }
    
    @Override
    public Department addDepartment(Department department) {    	
    	Session session = this.sessionFactory.openSession(); 
        session.save(department);
        return department;
    }
    
    @Override
    public List<Department> getAllDepartment() {
        Session session = this.sessionFactory.openSession();
        List<Department>  departmentList = session.createQuery("from Department").list();
        return departmentList;
    }
    
    @Override
    public Department getDepartmentByID(long id) {
        Session session = this.sessionFactory.openSession();
        Department department = (Department) session.get(Department.class, id);
        return department;
    }
    
	@Override
	public List<Employee> getEmployeeByDeptID(long id) {
        Session session = this.sessionFactory.openSession();
        Query qry = session.createQuery("from Employee Where deptId=:id");
        qry.setParameter("id", id);
        List<Employee>  employeeList = qry.list();
		return employeeList;
	}
	
	@Override
	public Employee getEmployeeEmpID(long id) {
        Session session = this.sessionFactory.openSession();
        Query qry = session.createQuery("from Employee Where empId=:id");
        qry.setParameter("id", id);
		return (Employee) qry.uniqueResult();
	}
	
	@Override
	public Address getAddressAddID(long id) {
		Session session = this.sessionFactory.openSession();
        Query qry = session.createQuery("from Address Where addId=:id");
        qry.setParameter("id", id);
		return (Address) qry.uniqueResult();
	}
	
	@Override
	public String updateDepartment(long id, String deptName) {
		Session session = this.sessionFactory.openSession();
        Query qry = session.createQuery("Update Department SET deptName=:deptName1 Where deptId=:id");
        qry.setParameter("deptName1", deptName);
        qry.setParameter("id", id);
        int count = qry.executeUpdate();
		return "Department has been Successfully Updated.";
	}
	
	@Override
	public String updateEmployeeByID(long id, String empName) {
		Session session = this.sessionFactory.openSession();
        Query qry = session.createQuery("Update Employee SET empName=:empName1 Where empId=:id");
        qry.setParameter("empName1", empName);
        qry.setParameter("id", id);
        int count = qry.executeUpdate();
		return "Employee " + id +  " has been Successfully Updated.";
	}
	
	@Override
	public String deleteAddressById(long id) {
		Session session = this.sessionFactory.openSession();
		Query qry = session.createQuery("delete Address Where addId=:id");
        qry.setParameter("id", id);
        qry.executeUpdate();
		return "Address " + id + " has been deleted.";
	}
	
	@Override
	public String deleteEmployeeById(long id) {
		Session session = this.sessionFactory.openSession();
		Query qry = session.createQuery("delete Employee Where empId=:id");
        qry.setParameter("id", id);
        qry.executeUpdate();
		return "Employee " + id + " has been deleted.";
	}
	
	@Override
	public String deleteDepartmentById(long id) {
		Session session = this.sessionFactory.openSession();
		Query qry = session.createQuery("delete Department Where deptId=:id");
        qry.setParameter("id", id);
        qry.executeUpdate();
		return "Department " + id + " has been deleted.";
	}
	
	@Override
	public Address getAddressByNamedQuery() {
		Session session = this.sessionFactory.openSession();
    	Query query = session.getNamedQuery("address");
    	return (Address)query.uniqueResult();
	}
}
