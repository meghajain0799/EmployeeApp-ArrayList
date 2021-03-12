package com.meg.empcoln.dao;

import java.util.ArrayList;

import java.util.Scanner;

import com.meg.empcoln.db.EmployeeDB;
import com.meg.empcoln.dto.Employee;
import com.meg.empcoln.exception.InvalidEmployeeIdExcption;
import com.meg.empcoln.exception.WrongSalaryException;

public class EmployeeDAOImpl implements IEmployeeDAO {

	Scanner sc = new Scanner(System.in);

	public boolean addEmployee(Employee e) throws WrongSalaryException {
		// SQL insert into employee ......

		// System.out.println(" =====>> DAO Impl employee "+e);
		return EmployeeDB.addEmployee(e);
	}

	public ArrayList<Employee> getAllEmployees() {

		return EmployeeDB.employees;
	}

	// ============================================================

	public boolean editSalaryByEmployeeId(int id) throws InvalidEmployeeIdExcption, WrongSalaryException {
		// TODO Auto-generated method stub
		return EmployeeDB.editSalaryByEmployeeId(id);
	}

	public boolean editExpByEmployeeId(int id) throws InvalidEmployeeIdExcption {
		// TODO Auto-generated method stub
		return EmployeeDB.editExpByEmployeeId(id);
	}

	public ArrayList<Employee> getEmployeeBySalary(int salary) {
		// TODO Auto-generated method stub
		return EmployeeDB.getEmployeeBySalary(salary);
	}

	public ArrayList<Employee> getEmployessBySalaryRange(int salaryRangeMin, int salaryRangeMax) {
		// TODO Auto-generated method stub
		return EmployeeDB.getEmployessBySalaryRange(salaryRangeMin, salaryRangeMax);
	}

}
