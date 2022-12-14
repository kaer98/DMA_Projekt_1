package model;

public abstract class Person {
	private String name, phoneNo, mailAddress, country, postalCode, city, address;

	public Person(String name, String phoneNo, String mailAddress, String country, String postalCode, String city,
			String address) {

		this.name = name;
		this.phoneNo = phoneNo;
		this.mailAddress = mailAddress;
		this.country = country;
		this.postalCode = postalCode;
		this.city = city;
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getMalAddress() {
		return mailAddress;
	}

	// Get and Set methods
	public String getName() {
		return name;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setMalAddress(String malAddress) {
		this.mailAddress = malAddress;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	// No abstract methods so classes can extend Person

}
