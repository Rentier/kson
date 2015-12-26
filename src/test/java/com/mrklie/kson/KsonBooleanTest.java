package com.mrklie.kson;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KsonBooleanTest extends Kson {
	
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
	public void parseTrue() {
		assertEquals(KsonBoolean.TRUE, parser.parse("true"));
	}
	
	@Test
	public void parseFalse() {
		assertEquals(KsonBoolean.FALSE, parser.parse("false"));
	}
	
	@Test(expected=KsonException.class)
	public void parseBooleanWithSomeLettersAfter() {
		parser.parse("falser");
	}


}
