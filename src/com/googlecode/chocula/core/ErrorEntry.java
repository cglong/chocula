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
	public ErrorEntry(Exception e, Object o, ErrorType type) {
		this.e = e;
		this.o = o;
		this.type = type;
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
