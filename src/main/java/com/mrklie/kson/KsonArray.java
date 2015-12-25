package com.mrklie.kson;

import java.util.ArrayList;
import java.util.List;

public class KsonArray extends Kson {
	
	private final List<Kson> contents;
	
	public KsonArray() {
		contents = new ArrayList<Kson>();
	}
	
	public void add(Kson kson) {
		contents.add(kson);
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
		KsonArray other = (KsonArray) obj;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return contents.toString();
	}

}
