package gui;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import controller.*;
import model.Customer;
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
	private JList<Customer> cJList;
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
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnAdd = new JButton("New button");
		panel.add(btnAdd);
		
		btnEdit = new JButton("EDIT");
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
		
		init();
	}
	
	private void init() {
		cc = new CustomerController();
		cc.fill();
		cJList = new JList<Customer>();
		displayCustomers();
		
	}
	
	private void displayCustomers() {
		ctm = new CustomerTM(cc.getAll());
		table.setModel(ctm);
		CustomerListCellRenderer ccr = new CustomerListCellRenderer();
		cJList.setCellRenderer(ccr);
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
			
			Customer c = ctm.getSelectedMember(table.getSelectedRow());
			CustomerGUI cGUI = new CustomerGUI(c);
			cGUI.setVisible(true);
		}
	

}
