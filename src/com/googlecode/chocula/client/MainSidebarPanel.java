package com.googlecode.chocula.client;

import javax.swing.JPanel;
import javax.swing.JButton;

import com.googlecode.chocula.core.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainSidebarPanel extends JPanel implements UIInfo {
	private static final long serialVersionUID = -9047997162751855623L;
	
	private MainFrame parent;
	private JButton btnViewPatients;
	private JButton btnViewAppointments;
	private JButton btnViewReports;
	private JButton btnViewUsers;
	private JButton btnLogout;

	/**
	 * Create the panel.
	 */
	private MainSidebarPanel() {
		setBounds(0, 0, SIDEBARWIDTH, WINDOWHEIGHT);
		setLayout(new GridLayout(0, 1, 0, 0));
		
		btnViewPatients = new JButton("View Patients");
		btnViewPatients.addActionListener(new PatientListener());
		add(btnViewPatients);
		
		btnViewAppointments = new JButton("View Appointments");
		btnViewAppointments.addActionListener(new AppointmentsListener());
		add(btnViewAppointments);
		
		btnViewReports = new JButton("View Reports");
		btnViewReports.addActionListener(new ReportsListener());
		add(btnViewReports);
		
		btnViewUsers = new JButton("View Users");
		btnViewUsers.addActionListener(new UserListener());
		add(btnViewUsers);
		
		btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new LogoutListener());
		add(btnLogout);
		
		updateButtons();
	}
	
	public MainSidebarPanel(MainFrame parent) {
		this();
		this.parent = parent;
	}
	
	public void updateButtons() {
		User user = Login.getInstance().getUser();
		
		if (user instanceof Nurse) {
			btnViewPatients.setVisible(true);
			btnViewAppointments.setVisible(true);
		} else {
			btnViewPatients.setVisible(false);
			btnViewAppointments.setVisible(false);
		}
		
		if (user instanceof IDoctor)
			btnViewReports.setVisible(true);
		else
			btnViewReports.setVisible(false);
		
		if (user instanceof SystemAdmin)
			btnViewUsers.setVisible(true);
		else
			btnViewUsers.setVisible(false);
		
		if (user != null)
			btnLogout.setVisible(true);
		else
			btnLogout.setVisible(false);
	}
	
	private class PatientListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			parent.showNewPanel(new PatientPanel(), "Patient");
		}
	}
	
	private class AppointmentsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			parent.showNewPanel(new AppointmentsPanel(), "Appointments");
		}
	}
	
	private class ReportsListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			parent.showNewPanel(new IncomeStatementPanel(null), "Income Statement");
		}
	}
	
	private class UserListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			parent.showNewPanel(new UserPanel(), "Users");
		}
	}
	
	private class LogoutListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Login.getInstance().logout();
			parent.showLoginPanel();
			updateButtons();
		}
	}
}
