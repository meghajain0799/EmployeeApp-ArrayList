package com.meg.empcoln.exception;

public class InvalidEmployeeIdExcption extends Exception {

	public InvalidEmployeeIdExcption() {
		super();
		// TODO Auto-generated constructor stub
	}
	int id;
	public InvalidEmployeeIdExcption(int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "InvalidEmployeeIdExcption [id=" + id + "]";
	}
	

}

