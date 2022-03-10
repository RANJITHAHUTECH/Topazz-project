package com.hutech.topazproject.dto;

public class DashboardDto {

	private int customerOrders;
	private int CustomerSuppliers;
	private int CustomerRegistration;
	private int Customerproducts;

	public int getCustomerOrders() {
		return customerOrders;
	}

	public void setCustomerOrders(int customerOrders) {
		this.customerOrders = customerOrders;
	}

	public int getCustomerSuppliers() {
		return CustomerSuppliers;
	}

	public void setCustomerSuppliers(int customerSuppliers) {
		CustomerSuppliers = customerSuppliers;
	}

	public int getCustomerRegistration() {
		return CustomerRegistration;
	}

	public void setCustomerRegistration(int customerRegistration) {
		CustomerRegistration = customerRegistration;
	}

	public int getCustomerproducts() {
		return Customerproducts;
	}

	public void setCustomerproducts(int customerproducts) {
		Customerproducts = customerproducts;
	}

	public DashboardDto(int customerOrders, int customerSuppliers, int customerRegistration, int customerproducts) {
		super();
		this.customerOrders = customerOrders;
		CustomerSuppliers = customerSuppliers;
		CustomerRegistration = customerRegistration;
		Customerproducts = customerproducts;
	}

	public DashboardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "DashboardDto [customerOrders=" + customerOrders + ", CustomerSuppliers=" + CustomerSuppliers
				+ ", CustomerRegistration=" + CustomerRegistration + ", Customerproducts=" + Customerproducts + "]";
	}

}
