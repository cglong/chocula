package com.googlecode.chocula.client;

import java.util.Date;

import junit.framework.TestCase;

import com.db4o.ObjectSet;
import com.googlecode.chocula.core.*;

public class TestClient extends TestCase {
	/**
	 * Tests the login system. Creates a nurse, then attempts login. Following a
	 * successful login, logs out. Then makes three false attempts to achieve
	 * lockout.
	 * 
	 * @author Christopher Long
	 */
	public void testLogin() {
		Storage.getInstance().createNurse("peanut", "brittle");
		Login.getInstance().login("peanut", "brittle");
		assertTrue(Login.getInstance().isLoggedIn());

		Login.getInstance().logout();
		assertFalse(Login.getInstance().isLoggedIn());

		Login.getInstance().login("peanut", "jelly");
		assertFalse(Login.getInstance().isLoggedIn());
		assertTrue(Login.getInstance().canTry());

		Login.getInstance().login("grape", "brittle");
		assertFalse(Login.getInstance().isLoggedIn());
		assertTrue(Login.getInstance().canTry());

		Login.getInstance().login("grape", "jelly");
		assertFalse(Login.getInstance().isLoggedIn());
		assertFalse(Login.getInstance().canTry());

		// Make it so that it resets.

	}

	/**
	 * Tests the creation, reading, updating and deletion of a patient within
	 * the database. Checks that a new patient can be created, then found, then
	 * changed, then deleted.
	 * 
	 * @author Christopher Long
	 */
	public void testCRUDPatient() {
		String username = "patient";
		String password = "pass";
		String firstname = "New";
		String lastname = "Patient";
		String address = "123 Fake Street";
		String phoneNumber = "404-555-5555";
		String gender = "Male";
		String pharmacy = "CVS";
		String insuranceCarrier = "Aetna";
		String date = "04/05/2011";
		int age = 25;
		String[] allergies = { "Chocolate", "Cats" };
		TreatmentRecord[] medicalHistory = {};
		ObjectSet<Patient> result;

		Patient patient = Storage.getInstance().createPatient(username,
				password, firstname, lastname, address, phoneNumber, gender,
				pharmacy, insuranceCarrier, date, age, allergies,
				medicalHistory, null);
		assertTrue(patient != null);

		result = Storage.getInstance().readPatient(username, password,
				firstname, lastname, address, phoneNumber, gender, pharmacy,
				insuranceCarrier, date, age, allergies, medicalHistory, null);
		assertTrue(result.hasNext());

		username = "newPatient";
		Storage.getInstance().updatePatient(patient, username, password,
				firstname, lastname, address, phoneNumber, gender, pharmacy,
				insuranceCarrier, age, allergies, medicalHistory);
		result = Storage.getInstance().readPatient(username, password,
				firstname, lastname, address, phoneNumber, gender, pharmacy,
				insuranceCarrier, date, age, allergies, medicalHistory, null);
		patient = result.next();
		assertEquals(username, patient.getUsername());

		Storage.getInstance().deletePatient(patient);
		result = Storage.getInstance().readPatient(username, password,
				firstname, lastname, address, phoneNumber, gender, pharmacy,
				insuranceCarrier, date, age, allergies, medicalHistory, null);
		assertFalse(result.hasNext());
	}

	/**
	 * Tests the creation, reading, updating and deletion of a nurse within the
	 * database. Checks that a new nurse can be created, then found, then
	 * changed, then deleted.
	 * 
	 * @author Christopher Long
	 */
	public void testCRUDNurse() {
		String username = "nurse";
		String password = "pass";
		ObjectSet<Nurse> result;

		Nurse nurse = Storage.getInstance().createNurse(username, password);
		assertTrue(nurse != null);

		result = Storage.getInstance().readNurse(username, password);
		assertTrue(result.hasNext());

		username = "newNurse";
		Storage.getInstance().updateNurse(nurse, username, password);
		result = Storage.getInstance().readNurse(username, password);
		nurse = result.next();
		assertEquals(username, nurse.getUsername());

		Storage.getInstance().deleteNurse(nurse);
		result = Storage.getInstance().readNurse(username, password);
		assertFalse(result.hasNext());
	}

	/**
	 * Tests the creation, reading, updating and deletion of a doctor within the
	 * database. Checks that a new doctor can be created, then found, then
	 * changed, then deleted.
	 * 
	 * @author Christopher Long
	 */
	public void testCRUDDoctor() {
		String username = "doctor";
		String password = "pass";
		ObjectSet<Doctor> result;

		Doctor doctor = Storage.getInstance().createDoctor(username, password);
		assertTrue(doctor != null);

		result = Storage.getInstance().readDoctor(username, password);
		assertTrue(result.hasNext());

		username = "newDoctor";
		Storage.getInstance().updateNurse(doctor, username, password);
		result = Storage.getInstance().readDoctor(username, password);
		doctor = result.next();
		assertEquals(username, doctor.getUsername());

		Storage.getInstance().deleteNurse(doctor);
		result = Storage.getInstance().readDoctor(username, password);
		assertFalse(result.hasNext());
	}

