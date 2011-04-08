package com.googlecode.chocula.client;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JLabel;

public class PatientFrame extends JFrame implements UIInfo {
	private PatientPanel patientPanel;
	
	/**
	 * Create the frame.
	 */
	public PatientFrame() {
		setBounds(100, 100, WINDOWWIDTH, WINDOWHEIGHT);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JLabel label = new JLabel("Temp");
		label.setBounds(0, 0, SIDEBARWIDTH, WINDOWHEIGHT);
		getContentPane().add(label, BorderLayout.WEST);
		
		patientPanel = new PatientPanel();
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
