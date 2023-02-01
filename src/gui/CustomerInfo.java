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
	private JSeparator separator_7;
	private JSeparator separator_8;
	private JLabel lab4;
	private JLabel lab5;
	private JLabel lab6;
	private JLabel lab7;
	private JLabel lab8;
	private JLabel lab9;
	private JLabel lab3;
	private JLabel lab2;
	private JLabel lab1;
	private JLabel labCVR;
	private JLabel labPhone;
	private JLabel labEmail;
	private JLabel labAddress;
	private JLabel labCity;
	private JTextField txtName;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JSeparator separator_4;
	private JSeparator separator_5;
	private JSeparator separator_6;
	private JSeparator separator_9;
	private JSeparator separator_10;
	private Component verticalStrut_1;
	private Component verticalStrut_2;
	private Component verticalStrut_3;
	private JSeparator separator_11;
	private JSeparator separator_12;


	/**
	 * Create the dialog.
	 */

	public CustomerInfo(Customer c,Employee em, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc, CustomerMenu cMenu) {
		setBounds(150, 150, 401, 575);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 74, 0, 262, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 20, 0, 0, 20, 0, 0, 0, 0, 0, 20, 0, 0, 0, 0, 0, 21, 0, 33, 0, 0, 0, 14, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
					

														
														separator_7 = new JSeparator();
														GridBagConstraints gbc_separator_7 = new GridBagConstraints();
														gbc_separator_7.insets = new Insets(0, 0, 5, 5);
														gbc_separator_7.gridx = 3;
														gbc_separator_7.gridy = 0;
														getContentPane().add(separator_7, gbc_separator_7);
														
														verticalStrut_2 = Box.createVerticalStrut(20);
														GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
														gbc_verticalStrut_2.gridheight = 33;
														gbc_verticalStrut_2.insets = new Insets(0, 0, 0, 5);
														gbc_verticalStrut_2.gridx = 0;
														gbc_verticalStrut_2.gridy = 0;
														getContentPane().add(verticalStrut_2, gbc_verticalStrut_2);
														
														JLabel lblNewLabel_2 = new JLabel("Kundeinformation:");
														lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
														GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
														gbc_lblNewLabel_2.gridwidth = 3;
														gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
														gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTH;
														gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
														gbc_lblNewLabel_2.gridx = 1;
														gbc_lblNewLabel_2.gridy = 1;
														getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
																	
																	verticalStrut_1 = Box.createVerticalStrut(20);
																	GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
																	gbc_verticalStrut_1.gridheight = 33;
																	gbc_verticalStrut_1.gridx = 4;
																	gbc_verticalStrut_1.gridy = 0;
																	getContentPane().add(verticalStrut_1, gbc_verticalStrut_1);
														
																	lab1 = new JLabel("Navn");
																	GridBagConstraints gbc_lab1 = new GridBagConstraints();
																	gbc_lab1.anchor = GridBagConstraints.EAST;
																	gbc_lab1.insets = new Insets(0, 0, 5, 5);
																	gbc_lab1.gridx = 1;
																	gbc_lab1.gridy = 2;
																	getContentPane().add(lab1, gbc_lab1);
														
														txtName = new JTextField();
														borderB = txtName.getBorder();
														txtName.addMouseListener(new MouseAdapter() {
															@Override
															public void mouseClicked(MouseEvent e) {
																txtName.setBorder(borderB);
																labName.setText("");
															}
														});
														txtName.setColumns(10);
														GridBagConstraints gbc_txtName = new GridBagConstraints();
														gbc_txtName.insets = new Insets(0, 0, 5, 5);
														gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
														gbc_txtName.gridx = 3;
														gbc_txtName.gridy = 2;
														getContentPane().add(txtName, gbc_txtName);
											
											labName = new JLabel("");
											labName.setForeground(new Color(255, 0, 0));
											GridBagConstraints gbc_labName = new GridBagConstraints();
											gbc_labName.anchor = GridBagConstraints.SOUTHWEST;
											gbc_labName.insets = new Insets(0, 0, 5, 5);
											gbc_labName.gridx = 3;
											gbc_labName.gridy = 3;
											getContentPane().add(labName, gbc_labName);
											
											separator = new JSeparator();
											GridBagConstraints gbc_separator = new GridBagConstraints();
											gbc_separator.insets = new Insets(0, 0, 5, 5);
											gbc_separator.gridx = 3;
											gbc_separator.gridy = 4;
											getContentPane().add(separator, gbc_separator);
								
											lab2 = new JLabel("CVR nr.");
											lab2.setHorizontalAlignment(SwingConstants.LEFT);
											GridBagConstraints gbc_lab2 = new GridBagConstraints();
											gbc_lab2.anchor = GridBagConstraints.EAST;
											gbc_lab2.insets = new Insets(0, 0, 5, 5);
											gbc_lab2.gridx = 1;
											gbc_lab2.gridy = 5;
											getContentPane().add(lab2, gbc_lab2);
								
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
											gbc_txtCVR.gridx = 3;
											gbc_txtCVR.gridy = 5;
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
																																
																													txtEmail = new JTextField();
																													txtEmail.addMouseListener(new MouseAdapter() {
																														@Override
																														public void mouseClicked(MouseEvent e) {
																															txtEmail.setBorder(borderB);
																															labEmail.setText("");
																														}
																													});
																													
																																labCVR = new JLabel("");
																																labCVR.setForeground(new Color(255, 0, 0));
																																GridBagConstraints gbc_labCVR = new GridBagConstraints();
																																gbc_labCVR.anchor = GridBagConstraints.WEST;
																																gbc_labCVR.insets = new Insets(0, 0, 5, 5);
																																gbc_labCVR.gridx = 3;
																																gbc_labCVR.gridy = 6;
																																getContentPane().add(labCVR, gbc_labCVR);
																																
																																separator_1 = new JSeparator();
																																GridBagConstraints gbc_separator_1 = new GridBagConstraints();
																																gbc_separator_1.insets = new Insets(0, 0, 5, 5);
																																gbc_separator_1.gridx = 3;
																																gbc_separator_1.gridy = 7;
																																getContentPane().add(separator_1, gbc_separator_1);
																													
																																lab3 = new JLabel("Tlf nr.");
																																GridBagConstraints gbc_lab3 = new GridBagConstraints();
																																gbc_lab3.anchor = GridBagConstraints.EAST;
																																gbc_lab3.insets = new Insets(0, 0, 5, 5);
																																gbc_lab3.gridx = 1;
																																gbc_lab3.gridy = 8;
																																getContentPane().add(lab3, gbc_lab3);
																													GridBagConstraints gbc_txtPhone = new GridBagConstraints();
																													gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
																													gbc_txtPhone.insets = new Insets(0, 0, 5, 5);
																													gbc_txtPhone.gridx = 3;
																													gbc_txtPhone.gridy = 8;
																													getContentPane().add(txtPhone, gbc_txtPhone);
																													txtPhone.setColumns(10);
											
											labPhone = new JLabel("");
											labPhone.setForeground(new Color(255, 0, 0));
											GridBagConstraints gbc_labPhone = new GridBagConstraints();
											gbc_labPhone.anchor = GridBagConstraints.WEST;
											gbc_labPhone.insets = new Insets(0, 0, 5, 5);
											gbc_labPhone.gridx = 3;
											gbc_labPhone.gridy = 9;
											getContentPane().add(labPhone, gbc_labPhone);
											
											separator_2 = new JSeparator();
											GridBagConstraints gbc_separator_2 = new GridBagConstraints();
											gbc_separator_2.insets = new Insets(0, 0, 5, 5);
											gbc_separator_2.gridx = 3;
											gbc_separator_2.gridy = 10;
											getContentPane().add(separator_2, gbc_separator_2);
								
											lab4 = new JLabel("E-mail");
											GridBagConstraints gbc_lab4 = new GridBagConstraints();
											gbc_lab4.anchor = GridBagConstraints.EAST;
											gbc_lab4.insets = new Insets(0, 0, 5, 5);
											gbc_lab4.gridx = 1;
											gbc_lab4.gridy = 11;
											getContentPane().add(lab4, gbc_lab4);
											
											GridBagConstraints gbc_txtEmail = new GridBagConstraints();
											gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
											gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
											gbc_txtEmail.gridx = 3;
											gbc_txtEmail.gridy = 11;
											getContentPane().add(txtEmail, gbc_txtEmail);
											txtEmail.setColumns(10);
											
											labEmail = new JLabel("");
											labEmail.setForeground(new Color(255, 0, 0));
											GridBagConstraints gbc_labEmail = new GridBagConstraints();
											gbc_labEmail.anchor = GridBagConstraints.WEST;
											gbc_labEmail.insets = new Insets(0, 0, 5, 5);
											gbc_labEmail.gridx = 3;
											gbc_labEmail.gridy = 12;
											getContentPane().add(labEmail, gbc_labEmail);
											
											separator_3 = new JSeparator();
											GridBagConstraints gbc_separator_3 = new GridBagConstraints();
											gbc_separator_3.insets = new Insets(0, 0, 5, 5);
											gbc_separator_3.gridx = 3;
											gbc_separator_3.gridy = 13;
											getContentPane().add(separator_3, gbc_separator_3);
								
											lab5 = new JLabel("Adresse");
											GridBagConstraints gbc_lab5 = new GridBagConstraints();
											gbc_lab5.anchor = GridBagConstraints.EAST;
											gbc_lab5.insets = new Insets(0, 0, 5, 5);
											gbc_lab5.gridx = 1;
											gbc_lab5.gridy = 14;
											getContentPane().add(lab5, gbc_lab5);
											
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
														gbc_txtAddress.gridx = 3;
														gbc_txtAddress.gridy = 14;
														getContentPane().add(txtAddress, gbc_txtAddress);
														txtAddress.setColumns(10);
														
														labAddress = new JLabel("");
														labAddress.setForeground(Color.RED);
														GridBagConstraints gbc_labAddress = new GridBagConstraints();
														gbc_labAddress.anchor = GridBagConstraints.WEST;
														gbc_labAddress.insets = new Insets(0, 0, 5, 5);
														gbc_labAddress.gridx = 3;
														gbc_labAddress.gridy = 15;
														getContentPane().add(labAddress, gbc_labAddress);
														
																	txtPostalcode = new JTextField();
																	txtPostalcode.addMouseListener(new MouseAdapter() {
																		@Override
																		public void mouseClicked(MouseEvent e) {
																			txtPostalcode.setBorder(borderB);
																			labPostalcode.setText("");
																		}
																	});
																				
																				separator_4 = new JSeparator();
																				GridBagConstraints gbc_separator_4 = new GridBagConstraints();
																				gbc_separator_4.insets = new Insets(0, 0, 5, 5);
																				gbc_separator_4.gridx = 3;
																				gbc_separator_4.gridy = 16;
																				getContentPane().add(separator_4, gbc_separator_4);
																	
																				lab6 = new JLabel("Postnummer");
																				GridBagConstraints gbc_lab6 = new GridBagConstraints();
																				gbc_lab6.anchor = GridBagConstraints.EAST;
																				gbc_lab6.insets = new Insets(0, 0, 5, 5);
																				gbc_lab6.gridx = 1;
																				gbc_lab6.gridy = 17;
																				getContentPane().add(lab6, gbc_lab6);
																	GridBagConstraints gbc_txtPostalcode = new GridBagConstraints();
																	gbc_txtPostalcode.fill = GridBagConstraints.HORIZONTAL;
																	gbc_txtPostalcode.insets = new Insets(0, 0, 5, 5);
																	gbc_txtPostalcode.gridx = 3;
																	gbc_txtPostalcode.gridy = 17;
																	getContentPane().add(txtPostalcode, gbc_txtPostalcode);
																	txtPostalcode.setColumns(10);
														
														labPostalcode = new JLabel("");
														labPostalcode.setForeground(new Color(255, 0, 0));
														GridBagConstraints gbc_labPostalcode = new GridBagConstraints();
														gbc_labPostalcode.anchor = GridBagConstraints.SOUTHWEST;
														gbc_labPostalcode.insets = new Insets(0, 0, 5, 5);
														gbc_labPostalcode.gridx = 3;
														gbc_labPostalcode.gridy = 18;
														getContentPane().add(labPostalcode, gbc_labPostalcode);
														
														separator_5 = new JSeparator();
														GridBagConstraints gbc_separator_5 = new GridBagConstraints();
														gbc_separator_5.insets = new Insets(0, 0, 5, 5);
														gbc_separator_5.gridx = 3;
														gbc_separator_5.gridy = 19;
														getContentPane().add(separator_5, gbc_separator_5);
											
														lab7 = new JLabel("By");
														GridBagConstraints gbc_lab7 = new GridBagConstraints();
														gbc_lab7.anchor = GridBagConstraints.EAST;
														gbc_lab7.insets = new Insets(0, 0, 5, 5);
														gbc_lab7.gridx = 1;
														gbc_lab7.gridy = 20;
														getContentPane().add(lab7, gbc_lab7);
											
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
														gbc_txtCity.gridx = 3;
														gbc_txtCity.gridy = 20;
														getContentPane().add(txtCity, gbc_txtCity);
														txtCity.setColumns(10);
											
											labCity = new JLabel("");
											labCity.setForeground(Color.RED);
											GridBagConstraints gbc_labCity = new GridBagConstraints();
											gbc_labCity.anchor = GridBagConstraints.WEST;
											gbc_labCity.insets = new Insets(0, 0, 5, 5);
											gbc_labCity.gridx = 3;
											gbc_labCity.gridy = 21;
											getContentPane().add(labCity, gbc_labCity);
											
														txtCountry = new JTextField();
														txtCountry.addMouseListener(new MouseAdapter() {
															@Override
															public void mouseClicked(MouseEvent e) {
																txtCountry.setBorder(borderB);
																labCountry.setText("");
															}
														});
																	
																	separator_6 = new JSeparator();
																	GridBagConstraints gbc_separator_6 = new GridBagConstraints();
																	gbc_separator_6.insets = new Insets(0, 0, 5, 5);
																	gbc_separator_6.gridx = 3;
																	gbc_separator_6.gridy = 22;
																	getContentPane().add(separator_6, gbc_separator_6);
														
																	lab8 = new JLabel("Land");
																	GridBagConstraints gbc_lab8 = new GridBagConstraints();
																	gbc_lab8.anchor = GridBagConstraints.EAST;
																	gbc_lab8.insets = new Insets(0, 0, 5, 5);
																	gbc_lab8.gridx = 1;
																	gbc_lab8.gridy = 23;
																	getContentPane().add(lab8, gbc_lab8);
														GridBagConstraints gbc_txtCountry = new GridBagConstraints();
														gbc_txtCountry.fill = GridBagConstraints.HORIZONTAL;
														gbc_txtCountry.insets = new Insets(0, 0, 5, 5);
														gbc_txtCountry.gridx = 3;
														gbc_txtCountry.gridy = 23;
														getContentPane().add(txtCountry, gbc_txtCountry);
														txtCountry.setColumns(10);
								
								labCountry = new JLabel("");
								labCountry.setForeground(Color.RED);
								GridBagConstraints gbc_labCountry = new GridBagConstraints();
								gbc_labCountry.anchor = GridBagConstraints.SOUTHWEST;
								gbc_labCountry.insets = new Insets(0, 0, 5, 5);
								gbc_labCountry.gridx = 3;
								gbc_labCountry.gridy = 24;
								getContentPane().add(labCountry, gbc_labCountry);
								
								separator_9 = new JSeparator();
								GridBagConstraints gbc_separator_9 = new GridBagConstraints();
								gbc_separator_9.insets = new Insets(0, 0, 5, 5);
								gbc_separator_9.gridx = 3;
								gbc_separator_9.gridy = 25;
								getContentPane().add(separator_9, gbc_separator_9);
					
								lab9 = new JLabel("Rabat");
								GridBagConstraints gbc_lab9 = new GridBagConstraints();
								gbc_lab9.anchor = GridBagConstraints.EAST;
								gbc_lab9.insets = new Insets(0, 0, 5, 5);
								gbc_lab9.gridx = 1;
								gbc_lab9.gridy = 26;
								getContentPane().add(lab9, gbc_lab9);
					
					verticalStrut_3 = Box.createVerticalStrut(20);
					GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
					gbc_verticalStrut_3.gridheight = 25;
					gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
					gbc_verticalStrut_3.gridx = 2;
					gbc_verticalStrut_3.gridy = 2;
					getContentPane().add(verticalStrut_3, gbc_verticalStrut_3);
					
					txtDiscount = new JFormattedTextField();
					GridBagConstraints gbc_txtDiscount = new GridBagConstraints();
					gbc_txtDiscount.fill = GridBagConstraints.HORIZONTAL;
					gbc_txtDiscount.insets = new Insets(0, 0, 5, 5);
					gbc_txtDiscount.gridx = 3;
					gbc_txtDiscount.gridy = 26;
					getContentPane().add(txtDiscount, gbc_txtDiscount);
					
					separator_10 = new JSeparator();
					GridBagConstraints gbc_separator_10 = new GridBagConstraints();
					gbc_separator_10.insets = new Insets(0, 0, 5, 5);
					gbc_separator_10.gridx = 3;
					gbc_separator_10.gridy = 27;
					getContentPane().add(separator_10, gbc_separator_10);
					{
						JPanel buttonPanel = new JPanel();
						GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
						gbc_buttonPanel.anchor = GridBagConstraints.NORTHEAST;
						gbc_buttonPanel.insets = new Insets(0, 0, 5, 5);
						gbc_buttonPanel.gridx = 3;
						gbc_buttonPanel.gridy = 28;
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
						btnSave = new JButton("Gem");
						btnSave.setVerticalAlignment(SwingConstants.TOP);
						btnSave.setHorizontalAlignment(SwingConstants.RIGHT);
						btnSave.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								saveClicked();
							}
						});
						{
							btnCancel = new JButton("Annuller");
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
																																
																																separator_11 = new JSeparator();
																																GridBagConstraints gbc_separator_11 = new GridBagConstraints();
																																gbc_separator_11.insets = new Insets(0, 0, 5, 5);
																																gbc_separator_11.gridx = 3;
																																gbc_separator_11.gridy = 29;
																																getContentPane().add(separator_11, gbc_separator_11);
																																
																																separator_12 = new JSeparator();
																																GridBagConstraints gbc_separator_12 = new GridBagConstraints();
																																gbc_separator_12.insets = new Insets(0, 0, 5, 5);
																																gbc_separator_12.gridx = 3;
																																gbc_separator_12.gridy = 30;
																																getContentPane().add(separator_12, gbc_separator_12);
																																
																																separator_8 = new JSeparator();
																																GridBagConstraints gbc_separator_8 = new GridBagConstraints();
																																gbc_separator_8.gridwidth = 3;
																																gbc_separator_8.insets = new Insets(0, 0, 5, 5);
																																gbc_separator_8.gridx = 1;
																																gbc_separator_8.gridy = 31;
																																getContentPane().add(separator_8, gbc_separator_8);
																																
																																panel = new JPanel();
																																GridBagConstraints gbc_panel = new GridBagConstraints();
																																gbc_panel.insets = new Insets(0, 0, 0, 5);
																																gbc_panel.gridwidth = 3;
																																gbc_panel.fill = GridBagConstraints.BOTH;
																																gbc_panel.gridx = 1;
																																gbc_panel.gridy = 32;
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
		
		if(txtCountry.getText().length() == 0) {
			labCountry.setText("Mangler input");
			txtCountry.setBorder(border);
			wrongInputTracker++;
		}
		
		if(txtDiscount.getText().length() == 0) {
			txtDiscount.setText("00.00");
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
