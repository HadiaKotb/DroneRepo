package com.drones.drone.Utils;

public class ValidateDigits {
	public static String validateDigitInString(String name) {
	
    int length = name.length();
    String result = "";
    for (int i = 0; i < length; i++) {
        Character character = name.charAt(i);
        if (Character.isDigit(character)) {
            result += character;
        }
    }
    return result;
	}
}
