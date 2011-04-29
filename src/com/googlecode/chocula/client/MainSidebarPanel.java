package com.googlecode.chocula.client;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainSidebarPanel extends JPanel implements UIInfo {
	private static final long serialVersionUID = -9047997162751855623L;
	
	private MainFrame parent;

	/**
	 * Create the panel.
	 */
	private MainSidebarPanel() {
		setBounds(0, 0, SIDEBARWIDTH, WINDOWHEIGHT);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnViewPatients = new JButton("View Patients");
		btnViewPatients.addActionListener(new PatientListener());
		add(btnViewPatients);
		
		JButton btnViewAppointments = new JButton("View Appointments");
		add(btnViewAppointments);
		
		JButton btnViewUsers = new JButton("View Users");
		add(btnViewUsers);
		
		JButton btnView = new JButton("View Reports");
		add(btnView);
	}
	
	public MainSidebarPanel(MainFrame parent) {
		this();
		this.parent = parent;
	}
	
	private class PatientListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			parent.showNewPanel(new PatientPanel(), "Patient");
		}
	}
}
