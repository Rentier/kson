package com.mrklie.kson;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KsonNumberTest {
	
	KsonParser parser;
	
	@Before
	public void setUp() {
		parser = new KsonParser();
	}
	
	@After
	public void tearDown() {
		parser = null;
	}
	
	// Integer
	
	@Test
	public void parseOneDigitIntegers() {
		for(int i = 0; i < 10; i++) {
			KsonNumber num = new KsonNumber(i);
			assertEquals(num, parser.parse("" + i));	
		}
	}
	
	@Test
	public void parseTwoDigitIntegers() {
		for(int i = 10; i < 100; i++) {
			KsonNumber num = new KsonNumber(i);
			assertEquals(num, parser.parse("" + i));	
		}
	}
	
	@Test
	public void parseOneDigitNegativeIntegers() {
		for(int i = 1; i < 10; i++) {
			KsonNumber num = new KsonNumber(-i);
			assertEquals(num, parser.parse("-" + i));	
		}
	}
	
	@Test
	public void parseTwoDigitNegativeIntegers() {
		for(int i = 10; i < 100; i++) {
			KsonNumber num = new KsonNumber(-i);
			assertEquals(num, parser.parse("-" + i));	
		}
	}
	
	// Floating Point
	
	@Test
	public void parseFloatLeadingZero() {
		KsonNumber num = new KsonNumber(0.42);
		assertEquals(num, parser.parse("0.42"));	
	}
	
	@Test
	public void parseNegativeFloatLeadingZero() {
		KsonNumber num = new KsonNumber(-0.42);
		assertEquals(num, parser.parse("-0.42"));	
	}
	
	@Test
	public void parseLongerFloat() {
		KsonNumber num = new KsonNumber(1965627217.796594004);
		assertEquals(num, parser.parse("1965627217.796594004"));	
	}
	
	@Test
	public void parseLongerNegativeFloat() {
		KsonNumber num = new KsonNumber(-23407890238472934.78902384729342340126);
		assertEquals(num, parser.parse("-23407890238472934.78902384729342340126"));	
	}
	
	@Test
	public void parseLongerFloatSmallE() {
		KsonNumber num = new KsonNumber(42E8);
		assertEquals(num, parser.parse("42E+8"));		
	}
	
	@Test
	public void parseLongerFloatBigE() {
		KsonNumber num = new KsonNumber(42.1337e8);
		assertEquals(num, parser.parse("42.1337e+8"));			
	}
	
	@Test
	public void parseLongerFloatSmallNegE() {
		KsonNumber num = new KsonNumber(42.1337e-2);
		assertEquals(num, parser.parse("42.1337e-2"));			
	}

	

}
