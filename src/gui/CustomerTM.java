package gui;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Customer;

public class CustomerTM extends AbstractTableModel {

	private List<Customer> data;
	private static final String[] COL_NAMES = {"Navn", "E-mail", "Tlf nr.", "CVR nr."};
	
	public CustomerTM() {
		this.data = new ArrayList<>();
	}
	
	
	public CustomerTM(List<Customer> data) {
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
	Customer c = data.get(rowIndex);
	String res = "";
    switch(columnIndex) {
        case 0: res = c.getName(); break;
        case 1: res = "" + c.getMailAddress(); break;
        case 2: res = "" + c.getPhoneNo(); break;
        case 3: res = "" + c.getCvr(); break;
        default: res = "<UNKNOWN " + columnIndex + ">";
    }
    return res;

}


public Customer getSelectedMember(int i) {
	return data.get(i);
	
}
public void setData(List<Customer> members) {
	
}
}
