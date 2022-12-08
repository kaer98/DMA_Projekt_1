package model;
/**
 * Customer Class
 *
 *@author Rasmus,Cawan,Frederik,Oskar
 *@version 1.0
 *
 */
public class Customer {
	private String name, cvr, country, postalCode, city, adress, phoneNo, mailAdress;
	private double discount;
	public Customer(String name, String cvr, String country, String postalCode, String city, String adress,
			String phoneNo, String mailAdress, double discount) {
		this.name = name;
		this.cvr = cvr;
		this.country = country;
		this.postalCode = postalCode;
		this.city = city;
		this.adress = adress;
		this.phoneNo = phoneNo;
		this.mailAdress = mailAdress;
		this.discount = discount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCvr() {
		return cvr;
	}
	public void setCvrNoOrCprNo(String cvr) {
		this.cvr = cvr;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMailAdress() {
		return mailAdress;
	}
	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
		
		
		
	}
	
	
	
}
