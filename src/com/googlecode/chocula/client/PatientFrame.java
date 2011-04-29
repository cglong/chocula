package com.googlecode.chocula.client;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;

import com.googlecode.chocula.core.Patient;

public class PatientFrame extends JFrame implements UIInfo {
	private static final long serialVersionUID = -5399030332235579108L;
	private PatientPanel patientPanel;
	
	/**
	 * Create the frame.
	 */
	public PatientFrame(Patient patient) {
		setBounds(100, 100, WINDOWWIDTH, WINDOWHEIGHT);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, SIDEBARWIDTH, WINDOWHEIGHT);
		getContentPane().add(label, BorderLayout.WEST);
		
		patientPanel = new PatientPanel(patient);
		getContentPane().add(patientPanel, BorderLayout.CENTER);
	}
	
	private class WindowCloseListener implements WindowListener {
		public void windowClosing(WindowEvent we) {
			
		}
		
		public void windowActivated(WindowEvent we) {}
		public void windowClosed(WindowEvent we) {}
		public void windowDeactivated(WindowEvent we) {}
		public void windowDeiconified(WindowEvent we) {}
		public void windowIconified(WindowEvent we) {}
		public void windowOpened(WindowEvent we) {}
	}
}
