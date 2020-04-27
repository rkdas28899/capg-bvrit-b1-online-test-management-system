package com.capg.otms.addandassigntest.exceptions;
import java.lang.RuntimeException;

public class TestNotFoundException extends RuntimeException {

	public TestNotFoundException(String message) {
		super(message);
	}
}
