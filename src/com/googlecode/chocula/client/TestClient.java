package com.googlecode.chocula.client;

import junit.framework.TestCase;
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
}
