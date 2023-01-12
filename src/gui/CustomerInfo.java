package gui;
import model.Customer;
import model.Employee;
import model.Order;
import controller.CustomerController;

import controller.EmployeeController;
import controller.OrderController;
import controller.ProductController;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.ListSelectionModel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSeparator;

public class CustomerInfo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private CustomerMenu cMenu;
	private CustomerController cCtrl;
	private OrderController oCtrl;
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
	private JList<Order> oList;
	private EmployeeController ec;
	private ProductController pc;
	private OrderController oc;
	private Employee em;
	private JLabel labCVR;
	private JLabel labEmail;
	private JLabel labPhone;
	private JLabel labPostalcode;
	private JLabel labAddress;
	private JLabel labCity;
	private JLabel labCountry;
	private JLabel labDiscount;



	/**
	 * Create the dialog.
	 */

	public CustomerInfo(Customer c,Employee em, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc) {
		setBounds(150, 150, 375, 550);
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
			buttonPanel.setBounds(140, 335, 204, 33);
			getContentPane().add(buttonPanel);
			{
				btnOK = new JButton("OK");
				btnOK.setVerticalAlignment(SwingConstants.TOP);
				btnOK.setHorizontalAlignment(SwingConstants.RIGHT);
				btnOK.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okClicked();
					}
				});
				btnOK.setActionCommand("OK");
				getRootPane().setDefaultButton(btnOK);
			}
			btnSave = new JButton("Save");
			btnSave.setVerticalAlignment(SwingConstants.TOP);
			btnSave.setHorizontalAlignment(SwingConstants.RIGHT);
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					saveClicked();
				}
			});
			{
				btnCancel = new JButton("Cancel");
				btnCancel.setVerticalAlignment(SwingConstants.TOP);
				btnCancel.setHorizontalAlignment(SwingConstants.RIGHT);
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelClicked();
					}
				});
				btnCancel.setActionCommand("Cancel");
			}
			buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			buttonPanel.add(btnOK);
			buttonPanel.add(btnSave);
			buttonPanel.add(btnCancel);
		}
			
			JLabel lblNewLabel_2 = new JLabel("Customer Info:");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_2.setBounds(10, 10, 95, 15);
			getContentPane().add(lblNewLabel_2);

			txtName = new JTextField();
			txtName.setBounds(74, 30, 270, 20);
			getContentPane().add(txtName);
			txtName.setColumns(10);

			txtCVR = new JTextField();
			txtCVR.setForeground(new Color(0, 0, 0));
			txtCVR.setBackground(new Color(255, 255, 255));
			txtCVR.setBounds(74, 65, 270, 20);
			getContentPane().add(txtCVR);
			txtCVR.setColumns(10);

			txtPhone = new JTextField();
			txtPhone.setBounds(74, 100, 270, 20); 
			getContentPane().add(txtPhone);
			txtPhone.setColumns(10);

			txtEmail = new JTextField();
			txtEmail.setBounds(74, 135, 270, 20);
			getContentPane().add(txtEmail);
			txtEmail.setColumns(10);

			txtAddress = new JTextField();
			txtAddress.setBounds(74, 170, 270, 20);
			getContentPane().add(txtAddress);
			txtAddress.setColumns(10);

			JLabel name = new JLabel("Name.............");
			name.setBounds(10, 36, 64, 15);
			getContentPane().add(name);

			JLabel lblNewLabel_3 = new JLabel("Phone.........");
			lblNewLabel_3.setBounds(10, 106, 64, 15);
			getContentPane().add(lblNewLabel_3);

			JLabel lblNewLabel_4 = new JLabel("E-mail.........");
			lblNewLabel_4.setBounds(10, 141, 64, 15);
			getContentPane().add(lblNewLabel_4);

			JLabel lblNewLabel_5 = new JLabel("Address........");
			lblNewLabel_5.setBounds(10, 176, 64, 15);
			getContentPane().add(lblNewLabel_5);

			JLabel lblNewLabel_6 = new JLabel("CVR...........");
			lblNewLabel_6.setBounds(10, 71, 64, 15);
			getContentPane().add(lblNewLabel_6);

			JLabel lblNewLabel_7 = new JLabel("Postalcode...");
			lblNewLabel_7.setBounds(10, 211, 64, 15);
			getContentPane().add(lblNewLabel_7);

			JLabel lblNewLabel_8 = new JLabel("City................");
			lblNewLabel_8.setBounds(10, 246, 64, 15);
			getContentPane().add(lblNewLabel_8);

			txtPostalcode = new JTextField();
			txtPostalcode.setBounds(74, 205, 270, 20);
			getContentPane().add(txtPostalcode);
			txtPostalcode.setColumns(10);

			txtCity = new JTextField();
			txtCity.setBounds(74, 240, 270, 20);
			getContentPane().add(txtCity);
			txtCity.setColumns(10);

			txtCountry = new JTextField();
			txtCountry.setBounds(74, 275, 270, 20);
			getContentPane().add(txtCountry);
			txtCountry.setColumns(10);

			JLabel lblNewLabel_9 = new JLabel("Country.........");
			lblNewLabel_9.setBounds(10, 281, 64, 15);
			getContentPane().add(lblNewLabel_9);

			JPanel panel = new JPanel();
			panel.setBounds(10, 408, 334, 92);
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

			oList = new JList<Order>();
			oList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			GridBagConstraints gbc_list = new GridBagConstraints();
			gbc_list.insets = new Insets(0, 0, 0, 5);
			gbc_list.gridx = 0;
			gbc_list.gridy = 1;
			panel.add(oList, gbc_list);

			JLabel lblNewLabel_1 = new JLabel("Discount............");
			lblNewLabel_1.setBounds(10, 316, 64, 15);
			getContentPane().add(lblNewLabel_1);

			txtDiscount = new JTextField();
			txtDiscount.setBounds(74, 310, 270, 20);
			getContentPane().add(txtDiscount);
			txtDiscount.setColumns(10);

			JLabel lblNewLabel_10 = new JLabel("Orderlist:");
			lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblNewLabel_10.setBounds(10, 394, 64, 14);
			getContentPane().add(lblNewLabel_10);
			
			JSeparator separator = new JSeparator();
			separator.setBounds(10, 385, 334, 2);
			getContentPane().add(separator);
			
			labCVR = new JLabel("");
			labCVR.setForeground(new Color(255, 0, 0));
			labCVR.setBounds(74, 85, 270, 14);
			getContentPane().add(labCVR);
			
			labPhone = new JLabel("");
			labPhone.setForeground(new Color(255, 0, 0));
			labPhone.setBounds(74, 120, 270, 14);
			getContentPane().add(labPhone);
			
			labPostalcode = new JLabel("");
			labPostalcode.setForeground(new Color(255, 0, 0));
			labPostalcode.setBounds(74, 224, 270, 14);
			getContentPane().add(labPostalcode);
			
			labEmail = new JLabel("");
			labEmail.setForeground(new Color(255, 0, 0));
			labEmail.setBounds(74, 155, 270, 14);
			getContentPane().add(labEmail);
			
			JLabel labName = new JLabel("");
			labName.setForeground(new Color(255, 0, 0));
			labName.setBounds(74, 49, 270, 14);
			getContentPane().add(labName);
			
			labAddress = new JLabel("");
			labAddress.setForeground(Color.RED);
			labAddress.setBounds(74, 190, 270, 14);
			getContentPane().add(labAddress);
			
			labCity = new JLabel("");
			labCity.setForeground(Color.RED);
			labCity.setBounds(74, 260, 270, 14);
			getContentPane().add(labCity);
			
			labCountry = new JLabel("");
			labCountry.setForeground(Color.RED);
			labCountry.setBounds(74, 291, 270, 14);
			getContentPane().add(labCountry);
			
			labDiscount = new JLabel("");
			labDiscount.setForeground(Color.RED);
			labDiscount.setBounds(10, 369, 270, 14);
			getContentPane().add(labDiscount);
			{
			}

			init(c,em,pc,oc,ec,cc);
		}
			
	private void init(Customer c,Employee em, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc) {
		this.em = em;
		this.pc = pc;
		this.ec = ec;
		this.oc = oc;
		this.currCustomer = c;
		this.cCtrl = cc;

		OrderListCellRenderer ocr = new OrderListCellRenderer();
		oList.setCellRenderer(ocr);

		if(currCustomer != null) {
			displayCustomer();
			displayOrders(c);

		if(!em.isManager()) {
			txtDiscount.setEditable(false);
		}

		}
	}

	private void displayCustomer() {
		this.txtName.setText(currCustomer.getName());
		this.txtCVR.setText(currCustomer.getCvr());
		this.txtEmail.setText(currCustomer.getMailAddress());
		this.txtPhone.setText(currCustomer.getPhoneNo());
		this.txtAddress.setText(currCustomer.getAddress());
		this.txtPostalcode.setText(currCustomer.getPostalCode());
		this.txtCity.setText(currCustomer.getCity());
		this.txtCountry.setText(currCustomer.getCountry());
		this.txtDiscount.setText(""+currCustomer.getDiscount());
	}

	private void displayOrders(Customer currCustomer) {
		oCtrl = new OrderController();
		int i = 0;
		boolean found = false;
		ArrayList<Order> orders = new ArrayList<>();
		while(!found && i<oCtrl.getOrders().size()){
			if(oCtrl.getOrders().get(i).getCustomer().getId()==currCustomer.getId()) {
				orders.add(oCtrl.getOrders().get(i));
				i++;
			}
			else {
				i++;
			}
		}
		DefaultListModel<Order> dlm = new DefaultListModel<>();
		dlm.addAll(orders);
		oList.setModel(dlm);
	}

	private void okClicked() {
		saveClicked();
		cancelClicked();
		
	}

	private void saveClicked() {
		int wrongInputTracker = 0;
		
		if(txtCVR.getText().length() != 8){
			labCVR.setText( "Cvr nr. skal være 8 cifre");
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			txtCVR.setBorder(border);
			wrongInputTracker++;
		}
		if(!isValid(txtEmail.getText())){
			labEmail.setText("Email skal indtastes i korrekt format");
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			txtEmail.setBorder(border);
			wrongInputTracker++;
		}
		if(txtPhone.getText().length() != 8) {
			labPhone.setText("Telefon nr. skal være 8 cifre");
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			txtPhone.setBorder(border);
			wrongInputTracker++;
		}
		if(txtPostalcode.getText().length() != 4) {
			labPostalcode.setText("Postnummer skal indeholde 4 cifre");
			Border border = BorderFactory.createLineBorder(Color.RED, 1);
			txtPostalcode.setBorder(border);
			wrongInputTracker++;
		}
		if(wrongInputTracker == 0) {
			String name = txtName.getText();
			String cvr = txtCVR.getText();
			String email = txtEmail.getText();
			String phone = txtPhone.getText();
			String address = txtAddress.getText();
			String postalcode = txtPostalcode.getText();
			String city = txtCity.getText();
			String country = txtCountry.getText();
			double discount = Double.parseDouble(txtDiscount.getText());
			
			if(currCustomer == null) {
				currCustomer = cCtrl.addNewCustomer(name, phone, email, country, postalcode,
						city, address, cvr, discount);
			} 
			else {
				cCtrl.updateCustomer(currCustomer.getId(), name, phone, email, country, postalcode,
				city, address, cvr, discount); 
			}
		}
			
		else {
			throw new IllegalArgumentException("Error: Wrong input");
		}
	}
	
	private void cancelClicked() {
		this.dispose();
		this.setVisible(false);
	}
	
	public static boolean isValid(String email){
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                            "[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                            "A-Z]{2,7}$";
                              
        Pattern pat = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        else
        	return pat.matcher(email).matches();
    }
}
