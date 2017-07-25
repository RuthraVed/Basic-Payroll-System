package com.zensar.payroll.beans;
public class Employee {
	private int empId,bankAccNo;
	private String firstName,lastName,emailId,panCard,pfAccNo,bankIFSCCode;
	private Salary salary;
	public Employee() {}
	
	
	public Employee(int bankAccNo, String firstName, String lastName,
			String emailId, String panCard, String pfAccNo,
			String bankIFSCCode, Salary salary) {
		super();
		this.bankAccNo = bankAccNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.panCard = panCard;
		this.pfAccNo = pfAccNo;
		this.bankIFSCCode = bankIFSCCode;
		this.salary = salary;
	}


	public Employee(int empId, int bankAccNo, String firstName,
			String lastName, String emailId, String panCard, String pfAccNo,
			String bankIFSCCode, Salary salary) {
		super();
		this.empId = empId;
		this.bankAccNo = bankAccNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.panCard = panCard;
		this.pfAccNo = pfAccNo;
		this.bankIFSCCode = bankIFSCCode;
		this.salary = salary;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bankAccNo;
		result = prime * result
				+ ((bankIFSCCode == null) ? 0 : bankIFSCCode.hashCode());
		result = prime * result + ((emailId == null) ? 0 : emailId.hashCode());
		result = prime * result + empId;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((panCard == null) ? 0 : panCard.hashCode());
		result = prime * result + ((pfAccNo == null) ? 0 : pfAccNo.hashCode());
		result = prime * result + ((salary == null) ? 0 : salary.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (bankAccNo != other.bankAccNo)
			return false;
		if (bankIFSCCode == null) {
			if (other.bankIFSCCode != null)
				return false;
		} else if (!bankIFSCCode.equals(other.bankIFSCCode))
			return false;
		if (emailId == null) {
			if (other.emailId != null)
				return false;
		} else if (!emailId.equals(other.emailId))
			return false;
		if (empId != other.empId)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (panCard == null) {
			if (other.panCard != null)
				return false;
		} else if (!panCard.equals(other.panCard))
			return false;
		if (pfAccNo == null) {
			if (other.pfAccNo != null)
				return false;
		} else if (!pfAccNo.equals(other.pfAccNo))
			return false;
		if (salary == null) {
			if (other.salary != null)
				return false;
		} else if (!salary.equals(other.salary))
			return false;
		return true;
	}


	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getBankAccNo() {
		return bankAccNo;
	}
	public void setBankAccNo(int bankAccNo) {
		this.bankAccNo = bankAccNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public String getPfAccNo() {
		return pfAccNo;
	}
	public void setPfAccNo(String pfAccNo) {
		this.pfAccNo = pfAccNo;
	}
	public String getBankIFSCCode() {
		return bankIFSCCode;
	}
	public void setBankIFSCCode(String bankIFSCCode) {
		this.bankIFSCCode = bankIFSCCode;
	}
	public Salary getSalary() {
		return salary;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", bankAccNo=" + bankAccNo
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", emailId=" + emailId + ", panCard=" + panCard
				+ ", pfAccNo=" + pfAccNo + ", bankIFSCCode=" + bankIFSCCode
				+ ", salary=" + salary + "]";
	}
}
