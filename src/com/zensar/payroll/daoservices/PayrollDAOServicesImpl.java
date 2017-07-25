package com.zensar.payroll.daoservices;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import com.zensar.payroll.beans.Employee;
import com.zensar.payroll.beans.Salary;
import com.zensar.payroll.jdbcconfig.ConnectionProvider;
public class PayrollDAOServicesImpl  implements PayrollDAOServices{
	private Connection con;	
	public PayrollDAOServicesImpl() throws ClassNotFoundException, SQLException {
		con=ConnectionProvider.getDBConnection();
	}
	@Override
	public int insertEmployee(Employee employee) throws SQLException {
		try{
			con.setAutoCommit(false);
			//insert for employee
			PreparedStatement pstmt1 = con.prepareStatement("insert into Employee(bankAccNo,firstName,lastName,emailId,panCard,pfAccNo,bankIFSCCode) values(?,?,?,?,?,?,?)");
			pstmt1.setInt(1, employee.getBankAccNo());
			pstmt1.setString(2, employee.getFirstName());
			pstmt1.setString(3, employee.getLastName());
			pstmt1.setString(4	, employee.getEmailId());
			pstmt1.setString(5, employee.getPanCard());
			pstmt1.setString(6, employee.getPfAccNo());
			pstmt1.setString(7, employee.getBankIFSCCode());
			pstmt1.executeUpdate();


			//fetch empid from table

			PreparedStatement pstmt2=con.prepareStatement("select max(empId) from Employee"); 
			ResultSet rs=pstmt2.executeQuery();
			rs.next();
			int empId= rs.getInt(1);

			//insert salary

			PreparedStatement pstmt3 = con.prepareStatement("insert into Salary(empId,basicSalary,pf)values(?,?,?)");
			pstmt3.setInt(1, empId);
			pstmt3.setInt(2, employee.getSalary().getBasicSalary());
			pstmt3.setInt(3, employee.getSalary().getPf());

			pstmt3.executeUpdate();

			con.commit();
			return empId;
		}
		catch(SQLException e){
			con.rollback();
			throw e;
		}
		finally{
			con.setAutoCommit(true);
		}

	}
	@Override

	public boolean updateEmployee(Employee employee) throws SQLException {
		return false;
	}

	@Override
	public Employee getEmployee(int empId) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement("select * from Employee where empId=?");
		pstmt.setInt(1, empId);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			int bankAccNo=rs.getInt(2);
			String firstName=rs.getString(3);
			String lastName=rs.getString(4);
			String emailId=rs.getString(5);
			String panCard=rs.getString(6);
			String pfAccNo=rs.getString(7);
			String bankIFSCCode=rs.getString(8);

			PreparedStatement pstmt1 = con.prepareStatement("select * from Salalry where empId=?");
			ResultSet rs1 = pstmt1.executeQuery();
			int basicSalary=rs1.getInt(2);
			int grossSalary=rs1.getInt(3);
			int netSalary=rs1.getInt(4);
			int hra=rs1.getInt(5);
			int ta=rs1.getInt(6);
			int da=rs1.getInt(7);
			int monthlyTax=rs1.getInt(8);
			int pf=rs1.getInt(9);

			Salary salary = new Salary(basicSalary, grossSalary, netSalary, hra, ta, da, monthlyTax, pf);

			Employee emp= new Employee(empId, bankAccNo, firstName, lastName, emailId, panCard, pfAccNo, bankIFSCCode, salary);
			return emp;
		}
		return null;
	}

	@Override
	public ArrayList<Employee> getEmployees() throws SQLException {
		ArrayList<Employee> empList = new ArrayList<>();
		PreparedStatement pstmt = con.prepareStatement("select * from Employee");
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()){
			int empId=rs.getInt(1);
			int bankAccNo=rs.getInt(2);
			String firstName=rs.getString(3);
			String lastName=rs.getString(4);
			String emailId=rs.getString(5);
			String panCard=rs.getString(6);
			String pfAccNo=rs.getString(7);
			String bankIFSCCode=rs.getString(8);

			PreparedStatement pstmt1 = con.prepareStatement("select * from Salalry where empId=?");
			ResultSet rs1 = pstmt1.executeQuery();
			int basicSalary=rs1.getInt(2);
			int grossSalary=rs1.getInt(3);
			int netSalary=rs1.getInt(4);
			int hra=rs1.getInt(5);
			int ta=rs1.getInt(6);
			int da=rs1.getInt(7);
			int monthlyTax=rs1.getInt(8);
			int pf=rs1.getInt(9);

			Salary salary = new Salary(basicSalary, grossSalary, netSalary, hra, ta, da, monthlyTax, pf);

			Employee emp= new Employee(empId, bankAccNo, firstName, lastName, emailId, panCard, pfAccNo, bankIFSCCode, salary);
			empList.add(emp);
		}
		return empList;
	}






}
