package gui;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.PartOrder;
import model.Product;

public class OrderTM extends AbstractTableModel{

	private List<PartOrder> data;
	private static final String[] COL_NAMES = {"Beskrivelse", "Pris Pr stk", "Antal", "Pris i alt"};
	
	public OrderTM() {
		this.data = new ArrayList<>();
	}
	
	
	public OrderTM(List<PartOrder> data) {
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
	PartOrder p = data.get(rowIndex);
	String res = "";
    switch(columnIndex) {
        case 0: res = p.getProductName(); break;
        case 1: res = "" + p.getPrice(); break;
        case 2: res = "" + p.getQuantity(); break;
        case 3: res = "" + p.getTotal(); break;
        default: res = "<UNKNOWN " + columnIndex + ">";
    }
    return res;

}


public PartOrder getSelectedProduct(int i) {
	return data.get(i);
	
}

public void sort() {
    data.sort((o1, o2) -> o1.getProductName().compareTo(o2.getProductName()));
}
public void setData(List<PartOrder> partOrders) {
	
}

}