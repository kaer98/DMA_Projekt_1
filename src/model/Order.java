package model;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
	private ArrayList<PartOrder> parts;
	private LocalDate dateTime;
	private Customer customer;
	private Employee employee;
	private static int orderNo;
	private String finalized;
	private double total, discount;
	private static final DecimalFormat dfSharp = new DecimalFormat("#.##");
	
	public Order(Employee employee) {
		this.parts = new ArrayList<>();
		this.dateTime = LocalDate.now();
		this.employee = employee;
		++this.orderNo;
		this.finalized = "intet";
	}
	
	public int getOrderNo() {
		return orderNo;
	}
	
	public void setFinal(String string) {
		finalized = string;
	}
	
	public String getFinal() {
		return finalized;
	}
	
	public double getTotal() {
		total = 0;
		for(PartOrder p : parts) {
			total += p.getTotal();
		}
		return total;
	}
	
	public double getTotalWDiscount() {
		double total = getTotal() * (1-getCustomer().getDiscount());
		return total;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public ArrayList<PartOrder> getParts() {
		return parts;
	}

	public void setParts(ArrayList<PartOrder> parts) {
		this.parts = parts;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public void addPartOrder(PartOrder partOrder) {
		parts.add(partOrder);
	}
	
	public void addNewPartOrderQ(Product product, int quantity) {
		parts.add(new PartOrderQ(product, quantity));
	}
	
	public void addNewPartOrderAppliance(Product product, String serialNo) {
		parts.add(new PartOrderAppliance(product, serialNo));
	}
	
	public void createInvoice() {
		double discount = 0;
		System.out.println("Vestbjerg Byggecenter A/S");
		System.out.println("Adresse");
		System.out.println("By");
		System.out.println("CVR-nr.:");
		System.out.println("Medarbejder: "+ employee.getName());
		System.out.println();
		System.out.println("Dato: " + dateTime +" 					Fakturanr.:"+ orderNo);
		System.out.println();
		System.out.println("Faktura");
		System.out.println("Betalingsdato: "+ dateTime.plusDays(14) +" 					Tilbud: " + getFinal());
		System.out.println("Kunde: "+ customer.getName() + " Kundes telefon: "+ customer.getPhoneNo());
		System.out.println("Kunde e-mail: "+ customer.getMalAddress() + " Kunde adresse "+ customer.getAddress());
		for(PartOrder parts : getParts()) {
			if(parts.getQuantity()!=0)
			System.out.println("\nBeskrivelse: " + parts.getProductName() + " Antal: " + parts.getQuantity() + " Stk. Pris: " + parts.getProduct().getRetailPrice() + " Pris: " + dfSharp.format(parts.getTotal()));
		}
		System.out.println("");
		System.out.println("Subtotal: "+ dfSharp.format(getTotal()));
		if(customer.getDiscount()!=0) {
			discount = getTotal()*(customer.getDiscount());
			System.out.println(" -"+(customer.getDiscount()*100)+"% rabat");
			System.out.println(discount);
		}
		System.out.println("Moms (25.00%): " + (getTotalWDiscount() * 0.25)+ " af " + getTotalWDiscount());
		System.out.println("Total DKK: " + (getTotalWDiscount() * 1.25));

	}

	}
	
	


