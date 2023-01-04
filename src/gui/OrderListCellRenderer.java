package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Order;

public class OrderListCellRenderer implements ListCellRenderer<Order>{

	@Override
	public Component getListCellRendererComponent(JList<? extends Order> list, Order value, int index, boolean isSelected,
			boolean cellHasFocus) {
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		return dlcr.getListCellRendererComponent(list, value.getOrderNo(), index, isSelected, cellHasFocus);
	}

}