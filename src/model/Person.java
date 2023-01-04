package model;

public abstract class Person {
	private String name, phoneNo, mailAddress, country, postalCode, city, address;
	private static int id;

	public Person(String name, String phoneNo, String mailAddress, String country, String postalCode, String city,
			String address) {

		this.name = name;
		this.phoneNo = phoneNo;
		this.mailAddress = mailAddress;
		this.country = country;
		this.postalCode = postalCode;
		this.city = city;
		this.address = address;
		++id;
	}
	
//getters for class Person
	public String getName() {
		return name;
	}
	
	public String getPhoneNo() {
		return phoneNo;
	}

	public String getMailAddress() {
		return mailAddress;
	}
	
	public String getCountry() {
		return country;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public String getCity() {
		return city;
	}

	public String getAddress() {
		return address;
	}

	//setters for class Person
	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public int getId() {
		return id;
	}

	

	// No abstract methods so classes can extend Person

}
