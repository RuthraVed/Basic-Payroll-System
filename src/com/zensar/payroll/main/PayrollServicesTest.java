package com.zensar.payroll.main;


import org.junit.Assert;
import org.junit.Test;

import com.zensar.payroll.beans.Employee;
import com.zensar.payroll.beans.Salary;
import com.zensar.payroll.exceptions.EmployeeDetailsNotFoundException;
import com.zensar.payroll.exceptions.PayrollServicesNotFoundException;
import com.zensar.payroll.services.PayrollServices;
import com.zensar.payroll.services.PayrollServicesImpl;

public class PayrollServicesTest {

	@Test
	public void testCalculateMonthlyTaxForValidData() {
		
	}
	@Test(expected=EmployeeDetailsNotFoundException.class)
	public void testGetEmployeeDetailsForInvalidEmpId() throws PayrollServicesNotFoundException, EmployeeDetailsNotFoundException{
		PayrollServices services = new PayrollServicesImpl();
		services.acceptEmployeeDetails(100032, "Satish", "Mahajab", "satish@gmail.com", "ABC524", "MAH123", "BOI123", 12000, 1000);
		//---------------------------------------------------------------------------
		services.getEmployeeDetails(10);	
	}
	@Test
	public void testGetEmployeeDetailsForValidEmpId() throws PayrollServicesNotFoundException, EmployeeDetailsNotFoundException{
		PayrollServices services = new PayrollServicesImpl();
		services.acceptEmployeeDetails(100032, "Satish", "Mahajab", "satish@gmail.com", "ABC524", "MAH123", "BOI123", 12000, 1000);
		Employee expectedEmp= new Employee(101,100032, "Satish", "Mahajab", "satish@gmail.com", "ABC524", "MAH123", "BOI123", new Salary(12000, 1000));
		Employee actualEmp= services.getEmployeeDetails(101);
		Assert.assertEquals(expectedEmp, actualEmp);

	}
	
	
	
	
	
	
	
	
	

}
