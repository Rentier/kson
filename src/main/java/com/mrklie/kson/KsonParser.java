package com.mrklie.kson;

public class KsonParser {
	
	private String s;
	private int count;

	public Kson parse(String input) {
		s = input;
		count = 0;
		
		if (s == null || s.isEmpty()) {
			throw new KsonException("Empty String", count);
		}
		
		return parseValue();
	}
	
	private Kson parseValue() {
		if (expect('\"')) {
			return parseString();
		} else if(expectOneOf("-01234567890")) {
			return parseNumber();
		} else if (expect('{')) {
			return parseObject();
		} else if (expect('[')) {
			return parseArray();
		} else  {
			throw new KsonException("Not a value", count);
		}		
	}
	
	private KsonString parseString() {
		StringBuffer sb = new StringBuffer();
		accept('\"');
		while(! expect('\"')) {
			sb.append(consume());
		}
		accept('\"');
		return new KsonString(sb.toString());
	}	

	private KsonNumber parseNumber() {
		int sign = 1;
		StringBuffer sb = new StringBuffer();
		
		if(expect('-')) {
			consume();
			sign = -1;
		}
		
		while(expectOneOf("1234567890")) {
			sb.append(consume());
		}
		
		double number = Double.parseDouble(sb.toString());
		return new KsonNumber(sign * number);
	}

	private KsonObject parseObject() {
		accept('{');
		KsonObject obj = new KsonObject();

		// If there is at least one entry in the object
		boolean hasMore = expect('\"');
			
		while(hasMore) {
			KsonString key = parseString();
			accept(':');
			Kson value = parseValue();
			obj.add(key, value);

			if(expect(',')) {
				accept(',');
			} else {
				hasMore = false;
			}
		}
		
		accept('}');
		
		return obj;
	}
	
	private KsonArray parseArray() {
		KsonArray array = new KsonArray();
		return array;
	}
	
	// Parse helpers
	
	private char peek() {
		checkEOL();
		return s.charAt(count);
	}
	
	private boolean expect(char c) {
		if(count >= s.length()) return false;
		skipWhitespace();
		return s.charAt(count) == c;
	}
	
	private boolean expectOneOf(String str) {
		skipWhitespace();
		if(! hasMore()) return false;
		
		char current = peek();
		for (int i = 0; i < str.length(); i++) {
			if (current == str.charAt(i)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean accept(char c) {
		skipWhitespace();
		return s.charAt(count++) == c;
	}
	
	private char consume() {
		skipWhitespace();
		return s.charAt(count++);

	}
	
	private void skipWhitespace() {
		while(hasMore() && Character.isWhitespace(peek())) {
			count++;
		}
	}
	
	boolean hasMore() {
		return count < s.length();
	}
	
	private void checkEOL() {
		if(!hasMore()) {
			throw new KsonException("Reached EOL");
		}
	}

}
