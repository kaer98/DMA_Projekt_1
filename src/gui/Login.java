package gui;

import java.awt.EventQueue;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import controller.EmployeeController;
import model.EContainer;
import model.Employee;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {
private EmployeeController ec;

	private JPanel contentPane;
	private JPanel panel;
	private JButton btnTest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
				
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblLogin, BorderLayout.NORTH);
		init();
	}
	private void init() {
		ec = new EmployeeController();
		makeButtons();
	}
		
	private void makeButtons() {
		Iterator<Employee> it = ec.getAll().iterator();
		while(it.hasNext()) {
			Employee e = it.next();
			JButton btn = new JButton(e.getName());  
			btn.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					POS frame = new POS();
                    frame.setVisible(true);
				}
			}); 
			panel.add(btn);
		} 

	}
	
}
