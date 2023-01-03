package gui;
import model.Customer;
import controller.CustomerController;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CustomerGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private CustomerController cCtrl;
	private Customer currCustomer;
	private JTextField txtName;
	private JTextField txtCVR;
	private JTextField txtPhone;
	private JTextField txtEmail;
	private JTextField txtAddress;
	private JButton btnOK;
	private JButton btnCancel;
	private JButton btnSave;
	private JTextField txtPostalcode;
	private JTextField txtCity;
	private JTextField txtCountry;
	private JTextField txtDiscount;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CustomerGUI dialog = new CustomerGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CustomerGUI() {
		setBounds(150, 150, 675, 450);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 434, 11);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.WEST);
			panel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setBounds(-23, 11, 46, 14);
			panel.add(lblNewLabel);
		}
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setBounds(434, 367, 215, 33);
			getContentPane().add(buttonPanel);
			{
				btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelClicked();
					}
				});
				btnCancel.setActionCommand("Cancel");
			}
			{
				btnSave = new JButton("Save");
			}
			buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			{
				btnOK = new JButton("OK");
				btnOK.setActionCommand("OK");
				getRootPane().setDefaultButton(btnOK);
			}
			buttonPanel.add(btnOK);
			buttonPanel.add(btnSave);
			buttonPanel.add(btnCancel);
		}
				
		JLabel lblNewLabel_2 = new JLabel("Customer Info:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(10, 10, 95, 15);
		getContentPane().add(lblNewLabel_2);
		
		txtName = new JTextField();
		txtName.setBounds(74, 30, 85, 20);
		getContentPane().add(txtName);
		txtName.setColumns(10);
		
		txtCVR = new JTextField();
		txtCVR.setBounds(74, 60, 85, 20);
		getContentPane().add(txtCVR);
		txtCVR.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(74, 90, 85, 20);
		getContentPane().add(txtPhone);
		txtPhone.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(74, 120, 85, 20);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(74, 150, 85, 20);
		getContentPane().add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel name = new JLabel("Name.................");
		name.setBounds(10, 36, 64, 15);
		getContentPane().add(name);
		
		JLabel lblNewLabel_3 = new JLabel("Phone.........");
		lblNewLabel_3.setBounds(10, 96, 64, 15);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("E-mail.........");
		lblNewLabel_4.setBounds(10, 126, 64, 15);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address........");
		lblNewLabel_5.setBounds(10, 156, 64, 15);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("CVR...........");
		lblNewLabel_6.setBounds(10, 66, 64, 15);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Postalcode...");
		lblNewLabel_7.setBounds(10, 186, 64, 15);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("City.............");
		lblNewLabel_8.setBounds(10, 216, 64, 15);
		getContentPane().add(lblNewLabel_8);
		
		txtPostalcode = new JTextField();
		txtPostalcode.setBounds(74, 180, 85, 20);
		getContentPane().add(txtPostalcode);
		txtPostalcode.setColumns(10);
		
		txtCity = new JTextField();
		txtCity.setBounds(74, 210, 85, 20);
		getContentPane().add(txtCity);
		txtCity.setColumns(10);
		
		txtCountry = new JTextField();
		txtCountry.setBounds(74, 240, 85, 20);
		getContentPane().add(txtCountry);
		txtCountry.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Country.........");
		lblNewLabel_9.setBounds(10, 246, 64, 15);
		getContentPane().add(lblNewLabel_9);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 293, 333, 107);
		getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{216, 2, 0};
		gbl_panel.rowHeights = new int[]{2, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.anchor = GridBagConstraints.NORTHWEST;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		list.setBounds(248, 32, 380, 230);
		getContentPane().add(list);
		
		JLabel lblNewLabel_1 = new JLabel("Discount.........");
		lblNewLabel_1.setBounds(10, 276, 64, 15);
		getContentPane().add(lblNewLabel_1);
		
		txtDiscount = new JTextField();
		txtDiscount.setBounds(74, 270, 85, 20);
		getContentPane().add(txtDiscount);
		txtDiscount.setColumns(10);
	}
	
	private void displayMember() {
		this.txtName.setText(currCustomer.getName());
		this.txtCVR.setText(currCustomer.getCvr());
		this.txtEmail.setText(currCustomer.getMailAddress());
		this.txtPhone.setText(currCustomer.getPhoneNo());
		this.txtAddress.setText(currCustomer.getAddress());
		this.txtPostalcode.setText(currCustomer.getPostalCode());
		this.txtCity.setText(currCustomer.getCity());
		this.txtCountry.setText(currCustomer.getCity());

	}
	
	private void okClicked() {
		String name = txtName.getText();
		String cvr = txtCVR.getText();
		String email = txtEmail.getText();
		String phone = txtPhone.getText();
		String address = txtAddress.getText();
		String postalcode = txtPostalcode.getText();
		String city = txtCity.getText();
		String country = txtCountry.getText();
		double discount = Double.parseDouble(txtDiscount.getText());
		
		try {
			if(currCustomer == null) {
				currCustomer = cCtrl.addNewCustomer(name, phone, email, country, postalcode,
						city, address, cvr, discount);
			} else {
				cCtrl.updateCustomer(currCustomer.getPhoneNo(), name, phone, email, country, postalcode,
				city, address, cvr, discount);
			}
			System.out.println(currCustomer);//TODO remove, this is for debugging/trying out
		} catch(IllegalArgumentException iae) {
			JOptionPane.showMessageDialog(this, "Email already in use (" + email + ") "
					+ "maybe " + name + " is already registered");
		}
		cancelClicked();
	}

	private void cancelClicked() {
		this.dispose();
		this.setVisible(false);
	}
	
}
