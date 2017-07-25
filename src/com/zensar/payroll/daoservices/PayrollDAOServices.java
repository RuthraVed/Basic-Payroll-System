package com.zensar.payroll.daoservices;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zensar.payroll.beans.Employee;
public interface PayrollDAOServices {
	int insertEmployee(Employee employee)throws SQLException;
	boolean updateEmployee(Employee employee)throws SQLException;
	Employee getEmployee(int empId) throws SQLException;
	ArrayList<Employee> getEmployees()throws SQLException;

}
