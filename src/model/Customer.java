package model;

/**
 * Customer Class
 *
 * @author Rasmus,Cawan,Frederik,Oskar
 * @version 1.0
 *
 */
public class Customer extends Person {
	private String cvr;
	private double discount;

	// Constructor with paramters to initialize Customer object:
	public Customer(String name, String phoneNo, String mailAddress, String country, String postalCode, String city,
			String address, String cvr, double discount) {

		super(name, phoneNo, mailAddress, country, postalCode, city, address);
		this.cvr = cvr;
		this.discount = discount;

		// Get and Set methods for cvr and discount
	}

	public String getCvr() {
		return cvr;
	}

	public double getDiscount() {
		return discount;
	}

	public void setCvr(String cvr) {
		this.cvr = cvr;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}
