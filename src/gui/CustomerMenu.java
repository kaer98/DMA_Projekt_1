package gui;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import controller.*;
import model.Customer;

import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
public class CustomerMenu extends JFrame {

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
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerMenu frame = new CustomerMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnAdd = new JButton("New button");
		panel.add(btnAdd);
		
		btnEdit = new JButton("New button");
		panel.add(btnEdit);
		
		btnDelete = new JButton("New button");
		panel.add(btnDelete);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		textField = new JTextField();
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
		
		init();
	}
	
	private void init() {
		cc = new CustomerController();
		cc.fill();
		displayCustomers();
		
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

}
