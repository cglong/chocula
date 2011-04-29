package com.googlecode.chocula.client;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.db4o.ObjectSet;
import com.googlecode.chocula.core.Appointment;

public class AppointmentsPanel extends JPanel implements UIInfo {
	private static final long serialVersionUID = -7194609709202184360L;

	/**
	 * Create the panel.
	 */
	public AppointmentsPanel() {
		setBounds(0, 0, PANELWIDTH, WINDOWHEIGHT);
		setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(48, 48, PANELWIDTH-48*2, WINDOWHEIGHT-48*2);
		textArea.setEditable(false);
		add(textArea);
		
		String text = "";
		ObjectSet<Appointment> appointments = Storage.getInstance().readAppointment(null, null, null, null);
		for (Appointment a : appointments)
			text.concat(a.toString() + "\n");
	}
}