	/**
	 * Tests the lookup of a patient by name only. Creates and stores the
	 * patient in the database, then attempts to find it using its name.
	 * 
	 * @author Christopher Long
	 */
	public void testPatientLookup() {
		String firstname = "Bob", lastname = "Saget";
		Storage.getInstance().createPatient(null, null, firstname, lastname,
				null, null, null, null, null, null, 0, null, null, null);
		Patient bobSaget = Storage.getInstance().findPatient(firstname,
				lastname);
		assertEquals(firstname, bobSaget.getFirstname());
		assertEquals(lastname, bobSaget.getLastname());
	}

	/**
	 * Tests the creation, reading, updating and deletion of an appointment
	 * within the database. Checks that a new appointment can be created, then
	 * found, then changed, then deleted.
	 * 
	 * @author Christopher Long
	 */
	public void testCRUDAppointment() {
		String date = "";
		Doctor doctor = new Doctor(null, null);
		String reason = "cough";
		Patient patient = new Patient(null, null);
		ObjectSet<Appointment> result;

		Appointment appointment = Storage.getInstance().createAppointment(date,
				doctor, reason, patient);
		assertTrue(appointment != null);

		result = Storage.getInstance().readAppointment(date, doctor, reason,
				patient);
		assertTrue(result.hasNext());

		reason = "sneeze";
		Storage.getInstance().updateAppointment(appointment, date, doctor,
				reason, patient);
		result = Storage.getInstance().readAppointment(date, doctor, reason,
				patient);
		appointment = result.next();
		assertEquals(reason, appointment.getReason());

		Storage.getInstance().deleteAppointment(appointment);
		result = Storage.getInstance().readAppointment(date, doctor, reason,
				patient);
		assertFalse(result.hasNext());
	}

	/**
	 * Tests the creation, reading, updating and deletion of a treatment record
	 * within the database. Checks that a new treatment record can be created,
	 * then found, then changed, then deleted.
	 * 
	 * @author Christopher Long
	 */
	public void testCRUDTreatmentRecord() {
		Doctor doctor = new Doctor(null, null);
		String date = "";
		Nurse nurse = new Nurse(null, null);
		DoctorsOrders doctorsOrders = null;
		String chiefComplaint = "cough";
		String vitalSigns = "120/80";
		String diagnosis = "hypochondria";
		Patient patient = new Patient(null, null);
		ObjectSet<TreatmentRecord> result;

		TreatmentRecord tr = Storage.getInstance().createTreatmentRecord(
				doctor, date, nurse, doctorsOrders, chiefComplaint, vitalSigns,
				diagnosis, patient);
		assertTrue(tr != null);

		result = Storage.getInstance().readTreatmentRecord(doctor, date, nurse,
				doctorsOrders, chiefComplaint, vitalSigns, diagnosis, patient);
		assertTrue(result.hasNext());

		chiefComplaint = "sneeze";
		Storage.getInstance().updateTreatmentRecord(tr, doctor, date, nurse,
				doctorsOrders, chiefComplaint, vitalSigns, diagnosis, patient);
		result = Storage.getInstance().readTreatmentRecord(doctor, date, nurse,
				doctorsOrders, chiefComplaint, vitalSigns, diagnosis, patient);
		tr = result.next();
		assertEquals(chiefComplaint, tr.getChiefComplaint());

		Storage.getInstance().deleteTreatmentRecord(tr);
		result = Storage.getInstance().readTreatmentRecord(doctor, date, nurse,
				doctorsOrders, chiefComplaint, vitalSigns, diagnosis, patient);
		assertFalse(result.hasNext());
	}

	/**
	 * Tests the creation, reading, updating and deletion of a doctor's order
	 * within the database. Checks that a new doctor's order can be created,
	 * then found, then changed, then deleted.
	 * 
	 * @author Christopher Long
	 */
	public void testCRUDDoctorsOrders() {
		String prescriptions = "Ritalin";
		String labWork = "blood drawn";
		String followUpInstr = "take twice daily";
		String otherInstr = "come back in 3 months";
		ObjectSet<DoctorsOrders> result;

		DoctorsOrders doctorsOrders = Storage.getInstance()
				.createDoctorsOrders(prescriptions, labWork, followUpInstr,
						otherInstr);
		assertTrue(doctorsOrders != null);

		result = Storage.getInstance().readDoctorsOrders(prescriptions,
				labWork, followUpInstr, otherInstr);
		assertTrue(result.hasNext());

		prescriptions = "Adderall";
		Storage.getInstance().updateDoctorsOrders(doctorsOrders, prescriptions,
				labWork, followUpInstr, otherInstr);
		result = Storage.getInstance().readDoctorsOrders(prescriptions,
				labWork, followUpInstr, otherInstr);
		doctorsOrders = result.next();
		assertEquals(prescriptions, doctorsOrders.getPrescriptions());

		Storage.getInstance().deleteDoctorsOrders(doctorsOrders);
		result = Storage.getInstance().readDoctorsOrders(prescriptions,
				labWork, followUpInstr, otherInstr);
		assertFalse(result.hasNext());
	}

