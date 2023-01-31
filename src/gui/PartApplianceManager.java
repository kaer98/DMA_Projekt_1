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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.BoxLayout;

public class PartApplianceManager extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSearch;
	private OrderController oCtrl;
	private ProductController pCtrl;
	private PartOrder po;
	private POS pos;
	private JLabel lblError;


	/**
	 * Create the dialog.
	 */
	public PartApplianceManager(PartOrder po, OrderController o, POS pos, ProductController p) {
		setTitle("Indtast serienummer på " + po.getProduct().getDescription());
		setBounds(100, 100, 379, 118);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		txtSearch = new JTextField();
		txtSearch.setBounds(10, 11, 343, 20);
		txtSearch.setToolTipText("Input appliance serial number");
		contentPanel.add(txtSearch);
		txtSearch.setColumns(10);
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(10, 29, 181, 13);
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
		init(po, o, pos, p);
	}
	
	private void cancelClicked() {
		this.dispose();
		this.setVisible(false);

	}
	private void init(PartOrder po, OrderController o, POS pos, ProductController p) {
		this.oCtrl = o;
		this.po = po;
		this.pos = pos;
		this.pCtrl = p;
		
	}
	
	private void okClicked() {
		ApplianceCopy oldAC = po.getCopy();
		ApplianceCopy applianceCopy = pCtrl.findApplianceCopyBySerialNo(po.getProduct(), txtSearch.getText());
		if(applianceCopy == null || txtSearch.getText().contentEquals("")) {
			lblError.setText("Ikke fundet, prøv igen!");
		}
		else {
			pCtrl.addApplianceCopy(oldAC, oldAC.getAppliance());
			oCtrl.setProduct(applianceCopy, po);
			pCtrl.findProductByBarcode(applianceCopy.getAppliance().getBarcode()).updateQuantity(applianceCopy.getSerialNo());
			this.dispose();
			this.setVisible(false);	
		}
		pos.displayOrder();
		pos.displayPrices();
		pos.displayProducts();
	}
}
