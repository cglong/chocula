package com.googlecode.chocula.client;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import com.db4o.ObjectSet;
import com.googlecode.chocula.core.Doctor;
import com.googlecode.chocula.core.Nurse;
import com.googlecode.chocula.core.Patient;
import com.googlecode.chocula.core.SystemAdmin;
import com.googlecode.chocula.core.User;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class UserPanel extends JPanel implements UIInfo {
	private JTextField textFieldUsername;
	private JTextField textFieldPassword;
	private JComboBox comboBox;
	private boolean changed = false;

	/**
	 * Create the panel.
	 */
	public UserPanel() {
		setBounds(0, 0, PANELWIDTH, WINDOWHEIGHT);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC,
				FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
			new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,}));
		
		EditTextListener listener = new EditTextListener();
		
		JLabel lblUser = new JLabel("Username:");
		add(lblUser, "2, 16, right, default");
		
		textFieldUsername = new JTextField();
		add(textFieldUsername, "4, 16, fill, default");
		textFieldUsername.setColumns(10);
		textFieldUsername.addKeyListener(listener);
		
		JLabel lblPassword = new JLabel("Password:");
		add(lblPassword, "2, 22, right, default");
		
		textFieldPassword = new JTextField();
		add(textFieldPassword, "4, 22, fill, default");
		textFieldPassword.setColumns(10);
		textFieldPassword.addKeyListener(listener);
		
		JLabel lblType = new JLabel("Type:");
		add(lblType, "2, 28, right, default");
		
		String[] choices = {"Patient", "Nurse", "Doctor", "SysAdmin"};
		comboBox = new JComboBox(choices);
		add(comboBox, "4, 28, fill, default");
		
		JLabel lblSuspended = new JLabel("Suspended:");
		add(lblSuspended, "2, 34");
		
		JCheckBox checkBoxSuspended = new JCheckBox("");
		add(checkBoxSuspended, "4, 34");
		
		JButton btnCreate = new JButton("Create");
		add(btnCreate, "4, 42, right, default");
		btnCreate.addActionListener(new CreateButtonListener());
		
		JButton btnDelete = new JButton("Delete...");
		add(btnDelete, "4, 44, right, default");
		btnDelete.addActionListener(new DeleteButtonListener());
	}
	
	private class CreateButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String username = textFieldUsername.getText();
			String password = textFieldPassword.getText();
			String value = (String) comboBox.getSelectedItem();
			
			if (value.equals("Patient"))
				Storage.getInstance().createPatient(username, password, null, null, null, null, null, null, null, null, 0, null, null, null);
			else if (value.equals("Nurse"))
				Storage.getInstance().createNurse(username, password);
			else if (value.equals("Doctor"))
				Storage.getInstance().createDoctor(username, password);
			else if (value.equals("SysAdmin"))
				Storage.getInstance().createSystemAdmin(username, password);
		}
	}
	
	private class DeleteButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			int n = JOptionPane.showConfirmDialog((Component)e.getSource(), "Are you sure you want to delete this user?",
					"Delete?", JOptionPane.YES_NO_OPTION);
			if (n == JOptionPane.YES_OPTION) {
				String username = textFieldUsername.getText();
				String password = textFieldPassword.getText();
				User user = Storage.getInstance().readUser(username, password);
				
				if (user instanceof SystemAdmin)
					Storage.getInstance().deleteSystemAdmin((SystemAdmin)user);
				else if (user instanceof Doctor)
					Storage.getInstance().deleteDoctor((Doctor) user);
				else if (user instanceof Nurse)
					Storage.getInstance().deleteNurse((Nurse) user);
				else if (user instanceof Patient)
					Storage.getInstance().deletePatient((Patient) user);
			}
		}
	}
	
	private class EditTextListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent arg0) {
			changed = true;
		}
	}
}
