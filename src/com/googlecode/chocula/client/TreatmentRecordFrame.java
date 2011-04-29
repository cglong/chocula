package com.googlecode.chocula.client;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;

import com.googlecode.chocula.core.Doctor;
import com.googlecode.chocula.core.DoctorsOrders;
import com.googlecode.chocula.core.Nurse;
import com.googlecode.chocula.core.Patient;
import com.googlecode.chocula.core.TreatmentRecord;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.Date;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 
 * @author Ye Zhefan Derived from Patient
 * 
 */
public class TreatmentRecordFrame extends JFrame implements UIInfo {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2903122026142623666L;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private boolean changed = false;
	private JTextField textField_3;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	/**
	 * update info
	 */
	private String tdoc;
	private String date;
	private String nurse;
	private String prescription;
	private String labwork;
	private String followup;
	private String other;
	private String complaint;
	private String vitalsigns;
	private String diag;

	/**
	 * Test the frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor doctor = new Doctor("Ye", null);
					String date = "04/29/2011";
					Nurse nurse = new Nurse("Priya", null);
					DoctorsOrders doctorsOrders = new DoctorsOrders("1", "2",
							"3", "4");
					String chiefComplaint = "cough";
					String vitalSigns = "120/80";
					String diagnosis = "hypochondria";
					Patient patient = new Patient("Chris", "Long");
					TreatmentRecord tr = new TreatmentRecord(doctor, date,
							nurse, doctorsOrders, chiefComplaint, vitalSigns,
							diagnosis, patient);
					TreatmentRecordFrame frame = new TreatmentRecordFrame(tr);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TreatmentRecordFrame(final TreatmentRecord treatmentRecord) {
		tdoc = treatmentRecord.getTreatingDoctor().getUsername();
		date = treatmentRecord.getDateAndTime();
		nurse = treatmentRecord.getAttendingNurse().getUsername();
		prescription = treatmentRecord.getDoctorsOrders().getPrescriptions();
		labwork = treatmentRecord.getDoctorsOrders().getLabWork();
		followup = treatmentRecord.getDoctorsOrders().getFollowUpInstr();
		other = treatmentRecord.getDoctorsOrders().getOtherInstr();
		complaint = treatmentRecord.getChiefComplaint();
		vitalsigns = treatmentRecord.getVitalSigns();
		diag = treatmentRecord.getDiagnosis();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (changed) {
					int n = JOptionPane.showConfirmDialog(rootPane,
							"Would you like to save your changes?");
					if (n == JOptionPane.CANCEL_OPTION) {
						setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
					} else if (n == JOptionPane.NO_OPTION) {
						DoctorsOrders docorder = new DoctorsOrders(
								prescription, labwork, followup, other);
						Storage.getInstance().updateTreatmentRecord(
								treatmentRecord, new Doctor(tdoc, null), date,
								new Nurse(nurse, null), docorder, complaint,
								vitalsigns, diag, treatmentRecord.getPatient());
						setDefaultCloseOperation(EXIT_ON_CLOSE);
					} else if (n == JOptionPane.YES_OPTION) {
						setDefaultCloseOperation(EXIT_ON_CLOSE);
					}
				}
			}
		});
		setBounds(100, 100, 800, 612);
		setTitle("Treatment Record");
		getContentPane().setLayout(null);

		JLabel lblTreatingDoctor = new JLabel("Treating Doctor: ");
		lblTreatingDoctor.setFont(new Font("宋体", Font.PLAIN, 12));
		lblTreatingDoctor.setBounds(10, 98, 109, 22);
		getContentPane().add(lblTreatingDoctor);

		JLabel lblDateAndTime = new JLabel("Date: ");
		lblDateAndTime.setFont(new Font("宋体", Font.PLAIN, 12));
		lblDateAndTime.setBounds(20, 164, 48, 22);
		getContentPane().add(lblDateAndTime);

		JLabel lblAttendingNurse = new JLabel("Attending Nurse: ");
		lblAttendingNurse.setFont(new Font("宋体", Font.PLAIN, 12));
		lblAttendingNurse.setBounds(10, 223, 109, 22);
		getContentPane().add(lblAttendingNurse);

		JLabel lblDoctorsOrders = new JLabel("Doctors Orders:");
		lblDoctorsOrders.setFont(new Font("宋体", Font.PLAIN, 12));
		lblDoctorsOrders.setBounds(10, 262, 109, 22);
		getContentPane().add(lblDoctorsOrders);

		JLabel lblChiefComplaintsymptoms = new JLabel("Vital Signs: ");
		lblChiefComplaintsymptoms.setFont(new Font("宋体", Font.PLAIN, 12));
		lblChiefComplaintsymptoms.setBounds(10, 462, 137, 22);
		getContentPane().add(lblChiefComplaintsymptoms);

		JLabel label = new JLabel("Chief Complaint: ");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(10, 415, 137, 22);
		getContentPane().add(label);

		JLabel lblDiagnosis = new JLabel("Diagnosis: ");
		lblDiagnosis.setFont(new Font("宋体", Font.PLAIN, 12));
		lblDiagnosis.setBounds(10, 508, 137, 22);
		getContentPane().add(lblDiagnosis);

		/**
		 * Treating Doctor
		 */
		textField = new JTextField();
		textField.setText(treatmentRecord.getTreatingDoctor().getUsername());
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
				tdoc = textField.getText();
			}
		});
		textField.setBounds(129, 99, 580, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		/**
		 * Date and Time
		 */
		textField_1 = new JTextField();
		textField_1.setText(treatmentRecord.getDateAndTime());
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				date = textField_1.getText();
				changed = true;
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(129, 164, 580, 21);
		getContentPane().add(textField_1);

		/**
		 * Nurse
		 */
		textField_2 = new JTextField();
		textField_2.setText(treatmentRecord.getAttendingNurse().getUsername());
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
				nurse = textField_2.getText();
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(129, 224, 580, 21);
		getContentPane().add(textField_2);

		textField_4 = new JTextField();
		textField_4.setText(treatmentRecord.getChiefComplaint());
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
				complaint = textField_4.getText();
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(129, 416, 580, 21);
		getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.setText(treatmentRecord.getVitalSigns());
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
				vitalsigns = textField_5.getText();
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(129, 463, 580, 21);
		getContentPane().add(textField_5);

		textField_6 = new JTextField();
		textField_6.setText(treatmentRecord.getDiagnosis());
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
				diag = textField_6.getText();
			}
		});
		textField_6.setColumns(10);
		textField_6.setBounds(129, 509, 580, 21);
		getContentPane().add(textField_6);

		JLabel lblPrescription = new JLabel("Prescription:");
		lblPrescription.setBounds(40, 297, 79, 30);
		getContentPane().add(lblPrescription);

		JLabel lblLabwork = new JLabel("Labwork:");
		lblLabwork.setBounds(396, 304, 56, 16);
		getContentPane().add(lblLabwork);

		JLabel lblFollowupInstruction = new JLabel("Followup Instruction:");
		lblFollowupInstruction.setBounds(10, 340, 129, 30);
		getContentPane().add(lblFollowupInstruction);

		JLabel lblOther = new JLabel("Other:");
		lblOther.setBounds(396, 347, 56, 16);
		getContentPane().add(lblOther);

		textField_3 = new JTextField();
		textField_3.setText(treatmentRecord.getDoctorsOrders()
				.getPrescriptions());
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
				prescription = textField_3.getText();
			}
		});
		textField_3.setBounds(162, 301, 116, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);

		textField_7 = new JTextField();
		textField_7.setText(treatmentRecord.getDoctorsOrders().getLabWork());
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
				labwork = textField_7.getText();
			}
		});
		textField_7.setBounds(464, 301, 116, 22);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);

		textField_8 = new JTextField();
		textField_8.setText(treatmentRecord.getDoctorsOrders()
				.getFollowUpInstr());
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
				followup = textField_8.getText();
			}
		});
		textField_8.setBounds(162, 344, 116, 22);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);

		textField_9 = new JTextField();
		textField_9.setText(treatmentRecord.getDoctorsOrders().getOtherInstr());
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				changed = true;
				other = textField_9.getText();
			}
		});
		textField_9.setBounds(464, 344, 116, 22);
		getContentPane().add(textField_9);
		textField_9.setColumns(10);

		JLabel lblPatient = new JLabel("Patient:");
		lblPatient.setBounds(10, 13, 109, 22);
		getContentPane().add(lblPatient);

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(20, 48, 76, 16);
		getContentPane().add(lblFirstName);

		textField_10 = new JTextField();
		textField_10.setText(treatmentRecord.getPatient().getFirstname());
		textField_10.setBounds(129, 45, 116, 22);
		getContentPane().add(textField_10);
		textField_10.setColumns(10);

		JLabel lblLastName = new JLabel("Last Name: ");
		lblLastName.setBounds(376, 48, 76, 16);
		getContentPane().add(lblLastName);

		textField_11 = new JTextField();
		textField_11.setText(treatmentRecord.getPatient().getLastname());
		textField_11.setBounds(464, 45, 116, 22);
		getContentPane().add(textField_11);
		textField_11.setColumns(10);
	}
}
