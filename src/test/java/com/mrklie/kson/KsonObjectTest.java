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
	public void parseEmptyObject() {
		assertEquals(KsonObject.empty(), parser.parse("{}"));
	}
	
	@Test
	public void parseObjectWithOneStringKey() {
		KsonObject obj = KsonObject.empty();
		obj.add(new KsonString("foo"), new KsonString("bar"));
		assertEquals(obj, parser.parse("{\"foo\":\"bar\"}"));
	}
	
	@Test
	public void parseObjectWithTwoStringKeys() {
		KsonObject obj = KsonObject.empty();
		obj.add(new KsonString("foo"), new KsonString("bar"));
		obj.add(new KsonString("bar"), new KsonString("baz"));
		assertEquals(obj, parser.parse("{\"foo\":\"bar\",\"bar\":\"baz\"}"));
	}
	
	@Test
	public void parseObjectWithOneStringKeyAndWhitespace() {
		KsonObject obj = KsonObject.empty();
		obj.add(new KsonString("foo"), new KsonString("bar"));
		assertEquals(obj, parser.parse("{   \"foo\"  : \"bar\" }"));
	}


}
