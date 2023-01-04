package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;

import model.Employee;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class POS extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public POS(Employee em) {
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(23, 61, 390, 428);
		panel_2.add(textArea);
		
		JButton btnNewButton = new JButton("Lookup customer");
		btnNewButton.setBounds(23, 527, 118, 47);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_4 = new JButton("Pay");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(325, 535, 111, 89);
		panel_2.add(btnNewButton_4);
		
		JButton btnManager = new JButton("Manager");
		btnManager.setBounds(10, 11, 89, 23);
		panel_2.add(btnManager);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(171, 11, 89, 23);
		panel_2.add(btnHelp);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(347, 11, 89, 23);
		panel_2.add(btnExit);
		
		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(23, 585, 118, 47);
		panel_2.add(btnCheck);
		
		JButton btnEdits = new JButton("Edits");
		btnEdits.setBounds(171, 527, 118, 47);
		panel_2.add(btnEdits);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(171, 585, 118, 47);
		panel_2.add(btnSend);
	}
}
