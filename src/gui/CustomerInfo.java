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
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.awt.Component;
import javax.swing.Box;

public class CustomerInfo extends JDialog {
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
	private JList<Order> oList;
	private EmployeeController ec;
	private ProductController pc;
	private OrderController oc;
	private Employee em;
	private JLabel labPostalcode;
	private JLabel labCountry;
	private JLabel labName;
	private Border borderB;
	private JFormattedTextField txtDiscount;
	private JPanel panel;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_7;
	private JSeparator separator_8;
	private JLabel labEmail;
	private JLabel labAddress;
	private JLabel lblNewLabel;
	private JLabel labCity;
	private JLabel lblNewLabel_1;
	private JLabel labDiscount;
	private JLabel labPhone;
	private JLabel labCVR;
	private JLabel name_1;
	private Component verticalStrut;
	private Component verticalStrut_1;


	/**
	 * Create the dialog.
	 */

	public CustomerInfo(Customer c,Employee em, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc, CustomerMenu cMenu) {
		setBounds(150, 150, 401, 540);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 74, 262, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 33, 20, 0, 0, 0, 20, 0, 20, 0, 33, 0, 20, 0, 30, 0, 21, 33, 0, 14, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
					
								txtEmail = new JTextField();
								txtEmail.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										txtEmail.setBorder(borderB);
										labEmail.setText("");
									}
								});
														
														separator_7 = new JSeparator();
														GridBagConstraints gbc_separator_7 = new GridBagConstraints();
														gbc_separator_7.insets = new Insets(0, 0, 5, 5);
														gbc_separator_7.gridx = 2;
														gbc_separator_7.gridy = 0;
														getContentPane().add(separator_7, gbc_separator_7);
														
														JLabel lblNewLabel_2 = new JLabel("Customer Info:");
														lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
														GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
														gbc_lblNewLabel_2.gridwidth = 2;
														gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
														gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTH;
														gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
														gbc_lblNewLabel_2.gridx = 1;
														gbc_lblNewLabel_2.gridy = 1;
														getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
											
														name_1 = new JLabel("Navn");
														GridBagConstraints gbc_name_1 = new GridBagConstraints();
														gbc_name_1.anchor = GridBagConstraints.EAST;
														gbc_name_1.insets = new Insets(0, 0, 5, 5);
														gbc_name_1.gridx = 1;
														gbc_name_1.gridy = 2;
														getContentPane().add(name_1, gbc_name_1);
											
														txtName = new JTextField();
														Border borderDefault = txtName.getBorder();
														txtName.addMouseListener(new MouseAdapter() {
															@Override
															public void mouseClicked(MouseEvent e) {
																txtName.setBorder(borderB);
																labName.setText("");
															}
														});
														GridBagConstraints gbc_txtName = new GridBagConstraints();
														gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
														gbc_txtName.insets = new Insets(0, 0, 5, 5);
														gbc_txtName.gridx = 2;
														gbc_txtName.gridy = 2;
														getContentPane().add(txtName, gbc_txtName);
														txtName.setColumns(10);
											
											labName = new JLabel("");
											labName.setForeground(new Color(255, 0, 0));
											GridBagConstraints gbc_labName = new GridBagConstraints();
											gbc_labName.anchor = GridBagConstraints.SOUTH;
											gbc_labName.fill = GridBagConstraints.HORIZONTAL;
											gbc_labName.insets = new Insets(0, 0, 5, 5);
											gbc_labName.gridx = 2;
											gbc_labName.gridy = 2;
											getContentPane().add(labName, gbc_labName);
								
											labCVR = new JLabel("CVR");
											labCVR.setHorizontalAlignment(SwingConstants.LEFT);
											GridBagConstraints gbc_labCVR = new GridBagConstraints();
											gbc_labCVR.anchor = GridBagConstraints.EAST;
											gbc_labCVR.insets = new Insets(0, 0, 5, 5);
											gbc_labCVR.gridx = 1;
											gbc_labCVR.gridy = 3;
											getContentPane().add(labCVR, gbc_labCVR);
								
											txtCVR = new JTextField();
											txtCVR.addMouseListener(new MouseAdapter() {
												@Override
												public void mouseClicked(MouseEvent e) {
													txtCVR.setBorder(borderB);
													labCVR.setText("");
												}
											});
											txtCVR.setForeground(new Color(0, 0, 0));
											txtCVR.setBackground(new Color(255, 255, 255));
											GridBagConstraints gbc_txtCVR = new GridBagConstraints();
											gbc_txtCVR.fill = GridBagConstraints.HORIZONTAL;
											gbc_txtCVR.insets = new Insets(0, 0, 5, 5);
											gbc_txtCVR.gridx = 2;
											gbc_txtCVR.gridy = 3;
											getContentPane().add(txtCVR, gbc_txtCVR);
											txtCVR.setColumns(10);
																										
																													txtPhone = new JTextField();
																													txtPhone.addMouseListener(new MouseAdapter() {
																														@Override
																														public void mouseClicked(MouseEvent e) {
																															txtPhone.setBorder(borderB);
																															labPhone.setText("");
																														}
																													});
																																
																																separator_6 = new JSeparator();
																																GridBagConstraints gbc_separator_6 = new GridBagConstraints();
																																gbc_separator_6.insets = new Insets(0, 0, 5, 5);
																																gbc_separator_6.gridx = 2;
																																gbc_separator_6.gridy = 4;
																																getContentPane().add(separator_6, gbc_separator_6);
																													
																																labPhone = new JLabel("Tlf nr.");
																																GridBagConstraints gbc_labPhone = new GridBagConstraints();
																																gbc_labPhone.anchor = GridBagConstraints.EAST;
																																gbc_labPhone.insets = new Insets(0, 0, 5, 5);
																																gbc_labPhone.gridx = 1;
																																gbc_labPhone.gridy = 5;
																																getContentPane().add(labPhone, gbc_labPhone);
																													GridBagConstraints gbc_txtPhone = new GridBagConstraints();
																													gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
																													gbc_txtPhone.insets = new Insets(0, 0, 5, 5);
																													gbc_txtPhone.gridx = 2;
																													gbc_txtPhone.gridy = 5;
																													getContentPane().add(txtPhone, gbc_txtPhone);
																													txtPhone.setColumns(10);
											
											separator_5 = new JSeparator();
											GridBagConstraints gbc_separator_5 = new GridBagConstraints();
											gbc_separator_5.insets = new Insets(0, 0, 5, 5);
											gbc_separator_5.gridx = 2;
											gbc_separator_5.gridy = 6;
											getContentPane().add(separator_5, gbc_separator_5);
								
											labEmail = new JLabel("E-mail");
											GridBagConstraints gbc_labEmail = new GridBagConstraints();
											gbc_labEmail.anchor = GridBagConstraints.EAST;
											gbc_labEmail.insets = new Insets(0, 0, 5, 5);
											gbc_labEmail.gridx = 1;
											gbc_labEmail.gridy = 7;
											getContentPane().add(labEmail, gbc_labEmail);
								GridBagConstraints gbc_txtEmail = new GridBagConstraints();
								gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
								gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
								gbc_txtEmail.gridx = 2;
								gbc_txtEmail.gridy = 7;
								getContentPane().add(txtEmail, gbc_txtEmail);
								txtEmail.setColumns(10);
											
											separator_4 = new JSeparator();
											GridBagConstraints gbc_separator_4 = new GridBagConstraints();
											gbc_separator_4.insets = new Insets(0, 0, 5, 5);
											gbc_separator_4.gridx = 2;
											gbc_separator_4.gridy = 8;
											getContentPane().add(separator_4, gbc_separator_4);
								
											labAddress = new JLabel("Adresse");
											GridBagConstraints gbc_labAddress = new GridBagConstraints();
											gbc_labAddress.anchor = GridBagConstraints.EAST;
											gbc_labAddress.insets = new Insets(0, 0, 5, 5);
											gbc_labAddress.gridx = 1;
											gbc_labAddress.gridy = 9;
											getContentPane().add(labAddress, gbc_labAddress);
								
											txtPostalcode = new JTextField();
											txtPostalcode.addMouseListener(new MouseAdapter() {
												@Override
												public void mouseClicked(MouseEvent e) {
													txtPostalcode.setBorder(borderB);
													labPostalcode.setText("");
												}
											});
											
														txtAddress = new JTextField();
														txtAddress.addMouseListener(new MouseAdapter() {
															@Override
															public void mouseClicked(MouseEvent e) {
																txtAddress.setBorder(borderB);
																labAddress.setText("");
															}
														});
														GridBagConstraints gbc_txtAddress = new GridBagConstraints();
														gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
														gbc_txtAddress.insets = new Insets(0, 0, 5, 5);
														gbc_txtAddress.gridx = 2;
														gbc_txtAddress.gridy = 9;
														getContentPane().add(txtAddress, gbc_txtAddress);
														txtAddress.setColumns(10);
														
														separator_3 = new JSeparator();
														GridBagConstraints gbc_separator_3 = new GridBagConstraints();
														gbc_separator_3.insets = new Insets(0, 0, 5, 5);
														gbc_separator_3.gridx = 2;
														gbc_separator_3.gridy = 10;
														getContentPane().add(separator_3, gbc_separator_3);
											
														lblNewLabel = new JLabel("Postnummer");
														GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
														gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
														gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
														gbc_lblNewLabel.gridx = 1;
														gbc_lblNewLabel.gridy = 11;
														getContentPane().add(lblNewLabel, gbc_lblNewLabel);
											
											labPostalcode = new JLabel("");
											labPostalcode.setForeground(new Color(255, 0, 0));
											GridBagConstraints gbc_labPostalcode = new GridBagConstraints();
											gbc_labPostalcode.anchor = GridBagConstraints.SOUTH;
											gbc_labPostalcode.fill = GridBagConstraints.HORIZONTAL;
											gbc_labPostalcode.insets = new Insets(0, 0, 5, 5);
											gbc_labPostalcode.gridx = 2;
											gbc_labPostalcode.gridy = 11;
											getContentPane().add(labPostalcode, gbc_labPostalcode);
											GridBagConstraints gbc_txtPostalcode = new GridBagConstraints();
											gbc_txtPostalcode.fill = GridBagConstraints.HORIZONTAL;
											gbc_txtPostalcode.insets = new Insets(0, 0, 5, 5);
											gbc_txtPostalcode.gridx = 2;
											gbc_txtPostalcode.gridy = 11;
											getContentPane().add(txtPostalcode, gbc_txtPostalcode);
											txtPostalcode.setColumns(10);
														
														separator_2 = new JSeparator();
														GridBagConstraints gbc_separator_2 = new GridBagConstraints();
														gbc_separator_2.insets = new Insets(0, 0, 5, 5);
														gbc_separator_2.gridx = 2;
														gbc_separator_2.gridy = 12;
														getContentPane().add(separator_2, gbc_separator_2);
											
														labCity = new JLabel("By");
														GridBagConstraints gbc_labCity = new GridBagConstraints();
														gbc_labCity.anchor = GridBagConstraints.EAST;
														gbc_labCity.insets = new Insets(0, 0, 5, 5);
														gbc_labCity.gridx = 1;
														gbc_labCity.gridy = 13;
														getContentPane().add(labCity, gbc_labCity);
											
														txtCity = new JTextField();
														txtCity.addMouseListener(new MouseAdapter() {
															@Override
															public void mouseClicked(MouseEvent e) {
																txtCity.setBorder(borderB);
																labCity.setText("");
															}
														});
														GridBagConstraints gbc_txtCity = new GridBagConstraints();
														gbc_txtCity.fill = GridBagConstraints.HORIZONTAL;
														gbc_txtCity.insets = new Insets(0, 0, 5, 5);
														gbc_txtCity.gridx = 2;
														gbc_txtCity.gridy = 13;
														getContentPane().add(txtCity, gbc_txtCity);
														txtCity.setColumns(10);
											
											separator_1 = new JSeparator();
											GridBagConstraints gbc_separator_1 = new GridBagConstraints();
											gbc_separator_1.insets = new Insets(0, 0, 5, 5);
											gbc_separator_1.gridx = 2;
											gbc_separator_1.gridy = 14;
											getContentPane().add(separator_1, gbc_separator_1);
								
											lblNewLabel_1 = new JLabel("Land");
											GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
											gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
											gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
											gbc_lblNewLabel_1.gridx = 1;
											gbc_lblNewLabel_1.gridy = 15;
											getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
								
											txtCountry = new JTextField();
											txtCountry.addMouseListener(new MouseAdapter() {
												@Override
												public void mouseClicked(MouseEvent e) {
													txtCountry.setBorder(borderB);
													labCountry.setText("");
												}
											});
											GridBagConstraints gbc_txtCountry = new GridBagConstraints();
											gbc_txtCountry.fill = GridBagConstraints.HORIZONTAL;
											gbc_txtCountry.insets = new Insets(0, 0, 5, 5);
											gbc_txtCountry.gridx = 2;
											gbc_txtCountry.gridy = 15;
											getContentPane().add(txtCountry, gbc_txtCountry);
											txtCountry.setColumns(10);
								
								labCountry = new JLabel("");
								labCountry.setForeground(Color.RED);
								GridBagConstraints gbc_labCountry = new GridBagConstraints();
								gbc_labCountry.anchor = GridBagConstraints.SOUTH;
								gbc_labCountry.fill = GridBagConstraints.HORIZONTAL;
								gbc_labCountry.insets = new Insets(0, 0, 5, 5);
								gbc_labCountry.gridx = 2;
								gbc_labCountry.gridy = 15;
								getContentPane().add(labCountry, gbc_labCountry);
								
								separator = new JSeparator();
								GridBagConstraints gbc_separator = new GridBagConstraints();
								gbc_separator.insets = new Insets(0, 0, 5, 5);
								gbc_separator.gridx = 2;
								gbc_separator.gridy = 16;
								getContentPane().add(separator, gbc_separator);
								
								verticalStrut_1 = Box.createVerticalStrut(20);
								GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
								gbc_verticalStrut_1.gridheight = 20;
								gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
								gbc_verticalStrut_1.gridx = 0;
								gbc_verticalStrut_1.gridy = 1;
								getContentPane().add(verticalStrut_1, gbc_verticalStrut_1);
					
								labDiscount = new JLabel("Rabat");
								GridBagConstraints gbc_labDiscount = new GridBagConstraints();
								gbc_labDiscount.anchor = GridBagConstraints.EAST;
								gbc_labDiscount.insets = new Insets(0, 0, 5, 5);
								gbc_labDiscount.gridx = 1;
								gbc_labDiscount.gridy = 17;
								getContentPane().add(labDiscount, gbc_labDiscount);
					
					txtDiscount = new JFormattedTextField();
					GridBagConstraints gbc_txtDiscount = new GridBagConstraints();
					gbc_txtDiscount.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtDiscount.insets = new Insets(0, 0, 5, 5);
					gbc_txtDiscount.gridx = 2;
					gbc_txtDiscount.gridy = 17;
					getContentPane().add(txtDiscount, gbc_txtDiscount);
					
					verticalStrut = Box.createVerticalStrut(20);
					GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
					gbc_verticalStrut.gridheight = 18;
					gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
					gbc_verticalStrut.gridx = 3;
					gbc_verticalStrut.gridy = 2;
					getContentPane().add(verticalStrut, gbc_verticalStrut);
					{
						JPanel buttonPanel = new JPanel();
						GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
						gbc_buttonPanel.anchor = GridBagConstraints.NORTHEAST;
						gbc_buttonPanel.insets = new Insets(0, 0, 5, 5);
						gbc_buttonPanel.gridx = 2;
						gbc_buttonPanel.gridy = 18;
						getContentPane().add(buttonPanel, gbc_buttonPanel);
						{
							btnOK = new JButton("OK");
							btnOK.setToolTipText("Save and close");
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
																																
																																separator_8 = new JSeparator();
																																GridBagConstraints gbc_separator_8 = new GridBagConstraints();
																																gbc_separator_8.insets = new Insets(0, 0, 5, 5);
																																gbc_separator_8.gridx = 2;
																																gbc_separator_8.gridy = 19;
																																getContentPane().add(separator_8, gbc_separator_8);
																																
																																panel = new JPanel();
																																GridBagConstraints gbc_panel = new GridBagConstraints();
																																gbc_panel.gridwidth = 3;
																																gbc_panel.fill = GridBagConstraints.BOTH;
																																gbc_panel.gridx = 1;
																																gbc_panel.gridy = 20;
																																getContentPane().add(panel, gbc_panel);
																																GridBagLayout gbl_panel = new GridBagLayout();
																																gbl_panel.columnWidths = new int[]{0, 0};
																																gbl_panel.rowHeights = new int[]{0, 0, 0};
																																gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
																																gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
																																panel.setLayout(gbl_panel);
																																
																																			JLabel lblNewLabel_10 = new JLabel("Ordreliste:");
																																			GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
																																			gbc_lblNewLabel_10.anchor = GridBagConstraints.SOUTHWEST;
																																			gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 0);
																																			gbc_lblNewLabel_10.gridx = 0;
																																			gbc_lblNewLabel_10.gridy = 0;
																																			panel.add(lblNewLabel_10, gbc_lblNewLabel_10);
																																			lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
																																			
																																						JPanel panel_1 = new JPanel();
																																						GridBagConstraints gbc_panel_1 = new GridBagConstraints();
																																						gbc_panel_1.fill = GridBagConstraints.BOTH;
																																						gbc_panel_1.gridx = 0;
																																						gbc_panel_1.gridy = 1;
																																						panel.add(panel_1, gbc_panel_1);
																																									panel_1.setLayout(new BorderLayout(0, 0));
																																						
																																									JScrollPane scrollPane = new JScrollPane();
																																									panel_1.add(scrollPane);
																																									
																																												oList = new JList<Order>();
																																												oList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
																																												panel_1.add(oList);
			{
			}

			init(c,em,pc,oc,ec,cc, cMenu);
		}
			
	private void init(Customer c,Employee em, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc, CustomerMenu cMenu) {
		this.em = em;
		this.pc = pc;
		this.ec = ec;
		this.oc = oc;
		this.currCustomer = c;
		this.cCtrl = cc;
		this.cMenu = cMenu;

		OrderListCellRenderer ocr = new OrderListCellRenderer();
		oList.setCellRenderer(ocr);

		if(!em.isManager()) {
			txtDiscount.setEditable(false);
		}
		
		if(currCustomer != null) {
			displayCustomer();
			displayOrders(cCtrl.findCustomerByPhoneNo(currCustomer.getPhoneNo()));
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
		OrderListCellRenderer ocr = new OrderListCellRenderer();
		oList.setCellRenderer(ocr);
		ArrayList<Order> orders = currCustomer.getAllOrders();
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
		Border border = BorderFactory.createLineBorder(Color.RED, 1);
		
		if(txtName.getText().length() == 0) {
			labName.setText("Mangler input");
			txtName.setBorder(border);
			wrongInputTracker++;
		}
		
		if(txtCVR.getText().length() != 8){
			labCVR.setText( "Cvr nr. skal være 8 cifre");
			txtCVR.setBorder(border);
			wrongInputTracker++;
		}
		if(!isValid(txtEmail.getText())){
			labEmail.setText("Email skal indtastes i korrekt format");
			txtEmail.setBorder(border);
			wrongInputTracker++;
		}
		if(txtPhone.getText().length() != 8) {
			labPhone.setText("Telefon nr. skal være 8 cifre");
			txtPhone.setBorder(border);
			wrongInputTracker++;
		}
		if(txtPostalcode.getText().length() != 4) {
			labPostalcode.setText("Postnummer skal indeholde 4 cifre");
			txtPostalcode.setBorder(border);
			wrongInputTracker++;
		}
			
		if(txtAddress.getText().length() == 0) {
			labAddress.setText("Mangler input");
			txtAddress.setBorder(border);
			wrongInputTracker++;
		}
		
		if(txtCity.getText().length() == 0) {
			labCity.setText("Mangler input");
			txtCity.setBorder(border);
			wrongInputTracker++;
		}
		
		if(txtCity.getText().length() == 0) {
			labCity.setText("Mangler input");
			txtCity.setBorder(border);
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
		cMenu.displayCustomers();
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
