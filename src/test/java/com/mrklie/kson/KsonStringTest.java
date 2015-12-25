package com.mrklie.kson;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KsonStringTest {
	
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
	public void parseAlphaString() {
		KsonString str = new KsonString("test");
		assertEquals(str, parser.parse("\"test\""));
	}
	
	@Test
	public void parseNumericString() {
		KsonString str = new KsonString("12346234");
		assertEquals(str, parser.parse("\"12346234\""));
	}
	
	@Test
	public void parseAlphaNumericString() {
		KsonString str = new KsonString("1test123");
		assertEquals(str, parser.parse("\"1test123\""));
	}

}
