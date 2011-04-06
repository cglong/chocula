package com.googlecode.chocula.client;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class MainPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public MainPanel() {
		
		JButton btnViewPatients = new JButton("View Patients");
		
		JButton btnViewAppointments = new JButton("View Appointments");
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		add(btnViewPatients);
		
		JButton btnViewUsers = new JButton("View Users");
		add(btnViewUsers);
		add(btnViewAppointments);
		
		JButton btnView = new JButton("View Reports");
		add(btnView);

	}

}
