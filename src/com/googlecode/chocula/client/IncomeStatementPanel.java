package com.googlecode.chocula.client;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class IncomeStatementPanel extends JPanel implements UIInfo{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Create the panel.
	 */
	public IncomeStatementPanel() {
		setBounds(100, 100, WINDOWWIDTH, WINDOWHEIGHT);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Month: ");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(131, 88, 83, 15);
		add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(210, 86, 580, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblTotalPatientNumber = new JLabel("Total Patient Number: ");
		lblTotalPatientNumber.setFont(new Font("宋体", Font.PLAIN, 16));
		lblTotalPatientNumber.setBounds(18, 157, 182, 15);
		add(lblTotalPatientNumber);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(210, 155, 580, 21);
		add(textField_1);
		
		JLabel lblTotalExpenditure = new JLabel("Total Expenditure:  ");
		lblTotalExpenditure.setFont(new Font("宋体", Font.PLAIN, 16));
		lblTotalExpenditure.setBounds(32, 232, 182, 15);
		add(lblTotalExpenditure);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(210, 230, 580, 21);
		add(textField_2);
		
		JLabel lblTotalAggregrate = new JLabel("Aggregate Income: ");
		lblTotalAggregrate.setFont(new Font("宋体", Font.PLAIN, 16));
		lblTotalAggregrate.setBounds(32, 310, 182, 15);
		add(lblTotalAggregrate);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(210, 308, 580, 21);
		add(textField_3);
		
		JLabel lblNetIncome = new JLabel("Net Income: ");
		lblNetIncome.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNetIncome.setBounds(87, 395, 182, 15);
		add(lblNetIncome);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(210, 393, 580, 21);
		add(textField_4);
	}
}
