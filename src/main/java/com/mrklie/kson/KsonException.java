package com.mrklie.kson;

public class KsonException extends RuntimeException {
	
	private static final long serialVersionUID = 6656908585750846847L; 

	public KsonException(String string, int index) {
		super("At " + index + ": " + string);
	}
	
	public KsonException(String string) {
		super(string);
	}
}
