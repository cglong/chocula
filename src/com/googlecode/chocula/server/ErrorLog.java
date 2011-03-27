package com.googlecode.chocula.server;
import java.util.Collection;
import java.util.ArrayList;

/**
 * This class maintains a record of all exceptions, both planned
 * and unplanned, that occur when the system is run.
 * 
 * @author Christopher Long
 * @version 1.0
 */
public class ErrorLog {
	private static Collection<ErrorEntry> errors;
	
	/**
	 * This constructors creates a new Error Log to submit exceptions.
	 */
	public ErrorLog() {
		errors = new ArrayList<ErrorEntry>();
	}
	
	/**
	 * This method is used to submit an exception that the system
	 * has not planned for.
	 * 
	 * @param e The exception that occurred.
	 * @param o The object that created the exception.
	 */
	public void unexpectedException(Exception e, Object o) {
		newException(e, o, ErrorType.UNEXPECTED);
	}
	
	/**
	 * This method is used to submit an exception that the system
	 * has planned for. It displays a dialog detailing the error
	 * to the user.
	 * 
	 * @param e The exception that occurred.
	 * @param o The object that created the exception.
	 */
	public void expectedException(Exception e, Object o) {
		newException(e, o, ErrorType.EXPECTED);
		// TODO Display dialog window with message
	}
	
	private void newException(Exception e, Object o, ErrorType t) {
		ErrorEntry errorEntry = new ErrorEntry(e, o, t);
		errors.add(errorEntry);
	}
	
	/**
	 * This class contains information about a specific Exception.
	 * 
	 * @author Christopher Long
	 * @version 1.0
	 */
	private class ErrorEntry {
		private Exception e;
		private Object o;
		private ErrorType t;
		
		/**
		 * This constructor creates a new ErrorEntry.
		 * 
		 * @param e The exception that occurred.
		 * @param o The object that created the exception.
		 */
		public ErrorEntry(Exception e, Object o, ErrorType t) {
			this.e = e;
			this.o = o;
			this.t = t;
		}
		
		/**
		 * This getter returns the exception.
		 * 
		 * @return The exception that occurred.
		 */
		@SuppressWarnings("unused")
		public Exception getException() {
			return e;
		}
		
		/**
		 * This getter returns the object that created the exception.
		 * 
		 * @return The object responsible for the exception.
		 */
		@SuppressWarnings("unused")
		public Object getObject() {
			return o;
		}
		
		@SuppressWarnings("unused")
		public ErrorType getType() {
			return t;
		}
	}
	
	private enum ErrorType {
		UNEXPECTED, EXPECTED;
	}
}
