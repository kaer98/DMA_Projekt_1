package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CustomerController;
import controller.EmployeeController;
import controller.OrderController;
import controller.ProductController;
import model.Employee;

import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import java.awt.Color;

public class AdminLogin extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JButton btnOk;
	private JButton btnCancel;
	private Employee em;
	private JTextField txtUsername;
	private ProductController pc;
	private OrderController oc;
	private EmployeeController ec;
	private CustomerController cc;
	private JLabel lblWrongpass;


	/**
	 * Create the dialog.
	 */
	public AdminLogin(Employee em, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc) {
		setBounds(100, 100, 280, 162);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(91, 51, 163, 20);
			contentPanel.add(passwordField);
		}
		{
			JLabel lblNewLabel = new JLabel("Password:");
			lblNewLabel.setBounds(10, 54, 84, 14);
			contentPanel.add(lblNewLabel);
		}
		
		txtUsername = new JTextField();
		txtUsername.setBounds(91, 16, 163, 20);
		contentPanel.add(txtUsername);
		txtUsername.setColumns(10);
		txtUsername.setEditable(false);
		txtUsername.setText(em.getName());
		
		JLabel lblNewLabel_1 = new JLabel("Brugernavn:");
		lblNewLabel_1.setBounds(10, 19, 84, 14);
		contentPanel.add(lblNewLabel_1);
		
		lblWrongpass = new JLabel("");
		lblWrongpass.setForeground(new Color(255, 0, 0));
		lblWrongpass.setBounds(91, 68, 163, 14);
		contentPanel.add(lblWrongpass);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okClicked();
					}
				});
			
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
				btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelClicked();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
		init(em, pc, oc, ec, cc);
	}
	private void init(Employee em, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc) {
		this.em = em;
		this.pc = pc;
		this.oc = oc;
		this.ec = ec;
		this.cc = cc;
	}
	
	private void okClicked() {
		if(passwordField.getText().equals(em.getPassword())){
			POS frame = new POS(em, pc, oc, ec, cc);
			frame.setVisible(true);
			setModal(false);
			setVisible(false); 
		}
		else {
			lblWrongpass.setText("Forkert kode, prøv igen!");
		}
	}
	
	private void cancelClicked() {
		setVisible(false);
		dispose();
	}
}
