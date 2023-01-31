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
import model.Order;
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

public class PartQuantityManager extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtAmount;
	private PartOrder po;
	private OrderController oCtrl;
	private JLabel lblError;
	private POS pos;
	private Order o;

	/**
	 * Create the dialog.
	 */
	public PartQuantityManager(Order o, PartOrder po, OrderController oCtrl, POS pos) {
		setTitle("Indtast ønsket antal");
		setBounds(100, 100, 304, 130);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{230, 0};
		gbl_contentPanel.rowHeights = new int[]{32, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		txtAmount = new JTextField();
		txtAmount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblError.setText("");
			}
		});
		txtAmount.setToolTipText("Input appliance serial number");
		GridBagConstraints gbc_txtAmount = new GridBagConstraints();
		gbc_txtAmount.insets = new Insets(0, 0, 5, 0);
		gbc_txtAmount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAmount.gridx = 0;
		gbc_txtAmount.gridy = 0;
		contentPanel.add(txtAmount, gbc_txtAmount);
		txtAmount.setColumns(10);
		
		
		
		lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblError.gridx = 0;
		gbc_lblError.gridy = 1;
		contentPanel.add(lblError, gbc_lblError);
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
		init(o, po, oCtrl, pos);
	}
	
	private void cancelClicked() {
		this.dispose();
		this.setVisible(false);

	}
	private void init(Order o, PartOrder po, OrderController oCtrl, POS pos) {
		this.o = o;
		this.oCtrl = oCtrl;
		this.po = po;;
		this.pos = pos;
	}
	
	private void okClicked() {
		try {
			int amount = Integer.parseInt(txtAmount.getText());
			if(amount > 0 && amount <= po.getProduct().getQuantity() + po.getQuantity()) {
				int q = oCtrl.findProductByBarcode(po.getProduct().getBarcode()).getQuantity();
				oCtrl.findProductByBarcode(po.getProduct().getBarcode()).setQuantity(q+po.getQuantity());
				oCtrl.partOrderSetQuantity(amount, po);
				oCtrl.findProductByBarcode(po.getProduct().getBarcode()).setQuantity(oCtrl.findProductByBarcode(po.getProduct().getBarcode()).getQuantity()-amount);
				this.dispose();
				this.setVisible(false);	
			}
			if(amount == 0) {
				oCtrl.removePartFromOrder(o, po);
				this.dispose();
				this.setVisible(false);	
			}
			else {
				lblError.setText("Ikke nok på lager af det valgte produkt");
			}
		} catch(Exception e) {
			lblError.setText("Du kan kun indtaste hele tal!");
		}
		pos.displayOrder();
		pos.displayProducts();
		pos.displayPrices();
	}
}
