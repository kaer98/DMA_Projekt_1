package gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
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
	private Order o;
	


	/**
	 * Create the frame.
	 */
	public CustomerMenu(Employee em, Order o, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc) {
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 37, 414, 175);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBounds(20, 223, 414, 33);
		contentPane.add(panel);
		
		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addClicked();
			}
		});
		
		btnSelect = new JButton("Select");
		btnSelect.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				selectClicked();
				
			}
		});
		panel.add(btnSelect);
		panel.add(btnAdd);
		
		btnInfo = new JButton("Info");
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				infoClicked();
			}
		});
		panel.add(btnInfo);
		
		btnDelete = new JButton("Cancel");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelClicked();
			}
		});
		panel.add(btnDelete);
		
		panel_1 = new JPanel();
		panel_1.setBounds(20, 5, 414, 33);
		contentPane.add(panel_1);
		
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
		txtSearch.setText("Search");
		txtSearch.setToolTipText("Search");
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				searchClicked();
			}
		});
		panel_1.add(txtSearch);
		txtSearch.setColumns(10);
		
		init(em,o,pc,oc,ec,cc);
	}
	

		private void init(Employee em, Order o, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc) {
			this.em = em;
			this.o = o;
			this.pc = pc;
			this.cc = cc;
			this.ec = ec;
			this.oc = oc;
			cc.fill();
			cJList = new JList<Customer>();
			displayCustomers();
			setModal(true);
}		
	
	private void displayCustomers() {
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
		CustomerTM ct = new CustomerTM(cList);
		table.setModel(ct);
		}
	}
	
	private void addClicked() {
		this.setModal(false);
		CustomerInfo cGUI = new CustomerInfo(null, em ,pc, oc,ec ,cc);
		cGUI.setVisible(true);
		cGUI.setModal(true); 
		cGUI.setAlwaysOnTop(true);
		cGUI.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
	}
	
	private void infoClicked(){
			//this.setVisible(false);
			this.setModal(false);
			Customer c = ctm.getSelectedMember(table.getSelectedRow());
			CustomerInfo cGUI = new CustomerInfo(c, em ,pc, oc,ec ,cc);
			cGUI.setVisible(true);
			cGUI.setModal(true); 
			cGUI.setAlwaysOnTop(true);
			cGUI.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
		}
		
	private void cancelClicked() {
			this.dispose();
			this.setVisible(false);

		}
	
	private void searchbarFocus(){
		if(txtSearch.getText().equals("Search") && txtSearch.hasFocus()) {
			txtSearch.setText(null);
		}
		else if(txtSearch.getText().equals("") && !txtSearch.hasFocus()) {
			txtSearch.setText("Search");
		}
	}
	private void selectClicked() {
		oc.setCustomerToOrder(o, ctm.getSelectedMember(table.getSelectedRow()));
		cancelClicked();
	}

}
