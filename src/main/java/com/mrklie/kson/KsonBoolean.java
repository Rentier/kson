package com.mrklie.kson;

public class KsonBoolean extends Kson {
	
	public static final KsonBoolean TRUE = new KsonBoolean(true);
	public static final KsonBoolean FALSE = new KsonBoolean(false);
	
	private final boolean value;
	
	public KsonBoolean(boolean value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (value ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KsonBoolean other = (KsonBoolean) obj;
		if (value != other.value)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return Boolean.toString(value);
	}

}
