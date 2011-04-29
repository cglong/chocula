package com.googlecode.chocula.client;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPanel;

import com.db4o.ObjectSet;
import com.googlecode.chocula.core.Patient;
import com.googlecode.chocula.core.TreatmentRecord;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PatientPanel extends JPanel implements UIInfo {
	private static final long serialVersionUID = -5234615841289503859L;
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldAddress;
	private JTextField textFieldPhoneNumber;
	private JTextField textFieldPharmacy;
	private JTextField textFieldInsuranceCarrier;
	private JTextField textFieldAge;
	private JTextField textFieldAllergies;
	private JTextField textFieldGender;
	private JButton btnSearch;
	private Patient patient;
	private JButton btnDelete;
	private boolean changed = false;

	/**
	 * Create the panel.
	 */
	public PatientPanel() {
		setBounds(0, 0, PANELWIDTH, WINDOWHEIGHT);
		setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.RELATED_GAP_COLSPEC, FormFactory.DEFAULT_COLSPEC,
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"), }, new RowSpec[] {
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC, FormFactory.DEFAULT_ROWSPEC, }));

		JLabel lblFirstName = new JLabel("First Name:");
		add(lblFirstName, "2, 2, right, default");

		textFieldFirstName = new JTextField();
		add(textFieldFirstName, "4, 2, fill, default");
		textFieldFirstName.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name:");
		add(lblLastName, "2, 6, right, default");

		textFieldLastName = new JTextField();
		add(textFieldLastName, "4, 6, fill, default");
		textFieldLastName.setColumns(10);

		JLabel lblAddress = new JLabel("Address:");
		add(lblAddress, "2, 10, right, default");

		textFieldAddress = new JTextField();
		add(textFieldAddress, "4, 10, fill, default");
		textFieldAddress.setColumns(10);

		JLabel lblPhoneNumber = new JLabel("Phone Number:");
		add(lblPhoneNumber, "2, 14, right, default");

		textFieldPhoneNumber = new JTextField();
		add(textFieldPhoneNumber, "4, 14, fill, default");
		textFieldPhoneNumber.setColumns(10);

		JLabel lblGender = new JLabel("Gender:");
		add(lblGender, "2, 18, right, default");

		textFieldGender = new JTextField();
		add(textFieldGender, "4, 18, fill, default");
		textFieldGender.setColumns(10);

		JLabel lblPharmacy = new JLabel("Pharmacy:");
		add(lblPharmacy, "2, 22, right, default");

		textFieldPharmacy = new JTextField();
		add(textFieldPharmacy, "4, 22, fill, default");
		textFieldPharmacy.setColumns(10);

		JLabel lblInsuranceCarrier = new JLabel("Insurance Carrier:");
		add(lblInsuranceCarrier, "2, 26, right, default");

		textFieldInsuranceCarrier = new JTextField();
		add(textFieldInsuranceCarrier, "4, 26, fill, default");
		textFieldInsuranceCarrier.setColumns(10);

		JLabel lblAge = new JLabel("Age:");
		add(lblAge, "2, 30, right, default");

		textFieldAge = new JTextField();
		add(textFieldAge, "4, 30, fill, default");
		textFieldAge.setColumns(10);

		JLabel lblAllergies = new JLabel("Allergies:");
		add(lblAllergies, "2, 34, right, default");

		textFieldAllergies = new JTextField();
		add(textFieldAllergies, "4, 34, fill, default");
		textFieldAllergies.setColumns(10);

		btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ButtonListener());
		
		btnDelete = new JButton("Delete");
		add(btnDelete, "4, 42, right, default");
		add(btnSearch, "4, 44, right, default");
		
		patient = null;
		btnDelete.setText("Create");
		btnDelete.addActionListener(new DeleteButtonListener());
	}

	public PatientPanel(Patient patient) {
		this();
		this.patient = patient;
		btnDelete.setText("Delete");
		
		textFieldFirstName.setText(patient.getFirstname());
		textFieldLastName.setText(patient.getLastname());
		textFieldAddress.setText(patient.getAddress());
		textFieldPhoneNumber.setText(patient.getPhoneNumber());
		textFieldGender.setText(patient.getGender());
		textFieldPharmacy.setText(patient.getPharmacy());
		textFieldInsuranceCarrier.setText(patient.getInsuranceCarrier());
		textFieldAge.setText(Integer.toString(patient.getAge()));
		btnSearch.setText("View Records");
		
		EditTextListener listener = new EditTextListener();
		textFieldFirstName.addKeyListener(listener);
		textFieldLastName.addKeyListener(listener);
		textFieldAddress.addKeyListener(listener);
		textFieldPhoneNumber.addKeyListener(listener);
		textFieldGender.addKeyListener(listener);
		textFieldPharmacy.addKeyListener(listener);
		textFieldInsuranceCarrier.addKeyListener(listener);
		textFieldAge.addKeyListener(listener);
	}
	
	public boolean saveChanges() {
		if (changed) {
			int n = JOptionPane.showConfirmDialog(this, "Would you like to save your changes?");
			if (n == JOptionPane.CANCEL_OPTION)
				return false;
			else if (n == JOptionPane.NO_OPTION)
				return true;
			else if (n == JOptionPane.YES_OPTION) {
				Storage.getInstance().updatePatient(patient, patient.getUsername(), patient.getPassword(), textFieldFirstName.getText(),
						textFieldLastName.getText(), textFieldAddress.getText(), textFieldPhoneNumber.getText(),
						textFieldGender.getText(), textFieldPharmacy.getText(), textFieldInsuranceCarrier.getText(),
						Integer.parseInt(textFieldAge.getText()), patient.getAllergies(), patient.getMedicalHistory());
				return true;
			}
		}
		return false;
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (patient == null)
				search(e);
			else
				viewRecords(e);
		}
		
		private void search(ActionEvent e) {
			String firstname = textFieldFirstName.getText();
			String lastname = textFieldLastName.getText();
			String address = textFieldAddress.getText();
			String phoneNumber = textFieldPhoneNumber.getText();
			String gender = textFieldGender.getText();
			String pharmacy = textFieldPharmacy.getText();
			String insuranceCarrier = textFieldInsuranceCarrier.getText();
			
			if (firstname.equals(""))
				firstname = null;
			if (lastname.equals(""))
				lastname = null;
			if (address.equals(""))
				address = null;
			if (phoneNumber.equals(""))
				phoneNumber = null;
			if (gender.equals(""))
				gender = null;
			if (pharmacy.equals(""))
				pharmacy = null;
			if (insuranceCarrier.equals(""))
				insuranceCarrier = null;

			ObjectSet<Patient> result = Storage.getInstance().readPatient(null,
					null, firstname, lastname, address, phoneNumber, gender,
					pharmacy, insuranceCarrier, null, 0, null, null, null);
			Patient[] patients = new Patient[result.size()];
			for (int i = 0; i < result.size(); i++)
				patients[i] = result.next();

			Patient choice = (Patient) JOptionPane.showInputDialog(
					(Component) e.getSource(), "Select a patient to view:",
					"Select Patient", JOptionPane.PLAIN_MESSAGE, null,
					patients, null);
			if (choice == null)
				return;
			PatientFrame display = new PatientFrame(choice);
			display.setVisible(true);
		}
		
		private void viewRecords(ActionEvent e) {
			TreatmentRecord[] history = patient.getMedicalHistory();
			TreatmentRecord[] choices = new TreatmentRecord[history.length+1];
			for (int i = 0; i < history.length; i++)
				choices[i] = history[i];
			choices[choices.length-1] = null;
			
			TreatmentRecord choice = (TreatmentRecord) JOptionPane.showInputDialog(
					(Component) e.getSource(), "Select a record to view:",
					"Select Record", JOptionPane.PLAIN_MESSAGE, null,
					choices, null);
		}
	}
	
	private class DeleteButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (patient != null) {
				int n = JOptionPane.showConfirmDialog((Component)e.getSource(), "Are you sure you want to delete this patient?",
						"Delete?", JOptionPane.YES_NO_OPTION);
				if (n == JOptionPane.YES_OPTION)
					Storage.getInstance().deletePatient(patient);
			} else {
				String firstname = textFieldFirstName.getText();
				String lastname = textFieldLastName.getText();
				String address = textFieldAddress.getText();
				String phoneNumber = textFieldPhoneNumber.getText();
				String gender = textFieldGender.getText();
				String pharmacy = textFieldPharmacy.getText();
				String insuranceCarrier = textFieldInsuranceCarrier.getText();
				String age = textFieldAge.getText();
				TreatmentRecord[] medicalHistory = new TreatmentRecord[0];
				
				if (age.equals(""))
					age = "0";
				
				Storage.getInstance().createPatient(null, null, firstname, lastname, address, phoneNumber, gender, pharmacy,
						insuranceCarrier, null, Integer.parseInt(age), null, medicalHistory, null);
				JOptionPane.showMessageDialog((Component)e.getSource(), "Patient successfully created!");
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
