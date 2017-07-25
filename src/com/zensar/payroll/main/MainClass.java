package com.zensar.payroll.main;

import com.zensar.payroll.exceptions.PayrollServicesNotFoundException;
import com.zensar.payroll.services.PayrollServices;
import com.zensar.payroll.services.PayrollServicesImpl;

public class MainClass {
	public static void main(String[] args) throws PayrollServicesNotFoundException  {
		PayrollServices payrollServices = new PayrollServicesImpl();
		int id=payrollServices.acceptEmployeeDetails(10010032, "Satish", "MAhajan", "satish@gmail.com", "AHSHS7373", "MAH222", "BOI122", 120000, 1200);
	
		System.out.println(id);
	}
}







