package com.zensar.payroll.beans;
public class Salary {
	private int basicSalary,grossSalary,netSalary,hra,ta,da,monthlyTax,pf;
	public Salary() {}
	public Salary(int basicSalary,int pf) {
		super();
		this.basicSalary = basicSalary;
		this.pf=pf;
	}
	
	
	public Salary(int basicSalary, int grossSalary, int netSalary, int hra,
			int ta, int da, int monthlyTax, int pf) {
		super();
		this.basicSalary = basicSalary;
		this.grossSalary = grossSalary;
		this.netSalary = netSalary;
		this.hra = hra;
		this.ta = ta;
		this.da = da;
		this.monthlyTax = monthlyTax;
		this.pf = pf;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + basicSalary;
		result = prime * result + da;
		result = prime * result + grossSalary;
		result = prime * result + hra;
		result = prime * result + monthlyTax;
		result = prime * result + netSalary;
		result = prime * result + pf;
		result = prime * result + ta;
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
		Salary other = (Salary) obj;
		if (basicSalary != other.basicSalary)
			return false;
		if (da != other.da)
			return false;
		if (grossSalary != other.grossSalary)
			return false;
		if (hra != other.hra)
			return false;
		if (monthlyTax != other.monthlyTax)
			return false;
		if (netSalary != other.netSalary)
			return false;
		if (pf != other.pf)
			return false;
		if (ta != other.ta)
			return false;
		return true;
	}
	public int getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(int basicSalary) {
		this.basicSalary = basicSalary;
	}
	public int getGrossSalary() {
		return grossSalary;
	}
	public void setGrossSalary(int grossSalary) {
		this.grossSalary = grossSalary;
	}
	public int getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(int netSalary) {
		this.netSalary = netSalary;
	}
	public int getHra() {
		return hra;
	}
	public void setHra(int hra) {
		this.hra = hra;
	}
	public int getTa() {
		return ta;
	}
	public void setTa(int ta) {
		this.ta = ta;
	}
	public int getDa() {
		return da;
	}
	public void setDa(int da) {
		this.da = da;
	}
	public int getMonthlyTax() {
		return monthlyTax;
	}
	public void setMonthlyTax(int monthlyTax) {
		this.monthlyTax = monthlyTax;
	}
	public int getPf() {
		return pf;
	}
	public void setPf(int pf) {
		this.pf = pf;
	}
	@Override
	public String toString() {
		return "Salary [basicSalary=" + basicSalary + ", grossSalary="
				+ grossSalary + ", netSalary=" + netSalary + ", hra=" + hra
				+ ", ta=" + ta + ", da=" + da + ", monthlyTax=" + monthlyTax
				+ ", pf=" + pf + "]";
	}
	
}
