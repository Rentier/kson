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
		if (nextCharIs('\"')) {
			return parseString();
		} else if(nextCharIsOneOf("-01234567890")) {
			return parseNumber();
		} else if (nextCharIs('{')) {
			return parseObject();
		} else if (nextCharIs('[')) {
			return parseArray();
		} else  {
			throw new KsonException("Not a value", count);
		}		
	}
	
	private KsonString parseString() {
		StringBuffer sb = new StringBuffer();
		acceptOrError('\"');
		while(! nextCharIs('\"')) {
			sb.append(consume());
		}
		acceptOrError('\"');
		return new KsonString(sb.toString());
	}	

	private KsonNumber parseNumber() {
		int sign = 1;
		StringBuffer sb = new StringBuffer();
		
		if(nextCharIs('-')) {
			consume();
			sign = -1;
		}
		
		if(nextCharIs('0')) {
			consume();
			sb.append('0');
		} else {
			if(nextCharIsOneOf("123456789")) {
				sb.append(consume());
			} else {
				throw new KsonException("Invalid number", count);
			}
			
			while(nextCharIsOneOf("1234567890")) {
				sb.append(consume());
			}
		}
		
		if(nextCharIs('.')) {
			sb.append(consume());
			while(nextCharIsOneOf("1234567890")) {
				sb.append(consume());
			}
		}
		
		if(nextCharIsOneOf("eE") ) {
			sb.append(consume());
			if(nextCharIsOneOf("+-")) {
				sb.append(consume()); 
				if( nextCharIsOneOf("1234567890")) {
					sb.append(consume());
					while(nextCharIsOneOf("1234567890")) {
						sb.append(consume());
					}					
				} else {
					error("Exponent lacks digits");
				}
			} else {
				error("Exponent lacks sign");
			}
		}
		
		double number = Double.parseDouble(sb.toString());
		return new KsonNumber(sign * number);
	}

	private KsonObject parseObject() {
		acceptOrError('{');
		KsonObject obj = new KsonObject();
		
		if(nextCharIs('}')) {
			acceptOrError('}');
		} else {
			do {
				KsonString key = parseString();
				acceptOrError(':');
				Kson value = parseValue();
				obj.add(key, value);
			} while(acceptIf(','));		
			acceptOrError('}');
		}
		
		return obj;
	}
	
	private KsonArray parseArray() {
		acceptOrError('[');
		KsonArray array = new KsonArray();
		
		if(nextCharIs(']')) {
			acceptOrError(']');
		} else {
			do {
				Kson val = parseValue();
				array.add(val);
			} while(acceptIf(','));
		}
		
		return array;
	}
	
	// Parse helpers
	
	private char peek() {
		checkEOL();
		return s.charAt(count);
	}
	
	private boolean nextCharIs(char c) {
		if(count >= s.length()) return false;
		skipWhitespace();
		return s.charAt(count) == c;
	}
	
	private boolean nextCharIsOneOf(String str) {
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
	
	private void acceptOrError(char c) {
		skipWhitespace();
		if(s.charAt(count) == c ) {
			count++;
		} else {
			throw new KsonException("Expected " + c + " , got " + peek(), count);
		}
	}
	
	private boolean acceptIf(char c) {
		if(c == peek()) {
			count++;
			return true;
		} else {
			return false;
		}
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
	
	private void error(String s) {
		throw new KsonException(s, count);
	}

}
