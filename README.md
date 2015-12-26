# kson

Simple JSON parser in Java. This was an experiment to see how difficult it is. Result: not too difficult.

## Usage

	String s = "[1,2,3,true,false,{\"answer\":42}]";
	KsonParser parser = new KsonParser();
	Kson kson = parser.parse();
