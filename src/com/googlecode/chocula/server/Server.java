package com.googlecode.chocula.server;

import com.db4o.*;
import com.db4o.cs.*;
import com.db4o.cs.config.*;
import com.db4o.messaging.*;

import com.googlecode.chocula.core.ServerInfo;

/**
 * Implements a central server that stores and maintains data within the system.
 * 
 * @author Christopher Long/Elise Prado
 * @version 1.0
 */
public class Server implements ServerInfo, MessageRecipient {
	private boolean stop = false;
	private String username;
	private String password;
	private int lockout;
	
	public static void main(String[] args) {
		new Server().runServer();
	}
	
	public void runServer() {
		synchronized (this) {
			ServerConfiguration config = Db4oClientServer.newServerConfiguration();
			config.networking().messageRecipient(this);
			ObjectServer db4oServer = Db4oClientServer.openServer(config, FILE, PORT);
			db4oServer.grantAccess(USER, PASS);
			
			Thread.currentThread().setName(this.getClass().getName());
			Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
			try {
				if (!stop)
					this.wait(Long.MAX_VALUE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			db4oServer.close();
		}
	}
	
	@Override
	public void processMessage(MessageContext con, Object msg) {
		close();
	}
	
	public void close() {
		synchronized (this) {
			stop = true;
			this.notify();
		}
	}

	/**
	 * This method will do a check to see if the username/password combo appears
	 * in the database of username/password combos, and will return the username
	 * of the one that fits.
	 */
	public void login(String username, String password) {
		this.username = username;

		// lockout++ when username and password don't match any in database.
	}

	public String logout() {
		return username;
	}
}
