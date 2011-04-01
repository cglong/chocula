package com.googlecode.chocula.client;

import java.util.Date;

import junit.framework.TestCase;

import com.db4o.ObjectSet;
import com.googlecode.chocula.core.*;

public class TestClient extends TestCase {
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
	}
	
	public void testCRUDPatient() {
		String username = "patient";
		String password = "pass";
		String firstname = "New";
		String lastname = "Patient";
		String address = "123 Fake Street";
		String phoneNumber = "404-555-5555";
		String gender = "male";
		String pharmacy = "CVS";
		String insuranceCarrier = "Aetna";
		int age = 25;
		String[] allergies = {"Chocolate", "Cats"};
		TreatmentRecord[] medicalHistory = {};
		ObjectSet<Patient> result;
		
		Patient patient = Storage.getInstance().createPatient(username, password, firstname,
				lastname, address, phoneNumber, gender, pharmacy, insuranceCarrier, age,
				allergies, medicalHistory);
		assertTrue(patient != null);
		
		result = Storage.getInstance().readPatient(username, password, firstname,
				lastname, address, phoneNumber, gender, pharmacy, insuranceCarrier, age,
				allergies, medicalHistory);
		assertTrue(result.hasNext());
		
		username = "newPatient";
		Storage.getInstance().updatePatient(patient, username, password, firstname,
				lastname, address, phoneNumber, gender, pharmacy, insuranceCarrier, age,
				allergies, medicalHistory);
		result = Storage.getInstance().readPatient(username, password, firstname,
				lastname, address, phoneNumber, gender, pharmacy, insuranceCarrier, age,
				allergies, medicalHistory);
		patient = result.next();
		assertEquals(username, patient.getUsername());
		
		Storage.getInstance().deletePatient(patient);
		result = Storage.getInstance().readPatient(username, password, firstname,
				lastname, address, phoneNumber, gender, pharmacy, insuranceCarrier, age,
				allergies, medicalHistory);
		assertFalse(result.hasNext());
	}
	
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
	
	public void testPatientLookup() {
		String firstname = "Bob", lastname = "Saget";
		Storage.getInstance().createPatient(null, null, firstname, lastname, null, null, null,
				null, null, 0, null, null);
		Patient bobSaget = Storage.getInstance().findPatient(firstname, lastname);
		assertEquals(firstname, bobSaget.getFirstname());
		assertEquals(lastname, bobSaget.getLastname());
	}
	
	public void testCRUDAppointment() {
		Date date = new Date();
		Doctor doctor = new Doctor(null, null);
		String reason = "cough";
		Patient patient = new Patient(null, null);
		ObjectSet<Appointment> result;
		
		Appointment appointment = Storage.getInstance().createAppointment(date, doctor, reason, patient);
		assertTrue(appointment != null);
		
		result = Storage.getInstance().readAppointment(date, doctor, reason, patient);
		assertTrue(result.hasNext());
		
		reason = "sneeze";
		Storage.getInstance().updateAppointment(appointment, date, doctor, reason, patient);
		result = Storage.getInstance().readAppointment(date, doctor, reason, patient);
		appointment = result.next();
		assertEquals(reason, appointment.getReason());
		
		Storage.getInstance().deleteAppointment(appointment);
		result = Storage.getInstance().readAppointment(date, doctor, reason, patient);
		assertFalse(result.hasNext());
	}
}
