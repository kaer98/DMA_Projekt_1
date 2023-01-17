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

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class FindApplianceCopy extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSearch;
	private Appliance appliance;
	private OrderController oCtrl;
	private JLabel lblError;


	/**
	 * Create the dialog.
	 */
	public FindApplianceCopy(Appliance a, OrderController o) {
		setBounds(100, 100, 264, 120);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			txtSearch = new JTextField();
			txtSearch.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					searchbarFocus();
				}
			});
			txtSearch.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					searchbarFocus();
				}
			});
			txtSearch.setToolTipText("Input appliance serial number");
			txtSearch.setText("Serial number");
			txtSearch.setBounds(10, 11, 230, 20);
			contentPanel.add(txtSearch);
			txtSearch.setColumns(10);
		}
		
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
		init(a, o);
	}
	
	private void cancelClicked() {
		this.dispose();
		this.setVisible(false);

	}
	private void init(Appliance a, OrderController o) {
		this.oCtrl = o;
		this.appliance = a;
	}
	
	private void okClicked() {
		ProductController pCtrl = new ProductController();
		ApplianceCopy applianceCopy = pCtrl.findApplianceCopyBySerialNo(appliance, txtSearch.getText());
		if(applianceCopy == null) {
			lblError.setText("Ikke fundet, prøv igen!");
		}
		else {
			oCtrl.addNewPartOrderAppliance(applianceCopy);
			this.dispose();
			this.setVisible(false);	
		}
	}
	
	private void searchbarFocus(){
		if(txtSearch.getText().equals("Serial number") && txtSearch.hasFocus()) {
			txtSearch.setText(null);
		}
		else if(txtSearch.getText().equals("") && !txtSearch.hasFocus()) {
			txtSearch.setText("Serial number");
		}
	}
}
