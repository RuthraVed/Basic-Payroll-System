package com.zensar.payroll.services;
import java.sql.SQLException;
import java.util.ArrayList;

import com.zensar.payroll.beans.Employee;
import com.zensar.payroll.beans.Salary;
import com.zensar.payroll.daoservices.PayrollDAOServices;
import com.zensar.payroll.daoservices.PayrollDAOServicesImpl;
import com.zensar.payroll.exceptions.EmployeeDetailsNotFoundException;
import com.zensar.payroll.exceptions.PayrollServicesNotFoundException;
public class PayrollServicesImpl  implements PayrollServices{
	PayrollDAOServices daoServices ;
	public PayrollServicesImpl() throws PayrollServicesNotFoundException {
		try {
			daoServices= new PayrollDAOServicesImpl();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw new PayrollServicesNotFoundException("Services Down", e);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollServicesNotFoundException("Services Down", e);
		}
	}
	@Override
	public int acceptEmployeeDetails(int bankAccNo, String firstName,String lastName, String emailId, String panCard, String pfAccNo,String bankIFSCCode, int basicSalary,int pf)
			throws PayrollServicesNotFoundException {
		/*Salary salary = new Salary(basicSalary, pf);
		Employee employee = new Employee(bankAccNo, firstName, lastName, emailId, panCard, pfAccNo, bankIFSCCode, salary) ;
		int empId =daoServices.insertEmployee(employee);
		return empId;*/
		try {
			return daoServices.insertEmployee(new Employee(bankAccNo, firstName, lastName, emailId, panCard, pfAccNo, bankIFSCCode, new Salary(basicSalary, pf)));
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollServicesNotFoundException("Services down",e);
		}
	}
	

	@Override
	public int calculateNetSalary(int empId)throws EmployeeDetailsNotFoundException,PayrollServicesNotFoundException {
		try {
			Employee employee =this.getEmployeeDetails(empId);
			//Tax cal code 
			daoServices.updateEmployee(employee);
			return employee.getSalary().getNetSalary();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollServicesNotFoundException("Services down",e);
		}
	}
	@Override
	public Employee getEmployeeDetails(int empId)throws EmployeeDetailsNotFoundException,PayrollServicesNotFoundException {
		try {
			Employee employee = daoServices.getEmployee(empId);
			if(employee ==null) throw new EmployeeDetailsNotFoundException("Employee details not Found");
			return employee;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PayrollServicesNotFoundException("Services down",e);
		}
	}
	@Override
	public int calculateMonthTaxWithInvestment() {
			return 0;
	}
	@Override
	public ArrayList<Employee> getAllEmployeeDetails()throws PayrollServicesNotFoundException {
		return null;
	}
}
