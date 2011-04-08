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
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author Ye Zhefan Derived from Patient
 * 
 */
public class TreatmentRecordFrame extends JFrame implements UIInfo {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private boolean changed = false;

	/**
	 * Create the frame.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreatmentRecordFrame frame = new TreatmentRecordFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TreatmentRecordFrame() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (!changed) {
					int n = JOptionPane.showConfirmDialog(rootPane, "ABC");
					if (n == JOptionPane.CANCEL_OPTION) {
						setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
					}
				}
			}
		});
		setBounds(100, 100, WINDOWWIDTH, WINDOWHEIGHT);
		setTitle("Treatment Record");
		getContentPane().setLayout(null);

		JLabel lblTreatingDoctor = new JLabel("Treating Doctor: ");
		lblTreatingDoctor.setFont(new Font("宋体", Font.PLAIN, 12));
		lblTreatingDoctor.setBounds(10, 59, 109, 22);
		getContentPane().add(lblTreatingDoctor);

		JLabel lblDateAndTime = new JLabel("Date and Time: ");
		lblDateAndTime.setFont(new Font("宋体", Font.PLAIN, 12));
		lblDateAndTime.setBounds(10, 130, 109, 22);
		getContentPane().add(lblDateAndTime);

		JLabel lblAttendingNurse = new JLabel("Attending Nurse: ");
		lblAttendingNurse.setFont(new Font("宋体", Font.PLAIN, 12));
		lblAttendingNurse.setBounds(10, 206, 109, 22);
		getContentPane().add(lblAttendingNurse);

		JLabel lblDoctorsOrders = new JLabel("Doctors Orders:");
		lblDoctorsOrders.setFont(new Font("宋体", Font.PLAIN, 12));
		lblDoctorsOrders.setBounds(10, 279, 109, 22);
		getContentPane().add(lblDoctorsOrders);

		JLabel lblChiefComplaintsymptoms = new JLabel("Vital Signs: ");
		lblChiefComplaintsymptoms.setFont(new Font("宋体", Font.PLAIN, 12));
		lblChiefComplaintsymptoms.setBounds(10, 414, 137, 22);
		getContentPane().add(lblChiefComplaintsymptoms);

		JLabel label = new JLabel("Chief Complaint: ");
		label.setFont(new Font("宋体", Font.PLAIN, 12));
		label.setBounds(10, 349, 137, 22);
		getContentPane().add(label);

		JLabel lblDiagnosis = new JLabel("Diagnosis: ");
		lblDiagnosis.setFont(new Font("宋体", Font.PLAIN, 12));
		lblDiagnosis.setBounds(10, 482, 137, 22);
		getContentPane().add(lblDiagnosis);

		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				changed = true;
			}
		});
		textField.addInputMethodListener(new InputMethodListener() {
			public void caretPositionChanged(InputMethodEvent arg0) {
				changed = true;
			}

			public void inputMethodTextChanged(InputMethodEvent arg0) {
				changed = true;
			}
		});
		textField.setBounds(129, 60, 580, 21);
		getContentPane().add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(129, 131, 580, 21);
		getContentPane().add(textField_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(129, 207, 580, 21);
		getContentPane().add(textField_2);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(129, 280, 580, 21);
		getContentPane().add(textField_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(129, 350, 580, 21);
		getContentPane().add(textField_4);

		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(129, 415, 580, 21);
		getContentPane().add(textField_5);

		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(129, 483, 580, 21);
		getContentPane().add(textField_6);
	}
}
