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

}
