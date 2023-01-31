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

public class ApplianceManager extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSearch;
	private Appliance appliance;
	private OrderController oCtrl;
	private JLabel lblError;
	private POS pos;

	/**
	 * Create the dialog.
	 */
	public ApplianceManager(Appliance a, OrderController o, POS pos) {
		setTitle("Indtast serienummer på " + a.getDescription());
		setBounds(100, 100, 401, 120);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		txtSearch = new JTextField();
		txtSearch.setToolTipText("Input appliance serial number");
		txtSearch.setBounds(10, 11, 365, 20);
		contentPanel.add(txtSearch);
		txtSearch.setColumns(10);
		
		
		
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
				JButton cancelButton = new JButton("Annuller");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelClicked();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		init(a, o, pos);
	}
	
	private void cancelClicked() {
		this.dispose();
		this.setVisible(false);

	}
	private void init(Appliance a, OrderController o, POS pos) {
		this.oCtrl = o;
		this.appliance = a;
		this.pos = pos;
		
	}
	
	private void okClicked() {
		ProductController pCtrl = new ProductController();
		ApplianceCopy applianceCopy = pCtrl.findApplianceCopyBySerialNo(appliance, txtSearch.getText());
		if(applianceCopy == null || txtSearch.getText().contentEquals("")) {
			lblError.setText("Ikke fundet, prøv igen!");
		}
		else {
			oCtrl.addNewPartOrderAppliance(applianceCopy);
			oCtrl.findProductByBarcode(appliance.getBarcode()).updateQuantity(applianceCopy.getSerialNo());;
			this.dispose();
			this.setVisible(false);	
		}
		pos.displayOrder();
		pos.displayProducts();
		pos.displayPrices();
	}
}
