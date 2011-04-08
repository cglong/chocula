package com.googlecode.chocula.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Ye Zhefan Derived from Patient
 * 
 */
public class PatientReportGraphFrame extends JFrame implements UIInfo {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;

	/**
	 * Create the frame.
	 */
	public PatientReportGraphFrame() {
		setBounds(100, 100, WINDOWWIDTH, WINDOWHEIGHT);
		getContentPane().setLayout(null);

		JLabel lblPatientHealthHistory = new JLabel("Patient Health History");
		lblPatientHealthHistory.setFont(new Font("ËÎÌו", Font.PLAIN,
				16));
		lblPatientHealthHistory.setBounds(10, 43, 218, 15);
		getContentPane().add(lblPatientHealthHistory);

		JLabel lblPatientChartReport = new JLabel("Patient Chart Report Graph");
		lblPatientChartReport
				.setFont(new Font("ËÎÌו", Font.BOLD, 20));
		lblPatientChartReport.setBounds(236, 10, 307, 15);
		getContentPane().add(lblPatientChartReport);

		table = new JTable();
		table.setBounds(76, 80, 635, 305);
		getContentPane().add(table);

		JLabel lblIncomeStatement = new JLabel("Income Statement: ");
		lblIncomeStatement.setFont(new Font("ËÎÌו", Font.PLAIN, 16));
		lblIncomeStatement.setBounds(10, 436, 218, 15);
		getContentPane().add(lblIncomeStatement);

		textField = new JTextField();
		textField.setBounds(155, 434, 556, 21);
		getContentPane().add(textField);
		textField.setColumns(10);
	}
}
