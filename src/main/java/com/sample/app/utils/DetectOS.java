package com.sample.app.utils;

public class DetectOS {
    
    public static String starChar() {
		String os = System.getProperty("os.name");
		if (os.contains("Windows")) return "*";
		if (os.contains("Linux")) return "+";
		return "";
	}
}
