package com.googlecode.chocula.client;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setBounds(0, 0, 50, 300);
		JButton btnViewPatients = new JButton("View Patients");
		
		JButton btnViewAppointments = new JButton("View Appointments");
		setLayout(new GridLayout(0, 1, 0, 0));
		add(btnViewPatients);
		
		JButton btnViewUsers = new JButton("View Users");
		add(btnViewUsers);
		add(btnViewAppointments);
		
		JButton btnView = new JButton("View Reports");
		add(btnView);

	}

}
