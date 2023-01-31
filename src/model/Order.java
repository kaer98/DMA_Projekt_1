package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

public class Order {
	private static final DecimalFormat dfSharp = new DecimalFormat("#.##");
	private ArrayList<PartOrder> parts;
	private LocalDate dateTime;
	private Customer customer;
	private Employee employee;
	private int orderNo;
	private static int orderTotal = 0;
	private String finalized;
	private double total;

	public Order(Employee employee) {
		this.parts = new ArrayList<>();
		this.dateTime = LocalDate.now();
		this.employee = employee;
		orderTotal++;
		orderNo = orderTotal;
		this.finalized = "intet";
	}
	
	public void addNewPartOrderAppliance(ApplianceCopy p) {
		parts.add(new PartOrderAppliance(p));
	}
	/*
	 * createInvoice() is used to create an invoice.
	 */

	public void addNewPartOrderQ(Product product, int quantity) {
		parts.add(new PartOrderSimpleAppliance(product, quantity));
	}

	public void addPartOrder(PartOrder partOrder) {
		parts.add(partOrder);
	}

	
	public Customer getCustomer() {
		return customer;
	}

	public LocalDate getDateTime() {
		return dateTime;
	}

	public Employee getEmployee() {
		return employee;
	}

	public String getFinal() {
		return finalized;
	}

	// Getters and setters
	public int getOrderNo() {
		return orderNo;
	}

	public ArrayList<PartOrder> getParts() {
		return parts;
	}

	public double getTotal() {
		total = 0;
		for (PartOrder p : parts) {
			total += p.getTotal();
		}
		return total;
	}

	public double getTotalWDiscount() {
		double total = getTotal() * (1 - getCustomer().getDiscount());
		return total;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setDateTime(LocalDate dateTime) {
		this.dateTime = dateTime;
	}

	/*
	 * The following methods adds partOrders/changes the quantity/ adds appliance
	 */

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setFinal(String string) {
		finalized = string;
	}

	
	public void removePart(PartOrder po) {
		boolean found = false;
		int i = 0;
		while(i<parts.size() && !found) {
			if(parts.get(i).getId()==po.getId()) {
				parts.remove(i);{
					found=true;
				}
			}
			else {
				i++;
			}
		}
	}

	public void setParts(ArrayList<PartOrder> parts) {
		this.parts = parts;
	}
	
	public PartOrder findPartOrderByProductName(String pName) {
		PartOrder part = null;
		int index = 0;
		boolean found = false;
		while (index < parts.size() && !found) {
			part = parts.get(index);
			if (part.getProductName().contains(pName)) {
				found = true;
			} else {
				index++;
			}
		}
		if (found) {
			return part;
		} else {
			return null;
		}
	}
	
	public void invoice() {
		File file = new File(orderNo+".txt");
		try {
			double discount = 0;
			FileWriter writer = new FileWriter(orderNo+".txt");
			writer.write("#######Vestbjerg Byggecenter A/S#######");
			writer.write(System.lineSeparator());
			writer.write("Medarbejder: " + employee.getName());
			writer.write(System.lineSeparator());
			writer.write("Dato: " + dateTime + " 					Fakturanr.:" + orderNo);
			writer.write(System.lineSeparator());
			writer.write("Faktura");
			if (getFinal() == "Salg")
				writer.write("Betalingsdato: " + dateTime + " 					Type: " + getFinal());
			writer.write(System.lineSeparator());
			if (getFinal() == "Faktura")
				writer.write("Betalingsdato: " + dateTime.plusDays(14) + " 					Type: " + getFinal());
			writer.write(System.lineSeparator());
			if (getFinal() == "Tilbud")
				writer.write("Tilbud acceptdato: " + dateTime.plusDays(14) + " 					Type: " + getFinal());
			writer.write(System.lineSeparator());
			writer.write("Kunde: " + customer.getName() + " \nKundes telefon: " + customer.getPhoneNo());
			writer.write(System.lineSeparator());
			writer.write("Kundes e-mail: " + customer.getMailAddress() + " \nKundes adresse: " + customer.getAddress());
			writer.write(System.lineSeparator());
			writer.write("Kundes CVR-nr: " + customer.getCvr());
			for (PartOrder parts : getParts()) {
				if (parts.getQuantity() != 0 && !parts.getProduct().isAppliance())
					writer.write("\nBeskrivelse: " + parts.getProductName() + " Antal: " + parts.getQuantity() + " Stk. Pris: " + parts.getProduct().getRetailPrice() + " Pris: " + dfSharp.format(parts.getTotal()));
				if (parts.getProduct().isAppliance()) {
					writer.write("\nBeskrivelse: " + parts.getProductName() + " Pris: " + dfSharp.format(parts.getTotal()));
					writer.write(" serienummer: " + parts.getCopy().getSerialNo());
				}
			}
			writer.write(System.lineSeparator());
			writer.write("Subtotal: " + dfSharp.format(getTotal())+"kr");
			if (customer.getDiscount() != 0) {
				discount = getTotal() * (customer.getDiscount());
				writer.write("-" + dfSharp.format((customer.getDiscount()) * 100) + "% rabat " + "(" + discount + ")");
			}
			writer.write(System.lineSeparator());
			writer.write("Moms (25%): " + dfSharp.format(getTotalWDiscount() * 0.25) + "kr af " + dfSharp.format(getTotalWDiscount())+"kr");
			writer.write(System.lineSeparator());
			writer.write("Total DKK: " + (dfSharp.format(getTotalWDiscount() * 1.25)));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
	}
}
