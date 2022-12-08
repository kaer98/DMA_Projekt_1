package model;
public class Tool {
private String description;
private double hourlyCost, dailyCost;
private int availableAmount, totalQuantity;

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public double getHourlyCost() {
	return hourlyCost;
}

public void setHourlyCost(double hourlyCost) {
	this.hourlyCost = hourlyCost;
}

public double getDailyCost() {
	return dailyCost;
}

public void setDailyCost(double dailyCost) {
	this.dailyCost = dailyCost;
}

public int getAvailableAmount() {
	return availableAmount;
}

public void setAvailableAmount(int availableAmount) {
	this.availableAmount = availableAmount;
}

public int getTotalQuantity() {
	return totalQuantity;
}

public void setTotalQuantity(int totalQuantity) {
	this.totalQuantity = totalQuantity;
}

public Tool(String description, double hourlyCost, double dailyCost, int availableAmount, int totalQuantity) {
	this.description = description;
	this.hourlyCost = hourlyCost;
	this.dailyCost = dailyCost;
	this.availableAmount = availableAmount;
	this.totalQuantity = totalQuantity;
}



}
