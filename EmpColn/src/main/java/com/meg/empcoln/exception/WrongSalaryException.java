package com.meg.empcoln.exception;

public class WrongSalaryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongSalaryException() {
		super();
		// TODO Auto-generated constructor stub
	}

	int salary;
	// int exp;

	public WrongSalaryException(int salary) {
		super();
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "WrongSalaryExc [salary=" + salary + "]";
	}

}
