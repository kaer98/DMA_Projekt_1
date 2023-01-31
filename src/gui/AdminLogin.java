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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

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
	private Login login;


	/**
	 * Create the dialog.
	 */
	public AdminLogin(Employee em, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc, Login login) {
		setBounds(100, 100, 301, 141);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{20, 17, 14, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		
		JLabel lblNewLabel_1 = new JLabel("Brugernavn:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		contentPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		txtUsername = new JTextField();
		GridBagConstraints gbc_txtUsername = new GridBagConstraints();
		gbc_txtUsername.fill = GridBagConstraints.BOTH;
		gbc_txtUsername.insets = new Insets(0, 0, 5, 0);
		gbc_txtUsername.gridx = 1;
		gbc_txtUsername.gridy = 0;
		contentPanel.add(txtUsername, gbc_txtUsername);
		txtUsername.setColumns(10);
		txtUsername.setEditable(false);
		txtUsername.setText(em.getName());
		{
			JLabel lblNewLabel = new JLabel("Kodeord:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
			gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 1;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			passwordField = new JPasswordField();
			GridBagConstraints gbc_passwordField = new GridBagConstraints();
			gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
			gbc_passwordField.insets = new Insets(0, 0, 5, 0);
			gbc_passwordField.anchor = GridBagConstraints.NORTH;
			gbc_passwordField.gridx = 1;
			gbc_passwordField.gridy = 1;
			contentPanel.add(passwordField, gbc_passwordField);
		}
		
		lblWrongpass = new JLabel("");
		lblWrongpass.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_lblWrongpass = new GridBagConstraints();
		gbc_lblWrongpass.gridwidth = 2;
		gbc_lblWrongpass.insets = new Insets(0, 0, 0, 5);
		gbc_lblWrongpass.fill = GridBagConstraints.BOTH;
		gbc_lblWrongpass.gridx = 0;
		gbc_lblWrongpass.gridy = 2;
		contentPanel.add(lblWrongpass, gbc_lblWrongpass);
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
		init(em, pc, oc, ec, cc, login);
	}
	private void init(Employee em, ProductController pc, OrderController oc, EmployeeController ec, CustomerController cc, Login login) {
		this.em = em;
		this.pc = pc;
		this.oc = oc;
		this.ec = ec;
		this.cc = cc;
		this.login = login;
	}
	
	private void okClicked() {
		if(passwordField.getText().equals(em.getPassword())){
			POS frame = new POS(em, pc, oc, ec, cc);
			frame.setVisible(true);
			setModal(false);
			setVisible(false); 
			login.setVisible(false);
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
