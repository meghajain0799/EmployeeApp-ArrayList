package com.meg.empcoln.service;

import java.util.ArrayList;

import com.meg.empcoln.dao.EmployeeDAOImpl;
import com.meg.empcoln.dao.IEmployeeDAO;
//import com.meg.empcoln.db.EmployeeDB;
import com.meg.empcoln.dto.Employee;
import com.meg.empcoln.exception.InvalidEmployeeIdExcption;
import com.meg.empcoln.exception.WrongSalaryException;

public class EmployeeServiceImpl implements IEmployeeService {

	// Animal a = new Dog();
	IEmployeeDAO dao;

	public EmployeeServiceImpl() {
		dao = new EmployeeDAOImpl();
	}

	public boolean addEmployee(Employee e) throws WrongSalaryException {

		// System.out.println(" ------------>> inside service "+e);

		if (e.getSalary() > 50000) {
			throw new WrongSalaryException();
		} else
			return dao.addEmployee(e);

	}

	public ArrayList<Employee> getAllEmployees() {

		return dao.getAllEmployees();
	}

	// ================================================================================

	public boolean editSalaryByEmployeeId(int id) throws InvalidEmployeeIdExcption, WrongSalaryException {

		
		return dao.editSalaryByEmployeeId(id);
	}

	public boolean editExpByEmployeeId(int id) throws InvalidEmployeeIdExcption {

		return dao.editExpByEmployeeId(id);
	}

	public ArrayList<Employee> getEmployeeBySalary(int salary) {

		return dao.getEmployeeBySalary(salary);
	}

	public ArrayList<Employee> getEmployessBySalaryRange(int salaryRangeMin, int salaryRangeMax) {

		return dao.getEmployessBySalaryRange(salaryRangeMin, salaryRangeMax);
	}

}
