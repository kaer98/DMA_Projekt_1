package gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;


import model.Product;

public class ProductTM extends AbstractTableModel{

	private List<Product> data;
	private static final String[] COL_NAMES = {"Beskrivelse", "Lokation", "Lagerstatus", "Pris"};
	
	public ProductTM() {
		this.data = new ArrayList<>();
	}
	
	
	public ProductTM(List<Product> data) {
		this.data = data;
	    if(this.data == null) {
	        this.data = new ArrayList<>();
	    }
	}
@Override
public int getRowCount() {
	return data.size();
}


@Override
public String getColumnName(int col) {
    return COL_NAMES[col];
}
@Override
public int getColumnCount() {
    return COL_NAMES.length;
}

@Override
public Object getValueAt(int rowIndex, int columnIndex) {
	Product p = data.get(rowIndex);
	String res = "";
    switch(columnIndex) {
        case 0: res = p.getDescription(); break;
        case 1: res = "" + p.getLocation(); break;
        case 2: res = "" + p.getQuantity(); break;
        case 3: res = "" + p.getRetailPrice(); break;
        default: res = "<UNKNOWN " + columnIndex + ">";
    }
    return res;

}


public Product getSelectedProduct(int i) {
	return data.get(i);
	
}

public void sort() {
    data.sort((o1, o2) -> o1.getDescription().compareTo(o2.getDescription()));
}
public void setData(List<Product> products) {
	
}

}