	/**
	 * Creates a new invoice based on provided data and verifies the Invoice
	 * properly represents the information.
	 * 
	 * @author Christopher Long
	 */
	public void testCreateInvoice() {
		Patient patient = new Patient(null, null);
		patient.setFirstname("Bob");
		patient.setLastname("Saget");

		String date = "";
		Doctor doctor = new Doctor(null, null);
		String itemizedName = "blood work";
		Integer itemizedCost = 100;
		// Add method for adding items to the invoice
		// Add lists of names and associated lists of costs
		// Or a dictionary type object (hashset, for instance) mapping names to
		// costs

		Invoice invoice = new Invoice(patient, date, doctor, itemizedName,
				itemizedCost);
		assertTrue(invoice != null);
		assertEquals("Bob Saget", invoice.getPatientName());
		assertEquals(date, invoice.getDate());
		assertEquals(doctor, invoice.getDoctorSeen());
		assertEquals(itemizedName, invoice.getItemizedName().getItem(0));
		assertEquals(itemizedCost, invoice.getItemizedCost().get(0));
	}

	/**
	 * @author Elise Prado
	 */
	public void testCreateInvoice2() {
		Patient patient = new Patient(null, null);
		patient.setFirstname("Squatty");
		patient.setLastname("The Hobo");

		String date = "";
		Doctor doctor = new Doctor(null, null);
		// is there a limit to how long the string can be?
		String itemizedName = "put in a machine and lots of tests were done and it turned out he had a medical condition so then the doctor did some more tests to hopefully figure out how to cure him but his condition is incurable so some treatments were presecribed insted.";
		Integer itemizedCost = 999100;
		// Add method for adding items to the invoice
		// Add lists of names and associated lists of costs
		// Or a dictionary type object (hashset, for instance) mapping names to
		// costs

		Invoice invoice = new Invoice(patient, date, doctor, itemizedName,
				itemizedCost);
		assertTrue(invoice != null);
		assertEquals("Squatty The Hobo", invoice.getPatientName());
		assertEquals(date, invoice.getDate());
		assertEquals(doctor, invoice.getDoctorSeen());
		assertEquals(itemizedName, invoice.getItemizedName().getItem(0));
		assertEquals(itemizedCost, invoice.getItemizedCost().get(0));
	}

	/**
	 * Tests the error logging system. Creates a new Exception, then stores in
	 * the database. Then reads the database for any exceptions and verifies the
	 * Exception was added.
	 * 
	 * @author Christopher Long
	 */
	public void testLogging() {
		Exception e = new Exception("This sucks");
		String test = "test";
		ErrorEntry ee = Storage.getInstance().createExpectedErrorEntry(e, test);
		assertTrue(ee != null);
		ObjectSet<ErrorEntry> result;

		result = Storage.getInstance().readErrorEntries(e, test);
		assertTrue(result.hasNext());

		Storage.getInstance().deleteErrorEntry(ee);
		result = Storage.getInstance().readErrorEntries(e, test);
		assertFalse(result.hasNext());
	}

	/**
	 * JUnit test to create, read, update, and delete a doctor's order For
	 * create, certain parameters will be added to DoctorsOrders, then add it to
	 * database, result will check if it is there For read, the created
	 * DoctorsOrders will be retrieved from database, and result will check For
	 * update, prescription will be changed, result will check if the
	 * prescription is the latest one For delete, the created DoctorsOrders will
	 * be removed from database, result will check if it is removed
	 * 
	 * @author Ye Zhefan
	 */
	public void testCreateDoctorsOrder() {
		String prescriptions = "morphine";
		String labWork = "addiction";
		String followUpInstr = "One pill every day";
		String otherInstr = "Don't be a junkie!";
		ObjectSet<DoctorsOrders> result;
		DoctorsOrders docorder = Storage.getInstance().createDoctorsOrders(
				prescriptions, labWork, followUpInstr, otherInstr);
		assertTrue(docorder != null);
		result = Storage.getInstance().readDoctorsOrders(prescriptions,
				labWork, followUpInstr, otherInstr);
		assertTrue(result.hasNext());

		prescriptions = "penicillin";
		Storage.getInstance().updateDoctorsOrders(docorder, prescriptions,
				labWork, followUpInstr, otherInstr);
		result = Storage.getInstance().readDoctorsOrders(prescriptions,
				labWork, followUpInstr, otherInstr);
		docorder = result.next();
		assertEquals(prescriptions, docorder.getPrescriptions());

		Storage.getInstance().deleteDoctorsOrders(docorder);
		result = Storage.getInstance().readDoctorsOrders(prescriptions,
				labWork, followUpInstr, otherInstr);
		assertFalse(result.hasNext());

	}
}
