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
public class CustomerMenu extends JDialog {

	private JPanel contentPane;
	private JButton btnAdd;
	private JButton btnEdit;
	private JButton btnDelete;
	private JScrollPane scrollPane;
	private JPanel panel;
	private CustomerTM ctm;
	private CustomerController cc;
	private JTable table;
	private JPanel panel_1;
	private JTextField textField;
	private JButton btnSearch;
	private ArrayList<Customer> cList;
	private EmployeeController ec;
	private ProductController pc;
	private OrderController oc;
	private Employee em;
	private JList cJList;

	


	/**
	 * Create the frame.
	 */
	public CustomerMenu(Employee em, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc) {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnAdd = new JButton("New button");
		panel.add(btnAdd);
		
		btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				editClicked();
			}
		});
		panel.add(btnEdit);
		
		btnDelete = new JButton("New button");
		panel.add(btnDelete);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				searchClicked();
			}
		});
		panel_1.add(textField);
		textField.setColumns(10);
		
		btnSearch = new JButton("Søg");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				searchClicked();
			}
		});
		panel_1.add(btnSearch);		
		
		init(em, pc,oc,ec,cc);
	}
	

		private void init(Employee em, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc) {
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
	
	private void displayCustomers() {
		ctm = new CustomerTM(cc.getAll());
		table.setModel(ctm);
	}
	
	private void searchClicked() {
		cList = new ArrayList<>();
		String s = textField.getText().toLowerCase();
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
	
		private void editClicked(){
			//this.setVisible(false);
			this.setModal(false);
			Customer c = ctm.getSelectedMember(table.getSelectedRow());
			CustomerInfo cGUI = new CustomerInfo(c, em ,pc, oc,ec ,cc);
			cGUI.setVisible(true);
			cGUI.setModal(true); 
			cGUI.setAlwaysOnTop(true);
			cGUI.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
			
		}
	

}
