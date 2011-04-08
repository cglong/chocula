package com.googlecode.chocula.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 
 * @author Ye Zhefan Derived from Patient
 * 
 */
public class PatientReportGraphFrame extends JFrame implements UIInfo {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public PatientReportGraphFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				int n = JOptionPane.showConfirmDialog(rootPane, "ABC");
				if (n == JOptionPane.CANCEL_OPTION) {
					setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
				} else if (n == JOptionPane.NO_OPTION) {
					setDefaultCloseOperation(EXIT_ON_CLOSE);
				} else if (n == JOptionPane.YES_OPTION) {
					setDefaultCloseOperation(EXIT_ON_CLOSE);
				}

			}
		});
		setBounds(100, 100, WINDOWWIDTH, WINDOWHEIGHT);
		getContentPane().setLayout(null);

		JLabel lblPatientHealthHistory = new JLabel("Patient Health History");
		lblPatientHealthHistory.setFont(new Font("ËÎÌו", Font.PLAIN, 16));
		lblPatientHealthHistory.setBounds(10, 43, 218, 15);
		getContentPane().add(lblPatientHealthHistory);

		JLabel lblPatientChartReport = new JLabel("Patient Chart Report Graph");
		lblPatientChartReport.setFont(new Font("ËÎÌו", Font.BOLD, 20));
		lblPatientChartReport.setBounds(236, 10, 307, 15);
		getContentPane().add(lblPatientChartReport);

		table = new JTable();
		table.setBounds(76, 80, 635, 381);
		getContentPane().add(table);
	}
}
