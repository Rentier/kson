package com.mrklie.kson;

public class KsonNull extends Kson {
	
	public static final KsonNull NULL = new KsonNull();
	
	private KsonNull() {}
	
	@Override
	public String toString() {
		return "null";
	}

}
