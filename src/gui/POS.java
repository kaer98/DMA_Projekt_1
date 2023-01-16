package gui;

import java.awt.EventQueue;
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
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnManager;
	private JButton btnHelp;
	private JButton btnExit;
	private JButton btnCheck;
	private JButton btnEdits;
	private ProductTM ptm;
	private JPanel panel_1;
	private JTextField txtSearch;
	private ArrayList<Product> pList; 
	private Customer customer;
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

	/**
	 * Create the frame.
	 */
	public POS(Employee em, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1370, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 3, 3, 3));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(10, 2, 2, 2));

		panel_1 = new JPanel();
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		ptable = new JTable();
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
		txtSearch.setText("Search");
		txtSearch.setToolTipText("Search");
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				searchClicked();
			}
		});
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
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removePartOrder(e);
				
			}
		});
		scrollPane_1.setViewportView(table);

		panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.NORTH);
		panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.SOUTH);

		btnManager = new JButton("Manager");
		panel_5.add(btnManager);

		btnHelp = new JButton("Help");
		panel_5.add(btnHelp);

		btnExit = new JButton("Exit");
		panel_5.add(btnExit);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{45, 49, 111, 59, 55, 55, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0, 0, 0, 21, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);



		btnNewButton = new JButton("Lookup customer");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startCustomerMenu();
			}
		});


		btnNewButton_1 = new JButton("Pay");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishOrder();
			}
		});		
		
		lblNewLabel = new JLabel("Subtotal");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 0;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);
		
		txtSubtotal = new JTextField();
		GridBagConstraints gbc_txtSubtotal = new GridBagConstraints();
		gbc_txtSubtotal.anchor = GridBagConstraints.WEST;
		gbc_txtSubtotal.insets = new Insets(0, 0, 5, 0);
		gbc_txtSubtotal.gridx = 5;
		gbc_txtSubtotal.gridy = 0;
		panel_4.add(txtSubtotal, gbc_txtSubtotal);
		txtSubtotal.setColumns(10);
		txtSubtotal.setEditable(false);
				
		lblNewLabel_4 = new JLabel("Subtotal med rabat");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 1;
		panel_4.add(lblNewLabel_4, gbc_lblNewLabel_4);
				
		txtSubtotalDiscount = new JTextField();
		GridBagConstraints gbc_txtSubtotalDiscount = new GridBagConstraints();
		gbc_txtSubtotalDiscount.anchor = GridBagConstraints.WEST;
		gbc_txtSubtotalDiscount.insets = new Insets(0, 0, 5, 0);
		gbc_txtSubtotalDiscount.gridx = 5;
		gbc_txtSubtotalDiscount.gridy = 1;
		panel_4.add(txtSubtotalDiscount, gbc_txtSubtotalDiscount);
		txtSubtotalDiscount.setColumns(10);
		txtSubtotalDiscount.setEditable(false);
		
		lblNewLabel_1 = new JLabel("MOMS 25%");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 2;
		panel_4.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtTax = new JTextField();
		GridBagConstraints gbc_txtTax = new GridBagConstraints();
		gbc_txtTax.anchor = GridBagConstraints.WEST;
		gbc_txtTax.insets = new Insets(0, 0, 5, 0);
		gbc_txtTax.gridx = 5;
		gbc_txtTax.gridy = 2;
		panel_4.add(txtTax, gbc_txtTax);
		txtTax.setColumns(10);
		txtTax.setEditable(false);
		
		lblNewLabel_2 = new JLabel("Kunderabat");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 3;
		panel_4.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtCDiscount = new JTextField();
		GridBagConstraints gbc_txtCDiscount = new GridBagConstraints();
		gbc_txtCDiscount.anchor = GridBagConstraints.WEST;
		gbc_txtCDiscount.insets = new Insets(0, 0, 5, 5);
		gbc_txtCDiscount.gridx = 3;
		gbc_txtCDiscount.gridy = 3;
		panel_4.add(txtCDiscount, gbc_txtCDiscount);
		txtCDiscount.setColumns(10);
		
		
		lblNewLabel_3 = new JLabel("Total DKK");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 3;
		panel_4.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		txtTotal = new JTextField();
		GridBagConstraints gbc_txtTotal = new GridBagConstraints();
		gbc_txtTotal.anchor = GridBagConstraints.WEST;
		gbc_txtTotal.insets = new Insets(0, 0, 5, 0);
		gbc_txtTotal.gridx = 5;
		gbc_txtTotal.gridy = 3;
		panel_4.add(txtTotal, gbc_txtTotal);
		txtTotal.setColumns(10);
		txtTotal.setEditable(false);
		
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 4;
		panel_4.add(btnNewButton_1, gbc_btnNewButton_1);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 4;
		panel_4.add(btnNewButton, gbc_btnNewButton);

		btnCheck = new JButton("Check");
		GridBagConstraints gbc_btnCheck = new GridBagConstraints();
		gbc_btnCheck.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCheck.insets = new Insets(0, 0, 0, 5);
		gbc_btnCheck.gridx = 3;
		gbc_btnCheck.gridy = 4;
		panel_4.add(btnCheck, gbc_btnCheck);

		btnEdits = new JButton("Edits");
		GridBagConstraints gbc_btnEdits = new GridBagConstraints();
		gbc_btnEdits.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnEdits.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdits.gridx = 4;
		gbc_btnEdits.gridy = 4;
		panel_4.add(btnEdits, gbc_btnEdits);

		btnSend = new JButton("Send");
		GridBagConstraints gbc_btnSend = new GridBagConstraints();
		gbc_btnSend.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSend.gridx = 5;
		gbc_btnSend.gridy = 4;
		panel_4.add(btnSend, gbc_btnSend);

		init(em, pc, oc, ec, cc);
	}
	private void init(Employee em, ProductController pCtrl, OrderController oCtrl, EmployeeController eCtrl, CustomerController cCtrl) {
		this.pCtrl = pCtrl;
		this.cCtrl = cCtrl;
		this.eCtrl = eCtrl;
		this.oCtrl = oCtrl;
		this.employee = em;
		pCtrl.fill();
		pJList = new JList<Product>();
		oJList = new JList<PartOrder>();
		displayProducts();
		salesOrder = oCtrl.makeOrder();
		salesOrder.setEmployee(em);
		if(!em.isManager()) {
			txtCDiscount.setEditable(false);
		}
		
		displayOrder();
	} 
	public void startCustomerMenu() {
		CustomerMenu cm = new CustomerMenu(employee, salesOrder, pCtrl,oCtrl,eCtrl,cCtrl);
		cm.setVisible(true);
		cm.setModal(true);

	}
	private void displayOrder() {
		otm = new OrderTM(salesOrder.getParts());
		table.setModel(otm);
		PartOrderListCellRenderer ocr = new PartOrderListCellRenderer();
		oJList.setCellRenderer(ocr);
		
		//not implemented yet, because customer is null
	//	txtSubtotal.setText(String.valueOf(salesOrder.getTotal()));
	//	txtSubtotalDiscount.setText(String.valueOf(salesOrder.getTotal() * customer.getDiscount()));
	//	txtTax.setText(String.valueOf(Double.parseDouble(txtSubtotalDiscount.getText())*0.25));
	//	txtCDiscount.setText(String.valueOf(customer.getDiscount()));
	//	txtTotal.setText(String.valueOf(Double.parseDouble(txtTax.getText()) + Double.parseDouble(txtSubtotalDiscount.getText())))
	}

	private void displayProducts() {
		ptm = new ProductTM(pCtrl.getAll());
		ptm.sort();
		ptable.setModel(ptm); 
		ProductListCellRenderer pcr = new ProductListCellRenderer();
		pJList.setCellRenderer(pcr);
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
			ProductTM ct = new ProductTM(pList);
			ptable.setModel(ct);
		}
	}

	private void doubleclicked(MouseEvent e) {
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			e.consume(); 
			Product p = ptm.getSelectedProduct(ptable.getSelectedRow());
			if(p.isAppliance()) {
				Appliance selectedAppliance = (Appliance) ptm.getSelectedProduct(ptable.getSelectedRow());
				startApplianceBySerialNumber(selectedAppliance);
			}
			else {
				PartOrder part = oCtrl.findPartOrderByProductName(p.getDescription());
				if(part != null) {
					part.setQuantity(part.getQuantity()+1);
				}	
				else {
					oCtrl.addNewPartOrderQ(p, 1);	
				}
			}
			displayOrder();

		}
	}
	
	private void removePartOrder(MouseEvent e) {
		if (e.getClickCount() == 2 && !e.isConsumed()) {
			e.consume(); 
			PartOrder po = otm.getSelectedProduct(table.getSelectedRow());	
			salesOrder.removePart(po);
	}
		displayOrder();
		
		}

	private void searchbarFocus() {
		if(txtSearch.getText().equals("Search") && txtSearch.hasFocus()) {
			txtSearch.setText(null);
		}
		else if(txtSearch.getText().equals("") && !txtSearch.hasFocus()) {
			txtSearch.setText("Search");
		}
	}
	
	private void startApplianceBySerialNumber(Appliance selectedAppliance) {
		FindApplianceCopy fac = new FindApplianceCopy(selectedAppliance, oCtrl);
		fac.setVisible(true);
		fac.setModal(true);
		fac.setAlwaysOnTop(true);
		fac.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		displayOrder();
		
	}
	private void finishOrder() {
		salesOrder.setCustomer(customer);
		salesOrder.invoice();
	}
}