package com.googlecode.chocula.client;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import com.db4o.ObjectSet;
import com.googlecode.chocula.core.Patient;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.factories.FormFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class PatientPanel extends JPanel implements UIInfo {
	private JTextField textFieldFirstName;
	private JTextField textFieldLastName;
	private JTextField textFieldAddress;
	private JTextField textFieldPhoneNumber;
	private JComboBox comboBoxGender;
	private JTextField textFieldPharmacy;
	private JTextField textFieldInsuranceCarrier;
	private JTextField textFieldAge;
	private JTextField textFieldAllergies;

	/**
	 * Create the panel.
	 */
	public PatientPanel() {
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
				FormFactory.DEFAULT_ROWSPEC,}));
		
		JLabel lblFirstName = new JLabel("First Name:");
		add(lblFirstName, "2, 2, right, default");
		
		textFieldFirstName = new JTextField();
		add(textFieldFirstName, "4, 2, fill, default");
		textFieldFirstName.setColumns(10);
		
		String[] genderChoices = {"Male", "Female"};
		
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
		comboBoxGender = new JComboBox(genderChoices);
		add(comboBoxGender, "4, 18, fill, default");
		
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
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new SearchButtonListener());
		add(btnSearch, "4, 44, right, default");
	}
	
	private class SearchButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String firstname = textFieldFirstName.getText();
			String lastname = textFieldLastName.getText();
			String address = textFieldAddress.getText();
			String phoneNumber = textFieldPhoneNumber.getText();
			String gender = comboBoxGender.toString();
			String pharmacy = textFieldPharmacy.getText();
			String insuranceCarrier = textFieldInsuranceCarrier.getText();
			
			ObjectSet<Patient> result = Storage.getInstance().readPatient(null, null, firstname, lastname, address, phoneNumber, gender, pharmacy, insuranceCarrier, 0, null, null);
			Patient[] patients = new Patient[result.size()];
			for (int i = 0; i < result.size(); i++)
				patients[i] = result.next();
			
			Patient choice = (Patient)JOptionPane.showInputDialog((Component) e.getSource(), "Select a patient to view:",
					"Select Patient", JOptionPane.PLAIN_MESSAGE, null, patients, null);
		}
	}
}
