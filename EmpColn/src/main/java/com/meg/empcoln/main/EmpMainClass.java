package com.meg.empcoln.main;

import java.util.ArrayList;
import java.util.Scanner;

//import com.meg.empcoln.db.EmployeeDB;
import com.meg.empcoln.dto.Employee;
import com.meg.empcoln.exception.InvalidEmployeeIdExcption;
import com.meg.empcoln.exception.WrongSalaryException;
import com.meg.empcoln.service.EmployeeServiceImpl;
import com.meg.empcoln.service.IEmployeeService;

public class EmpMainClass {

	IEmployeeService empService = new EmployeeServiceImpl();

	public static void main(String[] args) {

		EmpMainClass app = new EmpMainClass();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(" === MUNU ==== ");
			System.out.println("1. add employee ");
			System.out.println("2. Display All Employee ");
			System.out.println("3. Edit Salary");
			System.out.println("4. Edit Experience");
			System.out.println("5. Get Employee list based on Salary");
			System.out.println("6. Get Employee list based on Salary Range ");
			System.out.println("0. EXIT");
			System.out.println("Enter Option");
			int option = Integer.parseInt(sc.nextLine());
			switch (option) {

			case 1:

				System.out.println("Enter Employee Id ");
				int empId = Integer.parseInt(sc.nextLine());

				System.out.println("Enter Employee Salary ");
				int empSalary = Integer.parseInt(sc.nextLine());

				System.out.println("Enter Employee Exp ");
				int empExp = Integer.parseInt(sc.nextLine());

				System.out.println("Enter Employee Name ");
				String name = sc.nextLine();

				Employee e = new Employee(empId, name, empExp, empSalary);

				try {
					boolean isInserted = app.empService.addEmployee(e);
					if (isInserted) {
						System.out.println(" Employee Added !!!");
					} else {
						throw new Exception("Cannot added Employee ...");
					}
				} catch (Exception ex) {
					System.out.println(" Contact to Customer Care ... " + ex); // raise the exception
				}

				break;
			case 2:

				ArrayList<Employee> arr = app.empService.getAllEmployees();
				for (Employee emp : arr) {
					System.out.println(emp);
					System.out.println(" ========================================================");
				}
				break;
			case 3:

				System.out.println("Enter the employee id for salary updation");
				int id = Integer.parseInt(sc.nextLine());

				try {
					// System.out.println(id);1

					app.empService.editSalaryByEmployeeId(id);

				} catch (InvalidEmployeeIdExcption e1) {

					System.out.println(e1);
				} catch (WrongSalaryException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				}
				break;
			case 4:
				System.out.println("Enter the employee id for experience updation");
				int id1 = Integer.parseInt(sc.nextLine());
				try {

					app.empService.editExpByEmployeeId(id1);

				} catch (InvalidEmployeeIdExcption e1) {
					// TODO Auto-generated catch block
					System.out.println(e1);
				}
				break;
			case 5:
				System.out.println("Enter the salary to find employee list");
				int salary = Integer.parseInt(sc.nextLine());
				ArrayList<Employee> arr1 = app.empService.getEmployeeBySalary(salary);
				for (Employee emp : arr1) {
					if (emp != null) {
						System.out.println(emp);
						System.out.println(" ========================================================");
					}
				}

				break;
			case 6:
				System.out.println("Enter the min. and max. range of salary");
				int minSal = Integer.parseInt(sc.nextLine());
				int maxSal = Integer.parseInt(sc.nextLine());
				ArrayList<Employee> arr2 = app.empService.getEmployessBySalaryRange(minSal, maxSal);
				for (Employee emp : arr2) {
					if (emp != null) {
						System.out.println(emp);
						System.out.println(" ========================================================");
					}
				}
				break;
			case 0:
				System.exit(0);

			}// end switch
				// sc.close();

		} // end while
	}// end main

}// end class
