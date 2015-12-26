package com.mrklie.kson;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String s = "[1,2,3,true,false,{\"answer\":42}]";

		KsonParser parser = new KsonParser();
		Kson k = parser.parse(s);
		System.out.println(k);
	}
}
