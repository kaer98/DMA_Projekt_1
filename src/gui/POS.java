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
import model.Customer;
import model.Employee;
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

public class POS extends JFrame {

	private JPanel contentPane;
	private ProductController pC;
	private EmployeeController ec;
	private CustomerController cc;
	private OrderController oc;
	private Employee employee;
	private JList<Product> pJList;
	private JTable ptable;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnManager;
	private JButton btnHelp;
	private JButton btnExit;
	private JButton btnCheck;
	private JButton btnEdits;
	private JButton btnSend;
	private ProductTM ptm;
	private JPanel panel_1;
	private JTextField textField;
	private ArrayList<Product> pList; 


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
		scrollPane.setViewportView(ptable);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				searchClicked();
			}
		});
		panel_1.add(textField, BorderLayout.NORTH);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(23, 61, 390, 428);
		panel_2.add(textArea);
		
		btnNewButton = new JButton("Lookup customer");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				startCustomerMenu();

			}
		});
		btnNewButton.setBounds(23, 527, 118, 47);
		panel_2.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Pay");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(325, 535, 111, 89);
		panel_2.add(btnNewButton_1);
		
		btnManager = new JButton("Manager");
		btnManager.setBounds(10, 11, 89, 23);
		panel_2.add(btnManager);
		
		btnHelp = new JButton("Help");
		btnHelp.setBounds(171, 11, 89, 23);
		panel_2.add(btnHelp);
		
		btnExit = new JButton("Exit");
		btnExit.setBounds(347, 11, 89, 23);
		panel_2.add(btnExit);
		
		btnCheck = new JButton("Check");
		btnCheck.setBounds(23, 585, 118, 47);
		panel_2.add(btnCheck);
		
		btnEdits = new JButton("Edits");
		btnEdits.setBounds(171, 527, 118, 47);
		panel_2.add(btnEdits);
		
		btnSend = new JButton("Send");
		btnSend.setBounds(171, 585, 118, 47);
		panel_2.add(btnSend);
		init(em, pc, oc, ec, cc);
	}
	private void init(Employee em, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc) {
		this.pC = pc;
		this.cc = cc;
		this.ec = ec;
		this.oc = oc;
		this.employee = em;
		pC.fill();
		pJList = new JList<Product>();
		displayProducts();
	} 
	public void startCustomerMenu() {
		CustomerMenu cm = new CustomerMenu(employee, pC,oc,ec,cc);
		cm.setVisible(true);
		cm.setModal(true);
		
	}
	
	
	private void displayProducts() {
		ptm = new ProductTM(pC.getAll());
		ptm.sort();
		ptable.setModel(ptm); 
		ProductListCellRenderer pcr = new ProductListCellRenderer();
		pJList.setCellRenderer(pcr);
	}
	private void searchClicked() {
		pList = new ArrayList<>();
		String s = textField.getText().toLowerCase();
		if(s.equalsIgnoreCase("")) {
			displayProducts();
		}
		else {
		Iterator<Product> it = pC.getAll().iterator();
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
}
