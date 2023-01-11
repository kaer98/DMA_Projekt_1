package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Customer;
import model.PartOrder;

public class CustomerListCellRendere implements ListCellRenderer<Customer>{

	@Override
	public Component getListCellRendererComponent(JList<? extends Customer> list, Customer value, int index, boolean isSelected,
			boolean cellHasFocus) {
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		return dlcr.getListCellRendererComponent(list, value.getName(), index, isSelected, cellHasFocus);
	}
}
