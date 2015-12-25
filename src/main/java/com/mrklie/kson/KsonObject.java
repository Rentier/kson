package com.mrklie.kson;

import java.util.HashMap;
import java.util.Map;

public class KsonObject extends Kson {
	
	private final Map<KsonString, Kson> contents;
	
	public KsonObject() {
		contents = new HashMap<KsonString, Kson>();
	}
	
	public void add(KsonString key, Kson value) {
		if(! contents.containsKey(key)) {
			contents.put(key, value);
		} else {
			throw new KsonException("Duplicate Key: " + key);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contents == null) ? 0 : contents.hashCode());
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
		KsonObject other = (KsonObject) obj;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		return true;
	}

	public static KsonObject empty() {
		return new KsonObject();
	}

	@Override
	public String toString() {
		return contents.toString();
	}
	
	
	

}
