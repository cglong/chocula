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
	
	/**
	 * This main method starts the server.
	 * 
	 * @param args Any command-line arguments passed in
	 */
	public static void main(String[] args) {
		new Server().runServer();
	}
	
	/**
	 * This method starts a server for receiving messages
	 */
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
	
	/**
	 * This method closes the server
	 */
	public void close() {
		synchronized (this) {
			stop = true;
			this.notify();
		}
	}
}
