package com.meg.empcoln.db;

import com.meg.empcoln.dto.Employee;
import com.meg.empcoln.exception.InvalidEmployeeIdExcption;
import com.meg.empcoln.exception.WrongSalaryException;
//import com.meg.myemp.exception.*;
import com.meg.empcoln.service.EmployeeServiceImpl;
import com.meg.empcoln.service.IEmployeeService;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeDB {

	static IEmployeeService empService = new EmployeeServiceImpl();
	// ArrayList<Integer> al = new ArrayList<Integer>();
	public static Scanner sc = new Scanner(System.in);
	public static ArrayList<Employee> employees = new ArrayList<Employee>();
	public static ArrayList<Employee> emp1 = new ArrayList<Employee>();
	public static ArrayList<Employee> emp2 = new ArrayList<Employee>();
	public static int count = 0;

	static {

		employees.add(new Employee(101, "ramesh", 8, 7000));
		employees.add(new Employee(102, "suresh", 2, 7000));
		employees.add(new Employee(103, "rakesh", 1, 7000));
		employees.add(new Employee(104, "lokesh", 5, 7000));
		count = employees.size();
	}

	public static boolean addEmployee(Employee e) {

		return employees.add(e);

		
	}

	public static int getCount() {
		return count;
	}

	public static boolean editSalaryByEmployeeId(int id) throws InvalidEmployeeIdExcption, WrongSalaryException {
		boolean status = false;
		for (Employee emp : employees) {

			if (emp.getEmployeeId() == id) {
				status = true;
             System.out.println("Enter the salary to be updated");
				int salary = sc.nextInt();
				try {
					if (salary <= 50000 && salary >= 5000) {
						status = true;
						emp.setSalary(salary);
					}

					else {
						status = false;
						throw new WrongSalaryException(salary);
					}

				} catch (WrongSalaryException e1) {
					System.out.println(e1);
				}

			}
		}
		if (status) {
			System.out.println("Salary updated!");

		} else
			throw new InvalidEmployeeIdExcption();

		// throw new InvalidEmployeeIdExcption();

		return status;
	}

	public static  boolean editExpByEmployeeId(int id) throws InvalidEmployeeIdExcption {
		boolean status = false;

		for (Employee emp : employees) {

			if (emp.getEmployeeId() == id) {
				status = true;
				System.out.println("Enter the experience to be updated");
				int exp = sc.nextInt();
				emp.setExp(exp);

			}
		}
		if (status) {
			System.out.println("Experience updated");
		} else
			throw new InvalidEmployeeIdExcption();

		// throw new InvalidEmployeeIdExcption();

		return status;

	}

	public static ArrayList<Employee> getEmployeeBySalary(int salary) {
		for (Employee emp : employees) {

			if (emp.getSalary() == salary) {

				emp1.add(emp);
			}

		}
		return emp1;
	}

	public static ArrayList<Employee> getEmployessBySalaryRange(int salaryRangeMin, int salaryRangeMax) {
		for (Employee emp : employees) {
			if (emp.getSalary() >= salaryRangeMin && emp.getSalary() <= salaryRangeMax) {
				emp2.add(emp);
			}
		}

		return emp2;

	}

}// end of class
