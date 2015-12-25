package com.mrklie.kson;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class KsonObjectTest {
	
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
	public void testParseEmptyObject() {
		assertEquals(KsonObject.empty(), parser.parse("{}"));
	}
	
	@Test
	public void testParseObjectWithOneStringKey() {
		KsonObject obj = KsonObject.empty();
		obj.add(new KsonString("foo"), new KsonString("bar"));
		assertEquals(obj, parser.parse("{\"foo\":\"bar\"}"));
	}
	
	@Test
	public void testParseObjectWithTwoStringKeys() {
		KsonObject obj = KsonObject.empty();
		obj.add(new KsonString("foo"), new KsonString("bar"));
		obj.add(new KsonString("bar"), new KsonString("baz"));
		assertEquals(obj, parser.parse("{\"foo\":\"bar\",\"bar\":\"baz\"}"));
	}
	
	@Test
	public void testParseObjectWithOneStringKeyAndWhitespace() {
		KsonObject obj = KsonObject.empty();
		obj.add(new KsonString("foo"), new KsonString("bar"));
		assertEquals(obj, parser.parse("{   \"foo\"  : \"bar\" }"));
	}


}
