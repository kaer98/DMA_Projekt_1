package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ProductController;
import model.ApplianceCopy;
import model.Order;

import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindApplianceCopy extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSearch;
	private Order order;



	/**
	 * Create the dialog.
	 */
	public FindApplianceCopy(Order o) {
		setBounds(100, 100, 264, 120);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
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
			txtSearch.setToolTipText("Input appliance serial number");
			txtSearch.setText("Serial number");
			txtSearch.setBounds(10, 11, 230, 20);
			contentPanel.add(txtSearch);
			txtSearch.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						okClicked();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						cancelClicked();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		init(o);
	}
	
	private void cancelClicked() {
		this.dispose();
		this.setVisible(false);

	}
	private void init(Order o) {
		order = o;
	}
	
	private void okClicked() {
		ProductController pCtrl = new ProductController();
		ApplianceCopy applianceCopy = pCtrl.findApplianceCopyBySerialNo(txtSearch.getText());
		order.addNewPartOrderAppliance(applianceCopy);
		this.dispose();
		this.setVisible(false);
	}
	
	private void searchbarFocus(){
		if(txtSearch.getText().equals("Serial number") && txtSearch.hasFocus()) {
			txtSearch.setText(null);
		}
		else if(txtSearch.getText().equals("") && !txtSearch.hasFocus()) {
			txtSearch.setText("Serial number");
		}
	}

}
