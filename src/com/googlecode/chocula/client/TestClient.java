package com.googlecode.chocula.client;

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
		assertTrue(result.next() != null);
		
		username = "newPatient";
		Storage.getInstance().updatePatient(patient, username, password, firstname,
				lastname, address, phoneNumber, gender, pharmacy, insuranceCarrier, age,
				allergies, medicalHistory);
		result = Storage.getInstance().readPatient(username, password, firstname,
				lastname, address, phoneNumber, gender, pharmacy, insuranceCarrier, age,
				allergies, medicalHistory);
		Patient newPatient = result.next();
		assertEquals(username, newPatient.getUsername());
		
		Storage.getInstance().deletePatient(newPatient);
		result = Storage.getInstance().readPatient(username, password, firstname,
				lastname, address, phoneNumber, gender, pharmacy, insuranceCarrier, age,
				allergies, medicalHistory);
		assertTrue(result.next() == null);
	}
}
