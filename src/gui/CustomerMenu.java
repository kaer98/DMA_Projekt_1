package gui;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dialog;

import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import controller.*;
import model.Customer;
import model.Employee;
import model.Order;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Component;
import javax.swing.Box;
public class CustomerMenu extends JDialog{

	private JPanel contentPane;
	private JButton btnAdd;
	private JButton btnInfo;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JPanel panel;
	private CustomerTM ctm;
	private CustomerController cc;
	private JTable table;
	private JPanel panel_1;
	private JTextField txtSearch;
	private ArrayList<Customer> cList;
	private EmployeeController ec;
	private ProductController pc;
	private OrderController oc;
	private Employee em;
	private JButton btnSelect;
	private JList<Customer> cJList;
	private Customer currCustomer;
	private JLabel txtError;
	private Component verticalStrut;
	private Component verticalStrut_1;
	

	/**
	 * Create the frame.
	 */

	public CustomerMenu(Employee em, Order o, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc) {
		

		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 501, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 414, 0, 0};
		gbl_contentPane.rowHeights = new int[]{33, 173, 1, 33, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
				
						panel_1 = new JPanel();
						GridBagConstraints gbc_panel_1 = new GridBagConstraints();
						gbc_panel_1.fill = GridBagConstraints.BOTH;
						gbc_panel_1.insets = new Insets(0, 0, 5, 5);
						gbc_panel_1.gridx = 1;
						gbc_panel_1.gridy = 0;
						contentPane.add(panel_1, gbc_panel_1);
						
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
								txtSearch.setText("Søg");
								txtSearch.setToolTipText("Search");
								txtSearch.addKeyListener(new KeyAdapter() {
									@Override
									public void keyTyped(KeyEvent e) {
										searchClicked();
									}
								});
								panel_1.add(txtSearch);
								txtSearch.setColumns(10);
				
				verticalStrut_1 = Box.createVerticalStrut(20);
				GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
				gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
				gbc_verticalStrut_1.gridx = 0;
				gbc_verticalStrut_1.gridy = 1;
				contentPane.add(verticalStrut_1, gbc_verticalStrut_1);
		
				scrollPane = new JScrollPane();
				GridBagConstraints gbc_scrollPane = new GridBagConstraints();
				gbc_scrollPane.fill = GridBagConstraints.BOTH;
				gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
				gbc_scrollPane.gridx = 1;
				gbc_scrollPane.gridy = 1;
				contentPane.add(scrollPane, gbc_scrollPane);
				
						table = new JTable();
						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						scrollPane.setViewportView(table);
				
				verticalStrut = Box.createVerticalStrut(20);
				GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
				gbc_verticalStrut.insets = new Insets(0, 0, 5, 0);
				gbc_verticalStrut.gridx = 2;
				gbc_verticalStrut.gridy = 1;
				contentPane.add(verticalStrut, gbc_verticalStrut);
				
				txtError = new JLabel("");
				txtError.setForeground(Color.RED);
				GridBagConstraints gbc_txtError = new GridBagConstraints();
				gbc_txtError.insets = new Insets(0, 0, 5, 5);
				gbc_txtError.gridx = 1;
				gbc_txtError.gridy = 2;
				contentPane.add(txtError, gbc_txtError);
		
				panel = new JPanel();
				GridBagConstraints gbc_panel = new GridBagConstraints();
				gbc_panel.gridwidth = 2;
				gbc_panel.insets = new Insets(0, 0, 0, 5);
				gbc_panel.anchor = GridBagConstraints.NORTH;
				gbc_panel.fill = GridBagConstraints.HORIZONTAL;
				gbc_panel.gridx = 1;
				gbc_panel.gridy = 3;
				contentPane.add(panel, gbc_panel);
				
						btnAdd = new JButton("Tilføj ny kunde");
						btnAdd.setToolTipText("Click to add a new customer in the system");
						btnAdd.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								addClicked();
							}
						});
						
								btnSelect = new JButton("Vælg kunde");
								btnSelect.setToolTipText("Click to add customer to order");
								btnSelect.addMouseListener(new MouseAdapter() {
									@Override
									public void mouseClicked(MouseEvent e) {
										selectClicked();

									}
								});
								panel.add(btnSelect);
								panel.add(btnAdd);
								
										btnInfo = new JButton("Info/Rediger");
										btnInfo.setToolTipText("Click to view and edit customer information");
										btnInfo.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												infoClicked();
											}
										});
										panel.add(btnInfo);
										
												btnDelete = new JButton("Annuller");
												btnDelete.addActionListener(new ActionListener() {
													public void actionPerformed(ActionEvent e) {
														cancelClicked();
													}
												});
												panel.add(btnDelete);

		
		init(em,o,pc,oc,ec,cc);
	}


		private void init(Employee em, Order o, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc) {
			this.em = em;
			this.pc = pc;
			this.cc = cc;
			this.ec = ec;
			this.oc = oc;
			cc.fill();
			cJList = new JList<Customer>();
			displayCustomers();
			setModal(true);
}		

	public void displayCustomers() {
		ctm = new CustomerTM(cc.getAll());
		table.setModel(ctm);

		CustomerListCellRendere ccr = new CustomerListCellRendere();
		cJList.setCellRenderer(ccr);
	}

	private void searchClicked() {
		cList = new ArrayList<>();
		String s = txtSearch.getText().toLowerCase();
		if(s.equalsIgnoreCase("")) {
			displayCustomers();
		}
		else {
			Iterator<Customer> it = cc.getAll().iterator();
			while(it.hasNext()) {
				Customer c = it.next();
				if(c.getName().toLowerCase().contains(s)|| c.getMailAddress().toLowerCase().contains(s)|| c.getPhoneNo().toLowerCase().contains(s)||c.getCvr().toLowerCase().contains(s)) {
					cList.add(c);
				}
			}
			ctm = new CustomerTM(cList);
			table.setModel(ctm);
		}
	}

	private void addClicked() {
		this.setModal(false);
		CustomerInfo cGUI = new CustomerInfo(null, em ,pc, oc,ec ,cc, this);
		cGUI.setVisible(true);
		cGUI.setModal(true); 
		cGUI.setAlwaysOnTop(true);
		cGUI.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
	}

	private void infoClicked(){
		try {
			Customer c = ctm.getSelectedMember(table.getSelectedRow());

			this.setModal(false);
			CustomerInfo cInfo = new CustomerInfo(c, em ,pc, oc,ec ,cc, this);
			cInfo.setVisible(true);
			cInfo.setModal(true); 
			cInfo.setAlwaysOnTop(true);
			cInfo.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		} 
		catch(Exception e) {
			txtError.setText("Vælg kunde først!");
		}
	}

	private void cancelClicked() {
		this.dispose();
		this.setVisible(false);

	}

	private void searchbarFocus(){
		if(txtSearch.getText().equals("Søg") && txtSearch.hasFocus()) {
			txtSearch.setText(null);
		}
		else if(txtSearch.getText().equals("") && !txtSearch.hasFocus()) {
			txtSearch.setText("Søg");
		}
	}
	
	public Customer getC() {
		return currCustomer;
	}
	private void selectClicked() {
		currCustomer = ctm.getSelectedMember(table.getSelectedRow());
		cancelClicked();
	}
}
