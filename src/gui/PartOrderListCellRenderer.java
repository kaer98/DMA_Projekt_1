package gui;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

import model.Order;
import model.PartOrder;

public class PartOrderListCellRenderer implements ListCellRenderer<PartOrder>{

	@Override
	public Component getListCellRendererComponent(JList<? extends PartOrder> list, PartOrder value, int index, boolean isSelected,
			boolean cellHasFocus) {
		DefaultListCellRenderer dlcr = new DefaultListCellRenderer();
		return dlcr.getListCellRendererComponent(list, value.getProductName(), index, isSelected, cellHasFocus);
	}
}
