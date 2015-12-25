package com.mrklie.kson;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class KsonArrayTest extends Kson {
	
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
	public void parseEmptyArray() {
		assertEquals(new KsonArray(), parser.parse("[]"));
	}
	
	@Test
	public void parseArrayWithOneNumber() {
		assertEquals(new KsonArray(), parser.parse("[]"));
	}
	
	@Test
	public void parseArrayWithNumbers() {
		KsonArray array = new KsonArray();
		array.add(new KsonNumber(1337));
		array.add(new KsonNumber(42));
		array.add(new KsonNumber(-23));
		assertEquals(array, parser.parse("[1337,42,-23]"));
	}
	
	@Test
	public void parseArrayWithNumbersAndStrings() {
		assertEquals(new KsonArray(), parser.parse("[]"));
	}

}
