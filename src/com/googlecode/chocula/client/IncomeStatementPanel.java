package com.googlecode.chocula.client;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JTextField;

import com.googlecode.chocula.core.IncomeStatement;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class IncomeStatementPanel extends JPanel implements UIInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = -73262036545966250L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private boolean changed = false;

	private String month;
	private int patientNumber;
	private double expenditure;
	private double aggregateIncome;

	/**
	 * Create the panel.
	 */
	public IncomeStatementPanel(IncomeStatement incomestatement) {
		month = incomestatement.getMonth();
		patientNumber = incomestatement.getPatientNumber();
		expenditure = incomestatement.getExpenditure();
		aggregateIncome = incomestatement.getAggregateincome();

		setBounds(100, 100, WINDOWWIDTH, WINDOWHEIGHT);
		setLayout(null);

		JLabel lblNewLabel = new JLabel("Month: ");
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel.setBounds(131, 88, 83, 15);
		add(lblNewLabel);

		textField = new JTextField();
		textField.setText(incomestatement.getMonth());
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
				month = textField.getText();
			}
		});
		textField.setBounds(210, 86, 580, 21);
		add(textField);
		textField.setColumns(10);

		JLabel lblTotalPatientNumber = new JLabel("Total Patient Number: ");
		lblTotalPatientNumber.setFont(new Font("宋体", Font.PLAIN, 16));
		lblTotalPatientNumber.setBounds(18, 157, 182, 15);
		add(lblTotalPatientNumber);

		textField_1 = new JTextField();
		textField_1.setText(incomestatement.getPatientNumber() + "");
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
				patientNumber = Integer.parseInt(textField_1.getText());
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(210, 155, 580, 21);
		add(textField_1);

		JLabel lblTotalExpenditure = new JLabel("Total Expenditure:  ");
		lblTotalExpenditure.setFont(new Font("宋体", Font.PLAIN, 16));
		lblTotalExpenditure.setBounds(32, 232, 182, 15);
		add(lblTotalExpenditure);

		textField_2 = new JTextField();
		textField_2.setText(incomestatement.getExpenditure() + "");
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
				expenditure = Double.parseDouble(textField_2.getText());
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(210, 230, 580, 21);
		add(textField_2);

		JLabel lblTotalAggregrate = new JLabel("Aggregate Income: ");
		lblTotalAggregrate.setFont(new Font("宋体", Font.PLAIN, 16));
		lblTotalAggregrate.setBounds(32, 310, 182, 15);
		add(lblTotalAggregrate);

		textField_3 = new JTextField();
		textField_3.setText(incomestatement.getAggregateincome() + "");
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
				aggregateIncome = Double.parseDouble(textField_3.getText());
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(210, 308, 580, 21);
		add(textField_3);

		JLabel lblNetIncome = new JLabel("Net Income: ");
		lblNetIncome.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNetIncome.setBounds(87, 395, 110, 15);
		add(lblNetIncome);

		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setText(incomestatement.getNetIncome() + "");
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(210, 393, 580, 21);
		add(textField_4);

		JLabel lblNewLabel_1 = new JLabel("Income Statement");
		lblNewLabel_1.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel_1.setBounds(18, 26, 234, 15);
		add(lblNewLabel_1);
	}
}
