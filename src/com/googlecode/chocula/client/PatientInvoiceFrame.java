package com.googlecode.chocula.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;
import javax.swing.JTable;

import com.googlecode.chocula.core.Invoice;
import com.googlecode.chocula.core.Patient;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Ye Zhefan Derived from Patient
 * 
 */
public class PatientInvoiceFrame extends JFrame implements UIInfo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8829032624518808779L;
	private JTextField textField;
	private JTextField textField_3;
	private JTable table;
	private boolean changed = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String date = "04/05/2011";
					Patient patient = new Patient("Chris", "Long");
					Invoice invoice = new Invoice(patient, date, null, null,
							null);
					PatientInvoiceFrame frame = new PatientInvoiceFrame(invoice);
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
	public PatientInvoiceFrame(Invoice invoice) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (changed) {
					int n = JOptionPane.showConfirmDialog(rootPane,
							"Would you want to save changes?");
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

		JLabel lblLastName = new JLabel("Patient Name: ");
		lblLastName.setFont(new Font("ËÎÌו", Font.PLAIN, 14));
		lblLastName.setBounds(10, 47, 103, 15);
		getContentPane().add(lblLastName);

		textField = new JTextField();
		textField.setText(invoice.getPatientName());
		textField.setEditable(false);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
			}
		});
		textField.setBounds(123, 44, 285, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblDateOfVisit = new JLabel("Date of Visit: ");
		lblDateOfVisit.setFont(new Font("ËÎÌו", Font.PLAIN, 14));
		lblDateOfVisit.setBounds(10, 92, 113, 15);
		getContentPane().add(lblDateOfVisit);

		textField_3 = new JTextField();
		textField_3.setText(invoice.getDate());
		textField_3.setEditable(false);
		textField_3.setBounds(121, 89, 287, 21);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		JLabel lblInvoice = new JLabel("Invoice: ");
		lblInvoice.setFont(new Font("ËÎÌו", Font.PLAIN, 14));
		lblInvoice.setBounds(10, 134, 103, 15);
		getContentPane().add(lblInvoice);

		table = new JTable();
		table.setEnabled(false);
		table.setBounds(90, 148, 622, 275);
		getContentPane().add(table);
	}
}
