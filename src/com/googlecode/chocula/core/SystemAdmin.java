package com.googlecode.chocula.core;

public class SystemAdmin extends Nurse implements IPatient, IDoctor {
	public SystemAdmin(String username, String password) {
		super(username, password);
	}
}
