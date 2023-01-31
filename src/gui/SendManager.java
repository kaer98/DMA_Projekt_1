package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;
import model.Appliance;
import model.Order;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SendManager extends JDialog {
	
	private POS pos;
	private Order o;
	
	public SendManager(POS pos, Order o) {
		setBounds(100, 100, 293, 77);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.CENTER);
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				JButton btnOffer = new JButton("Send som tilbud");
				btnOffer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						offerClicked();
					}
				});
				btnOffer.setActionCommand("OK");
				buttonPane.add(btnOffer);
				getRootPane().setDefaultButton(btnOffer);
			}
			{
				JButton btnInvoice = new JButton("Send som regning");
				btnInvoice.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						invoiceClicked();
					}
				});
				btnInvoice.setActionCommand("Cancel");
				buttonPane.add(btnInvoice);
			}
		}
		init(pos, o);
	}
	private void init(POS pos, Order o) {
		this.pos = pos;
		this.o = o;	
	}
	
	private void offerClicked(){
		o.setFinal("Tilbud");
		pos.finishOrder();
		this.dispose();
		this.setVisible(false);	
	}
	
	private void invoiceClicked(){
		o.setFinal("Faktura");
		pos.finishOrder();
		this.dispose();
		this.setVisible(false);	
	}
}
