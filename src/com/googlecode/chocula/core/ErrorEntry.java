package com.googlecode.chocula.core;

/**
 * This class maintains an exception.
 * 
 * @author Christopher Long
 * @version 1.0
 */
public class ErrorEntry {
	private Exception e;
	private Object o;
	private ErrorType type;
	
	/**
	 * This constructor creates a new ErrorEntry.
	 * 
	 * @param e The exception that occurred.
	 * @param o The object that created the exception.
	 */
	protected ErrorEntry(Exception e, Object o, ErrorType type) {
		this.e = e;
		this.o = o;
		this.type = type;
	}
	
	/**
	 * This method creates a new unexpected error entry.
	 * 
	 * @param e The exception
	 * @param o The object that caused the exception
	 * @return The new error entry
	 */
	public static ErrorEntry newUnexpectedException(Exception e, Object o) {
		return new ErrorEntry(e, o, ErrorType.UNEXPECTED);
	}
	
	/**
	 * This method creates a new expected error entry.
	 * 
	 * @param e The exception
	 * @param o The object that caused the exception
	 * @return The new error entry
	 */
	public static ErrorEntry newExpectedException(Exception e, Object o) {
		return new ErrorEntry(e, o, ErrorType.EXPECTED);
	}
	
	/**
	 * This getter returns the exception.
	 * 
	 * @return The exception that occurred.
	 */
	public Exception getException() {
		return e;
	}
	
	/**
	 * This getter returns the object that created the exception.
	 * 
	 * @return The object responsible for the exception.
	 */
	public Object getObject() {
		return o;
	}
	
	public ErrorType getType() {
		return type;
	}
	
	private enum ErrorType {
		UNEXPECTED, EXPECTED;
	}
}
