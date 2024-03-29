package gui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import controller.CustomerController;
import controller.EmployeeController;
import controller.OrderController;
import controller.ProductController;
import model.Appliance;
import model.Customer;
import model.Employee;
import model.Order;
import model.PartOrder;
import model.Product;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.Component;

public class POS extends JFrame {

	private JPanel contentPane;
	private ProductController pCtrl;
	private EmployeeController eCtrl;
	private CustomerController cCtrl;
	private OrderController oCtrl;
	private Employee employee;
	private JList<Product> pJList;
	private JList<PartOrder> oJList;
	private JTable ptable;
	private JButton btnLookupCustomer;
	private JButton btnPay;
	private JButton btnClear;
	private JButton btnEdit;
	private ProductTM ptm;
	private JPanel panel_1;
	private JTextField txtSearch;
	private ArrayList<Product> pList; 
	private JPanel panel_3;
	private JButton btnSend;
	private JScrollPane scrollPane_1;
	private JTable table;
	private OrderTM otm;
	private Order salesOrder;
	private JPanel panel_5;
	private JPanel panel_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JTextField txtCDiscount;
	private JTextField txtSubtotalDiscount;
	private JTextField txtTax;
	private JTextField txtTotal;
	private JTextField txtSubtotal;
	private JLabel lblNewLabel_4;
	private CustomerMenu cm;
	private JLabel lblNewLabel_5;
	private JPanel panel_6;
	private JLabel lblCName;
	private JLabel txtCName;
	private JLabel lblCEMAIL;
	private JLabel lblAddress;
	private JLabel txtCMail;
	private JLabel txtCAddress;
	private JLabel lblNewLabel_6;
	private JLabel txtCCity;
	private JButton btnLogOut;
	private JLabel lblCustomerMissing;
	private JPanel panel;
	private JLabel lblProductsMissing;
	private Component verticalStrut;
	private Component verticalStrut_1;
	private Component verticalStrut_2;
	private Component verticalStrut_3;
	/**
	 * Create the frame..
	 */
	public POS(Employee em, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 3, 3, 3));

		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		ptable = new JTable();
		ptable.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				btnEdit.setEnabled(false);
				table.clearSelection();
			}
		});
		ptable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				doubleclicked(e);
			}
		});
		scrollPane.setViewportView(ptable);

		txtSearch = new JTextField();
		txtSearch.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				searchbarFocus();
			}
		});
		txtSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchbarFocus();
			}
		});
		txtSearch.setText("Søg");
		txtSearch.setToolTipText("Search");
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				searchClicked();
			}
		});
		
		panel = new JPanel();
		panel_1.add(panel, BorderLayout.SOUTH);
		
		lblProductsMissing = new JLabel("");
		lblProductsMissing.setForeground(new Color(255, 0, 0));
		lblProductsMissing.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblProductsMissing);
		panel_1.add(txtSearch, BorderLayout.NORTH);
		txtSearch.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.add(panel_2);
		panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));




		scrollPane_1 = new JScrollPane();
		panel_2.add(scrollPane_1, BorderLayout.CENTER);

		table = new JTable();
		table.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				ptable.clearSelection();
			}
		});
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane_1.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnEdit.setEnabled(true);
				removePartOrder(e);

			}
		});

		panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.NORTH);
		
		btnLogOut = new JButton("Log ud");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logOutClicked();
			}
		});
		panel_5.add(btnLogOut);
		panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 45, 0, 49, 111, 0, 59, 0, 55, 55, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 21, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.gridheight = 5;
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 0;
		gbc_verticalStrut_1.gridy = 1;
		panel_4.add(verticalStrut_1, gbc_verticalStrut_1);

		lblNewLabel_2 = new JLabel("Kunderabat");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		panel_4.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.gridheight = 5;
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 2;
		gbc_verticalStrut.gridy = 1;
		panel_4.add(verticalStrut, gbc_verticalStrut);

		txtCDiscount = new JTextField();
		GridBagConstraints gbc_txtCDiscount = new GridBagConstraints();
		gbc_txtCDiscount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCDiscount.insets = new Insets(0, 0, 5, 5);
		gbc_txtCDiscount.gridx = 3;
		gbc_txtCDiscount.gridy = 1;
		panel_4.add(txtCDiscount, gbc_txtCDiscount);
		txtCDiscount.setColumns(10);

		lblNewLabel_5 = new JLabel("%");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 1;
		panel_4.add(lblNewLabel_5, gbc_lblNewLabel_5);

		lblNewLabel = new JLabel("Subtotal");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 6;
		gbc_lblNewLabel.gridy = 1;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);

		txtSubtotal = new JTextField();
		GridBagConstraints gbc_txtSubtotal = new GridBagConstraints();
		gbc_txtSubtotal.gridwidth = 2;
		gbc_txtSubtotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSubtotal.anchor = GridBagConstraints.WEST;
		gbc_txtSubtotal.insets = new Insets(0, 0, 5, 5);
		gbc_txtSubtotal.gridx = 8;
		gbc_txtSubtotal.gridy = 1;
		panel_4.add(txtSubtotal, gbc_txtSubtotal);
		txtSubtotal.setColumns(10);
		txtSubtotal.setEditable(false);

		lblCName = new JLabel("Kundenavn:");
		lblCName.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblCName = new GridBagConstraints();
		gbc_lblCName.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCName.insets = new Insets(0, 0, 5, 5);
		gbc_lblCName.gridx = 1;
		gbc_lblCName.gridy = 2;
		panel_4.add(lblCName, gbc_lblCName);

		txtCName = new JLabel("");
		txtCName.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txtCName = new GridBagConstraints();
		gbc_txtCName.anchor = GridBagConstraints.WEST;
		gbc_txtCName.gridwidth = 2;
		gbc_txtCName.insets = new Insets(0, 0, 5, 5);
		gbc_txtCName.gridx = 3;
		gbc_txtCName.gridy = 2;
		panel_4.add(txtCName, gbc_txtCName);

		lblNewLabel_4 = new JLabel("Subtotal med rabat");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 6;
		gbc_lblNewLabel_4.gridy = 2;
		panel_4.add(lblNewLabel_4, gbc_lblNewLabel_4);

		txtSubtotalDiscount = new JTextField();
		GridBagConstraints gbc_txtSubtotalDiscount = new GridBagConstraints();
		gbc_txtSubtotalDiscount.gridwidth = 2;
		gbc_txtSubtotalDiscount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSubtotalDiscount.insets = new Insets(0, 0, 5, 5);
		gbc_txtSubtotalDiscount.gridx = 8;
		gbc_txtSubtotalDiscount.gridy = 2;
		panel_4.add(txtSubtotalDiscount, gbc_txtSubtotalDiscount);
		txtSubtotalDiscount.setColumns(10);
		txtSubtotalDiscount.setEditable(false);

		lblCEMAIL = new JLabel("E-mail:");
		lblCEMAIL.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblCEMAIL = new GridBagConstraints();
		gbc_lblCEMAIL.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblCEMAIL.insets = new Insets(0, 0, 5, 5);
		gbc_lblCEMAIL.gridx = 1;
		gbc_lblCEMAIL.gridy = 3;
		panel_4.add(lblCEMAIL, gbc_lblCEMAIL);

		txtCMail = new JLabel("");
		txtCMail.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txtCMail = new GridBagConstraints();
		gbc_txtCMail.anchor = GridBagConstraints.WEST;
		gbc_txtCMail.gridwidth = 2;
		gbc_txtCMail.insets = new Insets(0, 0, 5, 5);
		gbc_txtCMail.gridx = 3;
		gbc_txtCMail.gridy = 3;
		panel_4.add(txtCMail, gbc_txtCMail);

		lblNewLabel_1 = new JLabel("MOMS 25%");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 6;
		gbc_lblNewLabel_1.gridy = 3;
		panel_4.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtTax = new JTextField();
		GridBagConstraints gbc_txtTax = new GridBagConstraints();
		gbc_txtTax.gridwidth = 2;
		gbc_txtTax.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTax.insets = new Insets(0, 0, 5, 5);
		gbc_txtTax.gridx = 8;
		gbc_txtTax.gridy = 3;
		panel_4.add(txtTax, gbc_txtTax);
		txtTax.setColumns(10);
		txtTax.setEditable(false);

		lblAddress = new JLabel("Adresse:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 1;
		gbc_lblAddress.gridy = 4;
		panel_4.add(lblAddress, gbc_lblAddress);

		txtCAddress = new JLabel("");
		txtCAddress.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txtCAddress = new GridBagConstraints();
		gbc_txtCAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCAddress.gridwidth = 3;
		gbc_txtCAddress.insets = new Insets(0, 0, 5, 5);
		gbc_txtCAddress.gridx = 3;
		gbc_txtCAddress.gridy = 4;
		panel_4.add(txtCAddress, gbc_txtCAddress);

		lblNewLabel_6 = new JLabel("By:");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 5;
		panel_4.add(lblNewLabel_6, gbc_lblNewLabel_6);

		txtCCity = new JLabel("");
		txtCCity.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txtCCity = new GridBagConstraints();
		gbc_txtCCity.gridwidth = 2;
		gbc_txtCCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCCity.insets = new Insets(0, 0, 5, 5);
		gbc_txtCCity.gridx = 3;
		gbc_txtCCity.gridy = 5;
		panel_4.add(txtCCity, gbc_txtCCity);


		lblNewLabel_3 = new JLabel("Total DKK");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 6;
		gbc_lblNewLabel_3.gridy = 5;
		panel_4.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		verticalStrut_3 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_3 = new GridBagConstraints();
		gbc_verticalStrut_3.gridheight = 5;
		gbc_verticalStrut_3.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_3.gridx = 7;
		gbc_verticalStrut_3.gridy = 1;
		panel_4.add(verticalStrut_3, gbc_verticalStrut_3);

		txtTotal = new JTextField();
		GridBagConstraints gbc_txtTotal = new GridBagConstraints();
		gbc_txtTotal.gridwidth = 2;
		gbc_txtTotal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTotal.insets = new Insets(0, 0, 5, 5);
		gbc_txtTotal.gridx = 8;
		gbc_txtTotal.gridy = 5;
		panel_4.add(txtTotal, gbc_txtTotal);
		txtTotal.setColumns(10);
		txtTotal.setEditable(false);
		
		verticalStrut_2 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_2 = new GridBagConstraints();
		gbc_verticalStrut_2.gridheight = 5;
		gbc_verticalStrut_2.insets = new Insets(0, 0, 5, 0);
		gbc_verticalStrut_2.gridx = 10;
		gbc_verticalStrut_2.gridy = 1;
		panel_4.add(verticalStrut_2, gbc_verticalStrut_2);

		panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 0, 5);
		gbc_panel_6.gridwidth = 9;
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 6;
		panel_4.add(panel_6, gbc_panel_6);
				panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		
		
				btnLookupCustomer = new JButton("Find kunde");
				btnLookupCustomer.setHorizontalAlignment(SwingConstants.LEFT);
				panel_6.add(btnLookupCustomer);
				btnLookupCustomer.setToolTipText("Click to add customer to order");
				btnLookupCustomer.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						lblCustomerMissing.setText("");
						startCustomerMenu();
					}
				});

		btnEdit = new JButton("Rediger");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editClicked();
			}
		});
		btnEdit.setHorizontalAlignment(SwingConstants.RIGHT);
		btnEdit.setToolTipText("Click to edit product in basket");
		panel_6.add(btnEdit);
		
				btnClear = new JButton("Ryd ordre");
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						clearOrder();
					}
				});
				panel_6.add(btnClear);
				btnClear.setToolTipText("Click to clear customer basket ");


		btnPay = new JButton("Betal");
		btnPay.setHorizontalAlignment(SwingConstants.RIGHT);
		btnPay.setToolTipText("Click to make payment through cc terminal");
		panel_6.add(btnPay);

		btnSend = new JButton("Send som faktura");
		btnSend.setHorizontalAlignment(SwingConstants.RIGHT);
		btnSend.setToolTipText("Click to send an invoice for postponed payment(registered companies only!!)");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				startSendManager();
			}
		});
		panel_6.add(btnSend);
		
		lblCustomerMissing = new JLabel("");


		lblCustomerMissing.setForeground(new Color(255, 0, 0));
		panel_6.add(lblCustomerMissing);
		btnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				payClicked();
			}
		});		

		init(em, pc, oc, ec, cc);
	}
	
	private void init(Employee em, ProductController pCtrl, OrderController oCtrl, EmployeeController eCtrl, CustomerController cCtrl) {
		this.pCtrl = pCtrl;
		this.cCtrl = cCtrl;
		this.eCtrl = eCtrl;
		this.oCtrl = oCtrl;
		this.employee = em;

		if(pCtrl.size() == 0) {
			pCtrl.fill();
		}
		
		pJList = new JList<Product>();
		oJList = new JList<PartOrder>();		
		displayProducts();
		salesOrder = oCtrl.makeOrder();
		salesOrder.setEmployee(em);
		txtCDiscount.setText(""+00.00);

		if(!em.isManager()) {
			txtCDiscount.setEditable(false);

		}

		displayOrder();
	} 
	public void startCustomerMenu() {
		cm = new CustomerMenu(employee, salesOrder, pCtrl,oCtrl,eCtrl,cCtrl);
		cm.setVisible(true);
		cm.setModal(true);
		if(cm.isVisible()!=true) {
			Customer currCustomer = cm.getC();
			if(currCustomer != null) {
				salesOrder.setCustomer(currCustomer);
				txtCDiscount.setText(""+currCustomer.getDiscount());
				txtCName.setText(currCustomer.getName());
				txtCMail.setText(currCustomer.getMailAddress());
				txtCAddress.setText(currCustomer.getAddress());
				txtCCity.setText(currCustomer.getPostalCode() + ",  " + currCustomer.getCity());
				displayPrices();
			}
		}
	}
	
	private void startApplianceManager(Appliance a) {
		ApplianceManager am = new ApplianceManager(a, oCtrl, this);
		am.setVisible(true);
		am.setModal(true);
		am.setAlwaysOnTop(true);
		am.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		displayOrder();

	}
	
	private void startPartQuantityManager(PartOrder po) {
		PartQuantityManager pm = new PartQuantityManager(salesOrder, po, oCtrl, this);
		pm.setVisible(true);
		pm.setModal(true);
		pm.setAlwaysOnTop(true);
		pm.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		displayOrder();
	}
	
	private void startPartApplianceManager(PartOrder po) {
		PartApplianceManager pam = new PartApplianceManager(po, oCtrl, this, pCtrl);
		pam.setVisible(true);
		pam.setModal(true);
		pam.setAlwaysOnTop(true);
		pam.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		displayOrder();
	}
	
	private void startSendManager(){
		SendManager sm = new SendManager(this, salesOrder, oCtrl);
		sm.setVisible(true);
		sm.setModal(true);
		sm.setAlwaysOnTop(true);
		sm.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
	}
	
	public void displayOrder() {
		otm = new OrderTM(salesOrder.getParts());
		table.setModel(otm);
		PartOrderListCellRenderer ocr = new PartOrderListCellRenderer();
		oJList.setCellRenderer(ocr);
		displayPrices();
		btnEdit.setEnabled(false);
	}

	public void displayProducts() {
		ptm = new ProductTM(pCtrl.getAll());
		ptm.sort();
		ptable.setModel(ptm); 
		ProductListCellRenderer pcr = new ProductListCellRenderer();
		pJList.setCellRenderer(pcr);
	}

	public void displayPrices() {
			DecimalFormat numberFormat = new DecimalFormat("#0.00");
			txtSubtotal.setText("" + numberFormat.format(salesOrder.getTotal()));
			double withDiscount = salesOrder.getTotal()* ((100 - Double.parseDouble(txtCDiscount.getText()))/100);
			txtSubtotalDiscount.setText("" + numberFormat.format(withDiscount));
			txtTax.setText("" + numberFormat.format(withDiscount *0.25));
			txtTotal.setText("" + numberFormat.format((withDiscount*0.25 + withDiscount)));
	}

	private void searchClicked() {
		pList = new ArrayList<>();
		String s = txtSearch.getText().toLowerCase();
		if(s.equalsIgnoreCase("")) {
			displayProducts();
		}
		else {
			Iterator<Product> it = pCtrl.getAll().iterator();
			while(it.hasNext()) {
				Product p = it.next();
				if(p.getDescription().toLowerCase().contains(s)|| p.getLocation().toLowerCase().contains(s)|| p.getBarcode().toLowerCase().contains(s)) {
					pList.add(p);
				}
			}
			ptm = new ProductTM(pList);
			ptable.setModel(ptm);
		}
	}
	
	private void clearClicked() {
		otm.clearData();
		displayOrder();
		table.clearSelection();
		ptable.clearSelection();
		salesOrder.setCustomer(null);
		txtCDiscount.setText("0.00");
		txtCName.setText("");
		txtCMail.setText("");
		txtCAddress.setText("");
		txtCCity.setText("");
	}
	
	private void logOutClicked() {
		this.setVisible(false);
		Login loginGUI = new Login();
		loginGUI.setVisible(true);
	}
	
	private void editClicked() {
		boolean isAppliance = otm.getSelectedProduct(table.getSelectedRow()).getProduct().isAppliance();
		if(isAppliance) {
			startPartApplianceManager(otm.getSelectedProduct(table.getSelectedRow()));
		}
		else {
			startPartQuantityManager(otm.getSelectedProduct(table.getSelectedRow()));
		}
		displayOrder();
		displayPrices();
	}
	
	private void doubleclicked(MouseEvent e) {
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			e.consume(); 
			Product p = ptm.getSelectedProduct(ptable.getSelectedRow());
			if(p.isAppliance()) {
				Appliance selectedAppliance = (Appliance) ptm.getSelectedProduct(ptable.getSelectedRow());
				startApplianceManager(selectedAppliance);
			}
			else {
				PartOrder part = oCtrl.findPartOrderByProductName(p.getDescription());
				if(part != null) {
					if(oCtrl.findProductByBarcode(p.getBarcode()).getQuantity()>0) {
						part.setQuantity(part.getQuantity()+1);
						oCtrl.findProductByBarcode(p.getBarcode()).setQuantity(oCtrl.findProductByBarcode(p.getBarcode()).getQuantity()-1);
					}
					else {
						lblProductsMissing.setText("Der er ikke flere på lager");
					}
				}	
				else {
					if(oCtrl.findProductByBarcode(p.getBarcode()).getQuantity()>0) {
						oCtrl.addNewPartOrderQ(p, 1);	
						oCtrl.findProductByBarcode(p.getBarcode()).setQuantity(oCtrl.findProductByBarcode(p.getBarcode()).getQuantity()-1);
					}
					else {
						lblProductsMissing.setText("Der er ikke flere på lager");
					}

				}

			}
			displayOrder();
			displayProducts();
			displayPrices();
		}
	}
	private void clearOrder() {
		try {
			for(int i = 0; i<otm.getRowCount();i++ ) {
				PartOrder po = otm.getSelectedProduct(i);	
				if(!po.getProduct().isAppliance()) {
					int q1 = pCtrl.findProductByBarcode(otm.getSelectedProduct(i).getProduct().getBarcode()).getQuantity();
					pCtrl.findProductByBarcode(otm.getSelectedProduct(i).getProduct().getBarcode()).setQuantity(q1+otm.getSelectedProduct(i).getQuantity());
				}
				else {
					pCtrl.addApplianceCopy(po.getCopy(), po.getCopy().getAppliance());
				}
			}
			clearClicked();
			displayOrder();
			displayProducts();
			displayPrices();
		}catch(Exception e) {
			
		}
	}
	
	private void removePartOrder(MouseEvent e) {
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			e.consume(); 
			PartOrder po = otm.getSelectedProduct(table.getSelectedRow());	
			if(!po.getProduct().isAppliance()) {
				int q = pCtrl.findProductByBarcode(po.getProduct().getBarcode()).getQuantity();
				pCtrl.findProductByBarcode(po.getProduct().getBarcode()).setQuantity(q+po.getQuantity());
			}
			else {
				pCtrl.addApplianceCopy(po.getCopy(), po.getCopy().getAppliance());
				
			}
			salesOrder.removePart(po);
			displayOrder();
			displayProducts();
			displayPrices();
		}
	}

	private void searchbarFocus() {
		if(txtSearch.getText().equals("Søg") && txtSearch.hasFocus()) {
			txtSearch.setText(null);
		}
		else if(txtSearch.getText().equals("") && !txtSearch.hasFocus()) {
			txtSearch.setText("Søg");
		}
	}
	
	public void finishOrder() {
		if(salesOrder.getCustomer() != null) {
			oCtrl.addOrder(salesOrder);
			createInvoice();
			cCtrl.findCustomerByPhoneNo(salesOrder.getCustomer().getPhoneNo()).addOrderToCustomer(salesOrder);
			clearClicked();
			salesOrder = oCtrl.makeOrder();
		}
		else{
			lblCustomerMissing.setText("Husk at vælge en kunde!");
		}
	}
	
	private void payClicked() {
		oCtrl.finishOrder("Salg", salesOrder);
		finishOrder();
	}

	private void createInvoice() {
		System.out.println("#######Vestbjerg Byggecenter A/S#######");
		System.out.println("Medarbejder: " + employee.getName());
		System.out.println();
		System.out.println("Dato: " + salesOrder.getDateTime() + " 					Fakturanr.:" + salesOrder.getOrderNo());
		System.out.println();
		System.out.println("Faktura");
		if (salesOrder.getFinal() == "Salg")
			System.out.println("Betalingsdato: " + salesOrder.getDateTime() + " 					Type: " + salesOrder.getFinal());
		if (salesOrder.getFinal() == "Faktura")
			System.out.println("Betalingsdato: " + salesOrder.getDateTime().plusDays(14) + " 					Type: " + salesOrder.getFinal());
		if (salesOrder.getFinal() == "Tilbud")
			System.out.println("Tilbud acceptdato: " + salesOrder.getDateTime().plusDays(14) + " 					Type: " + salesOrder.getFinal());
		System.out.println("Kunde: " + salesOrder.getCustomer().getName() + " \nKundes telefon: " + salesOrder.getCustomer().getPhoneNo());
		System.out.println("Kundes e-mail: " + salesOrder.getCustomer().getMailAddress() + " \nKundes adresse: " + salesOrder.getCustomer().getAddress());
		System.out.println("Kundes CVR-nr: " + salesOrder.getCustomer().getCvr());
		System.out.println();
		for (PartOrder parts : salesOrder.getParts()) {
			if (parts.getQuantity() != 0 && !parts.getProduct().isAppliance())
				System.out.println("\n" + parts.getQuantity() + "x " + parts.getProductName() + ", á " + parts.getProduct().getRetailPrice() + ", pris " + parts.getTotal());
			if (parts.getProduct().isAppliance()) {
				System.out.println("\n1x " + parts.getProductName() +  ", pris " + parts.getTotal());
				System.out.println("Serienummer: " + parts.getCopy().getSerialNo());

			}
		}
		System.out.println("\n\n\nSubtotal: " + txtSubtotal.getText() + "kr");
		if (!txtCDiscount.getText().contentEquals("0.00")) {
			System.out.println("Subtotal med rabat(" + txtCDiscount.getText() + "%):" + txtSubtotalDiscount.getText() + "kr");
		}
		System.out.println("Moms(25%): " + txtTax.getText() + "kr");
		System.out.println("\nTotal DKK: " + txtTotal.getText() + "kr");

	}

}