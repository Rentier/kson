package com.mrklie.kson;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		String s = "[{\"id\":1,\"gender\":\"Female\",\"first_name\":\"Bonnie\",\"last_name\":\"Kelly\",\"email\":\"bkelly0@stumbleupon.com\",\"ip_address\":\"189.69.116.42\"}]";
		KsonParser parser = new KsonParser();
		Kson k = parser.parse(s);
		System.out.println(k);
	}
}
