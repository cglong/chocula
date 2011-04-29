package com.googlecode.chocula.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Ye Zhefan Derived from Patient
 * 
 */
public class PatientInvoiceFrame extends JFrame implements UIInfo {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private boolean changed = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientInvoiceFrame frame = new PatientInvoiceFrame();
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
	public PatientInvoiceFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (changed) {
					int n = JOptionPane.showConfirmDialog(rootPane, "ABC");
					if (n == JOptionPane.CANCEL_OPTION) {
						setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
					} else if (n == JOptionPane.NO_OPTION) {
						setDefaultCloseOperation(EXIT_ON_CLOSE);
					} else if (n == JOptionPane.YES_OPTION) {
						setDefaultCloseOperation(EXIT_ON_CLOSE);
					}
				}
			}
		});
		setBounds(100, 100, WINDOWWIDTH, WINDOWHEIGHT);
		setTitle("Patient Invoice");
		getContentPane().setLayout(null);

		JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setFont(new Font("宋体", Font.PLAIN, 14));
		lblLastName.setBounds(10, 51, 103, 15);
		getContentPane().add(lblLastName);

		JLabel lblFirstName = new JLabel("First Name: ");
		lblFirstName.setFont(new Font("宋体", Font.PLAIN, 14));
		lblFirstName.setBounds(255, 52, 103, 15);
		getContentPane().add(lblFirstName);

		JLabel lblMiddleNmae = new JLabel("Middle Name: ");
		lblMiddleNmae.setFont(new Font("宋体", Font.PLAIN, 14));
		lblMiddleNmae.setBounds(533, 52, 103, 15);
		getContentPane().add(lblMiddleNmae);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
			}
		});
		textField.setBounds(90, 49, 120, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(338, 49, 120, 21);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(646, 49, 66, 21);
		getContentPane().add(textField_2);

		JLabel lblDateOfVisit = new JLabel("Date of Visit: ");
		lblDateOfVisit.setFont(new Font("宋体", Font.PLAIN, 14));
		lblDateOfVisit.setBounds(10, 92, 113, 15);
		getContentPane().add(lblDateOfVisit);

		textField_3 = new JTextField();
		textField_3.setBounds(121, 89, 287, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JLabel lblInvoice = new JLabel("Invoice: ");
		lblInvoice.setFont(new Font("宋体", Font.PLAIN, 14));
		lblInvoice.setBounds(10, 134, 103, 15);
		getContentPane().add(lblInvoice);

		table = new JTable();
		table.setBounds(90, 148, 622, 275);
		getContentPane().add(table);
	}

}
