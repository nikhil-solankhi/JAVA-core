package com.customExc;

@SuppressWarnings("serial")
public class CustomerHandlingExc extends Exception {
	public CustomerHandlingExc(String message) {
		super(message);
	}
}