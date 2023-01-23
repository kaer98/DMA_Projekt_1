package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.OrderController;
import controller.ProductController;
import model.Appliance;
import model.ApplianceCopy;
import model.PartOrder;
import model.Product;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class ProductManager extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtAmount;
	private PartOrder po;
	private OrderController oCtrl;
	private JLabel lblError;


	/**
	 * Create the dialog.
	 */
	public ProductManager(PartOrder po, OrderController o, String title) {
		setTitle(title);
		setBounds(100, 100, 264, 120);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		txtAmount = new JTextField();
		txtAmount.setToolTipText("Input appliance serial number");
		txtAmount.setBounds(10, 11, 230, 20);
		contentPanel.add(txtAmount);
		txtAmount.setColumns(10);
		
		
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(10, 30, 220, 13);
		contentPanel.add(lblError);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okClicked();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelClicked();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		init(po, o);
	}
	
	private void cancelClicked() {
		this.dispose();
		this.setVisible(false);

	}
	private void init(PartOrder po, OrderController o) {
		this.oCtrl = o;
		this.po = po;;
		
	}
	
	private void okClicked() {
		int amount = Integer.parseInt(txtAmount.getText());
		if(amount > 0 && amount <= po.getProduct().getQuantity()) {
			oCtrl.partOrderSetQuantity(amount, po);
			this.dispose();
			this.setVisible(false);	
		}
		else {
			lblError.setText("Ikke nok på lager af det valgte produkt");
		}
	}
}
