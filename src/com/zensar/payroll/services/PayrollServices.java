package com.zensar.payroll.services;
import java.util.ArrayList;

import com.zensar.payroll.beans.Employee;
import com.zensar.payroll.exceptions.EmployeeDetailsNotFoundException;
import com.zensar.payroll.exceptions.PayrollServicesNotFoundException;
public interface PayrollServices {
	int acceptEmployeeDetails(int bankAccNo,String firstName,String lastName
			,String emailId,String panCard,String pfAccNo,String bankIFSCCode,int basicSalary,int pf)throws PayrollServicesNotFoundException;
	
	
	int calculateNetSalary(int empId)throws EmployeeDetailsNotFoundException,PayrollServicesNotFoundException;
	
	int calculateMonthTaxWithInvestment();
	
	Employee getEmployeeDetails(int empId)throws EmployeeDetailsNotFoundException,PayrollServicesNotFoundException;
	
	ArrayList<Employee>  getAllEmployeeDetails() throws PayrollServicesNotFoundException;
}
