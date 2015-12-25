package com.mrklie.kson;


public class KsonNumber extends Kson {
	
	private final double number;
	
	public KsonNumber(double number) {
		this.number = number;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(number);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		KsonNumber other = (KsonNumber) obj;
		if (Double.doubleToLongBits(number) != Double.doubleToLongBits(other.number))
			return false;
		return true;
	}
	
	public String toString() {
		return Double.toString(number);
	}

}
