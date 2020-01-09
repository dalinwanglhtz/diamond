package com.codewardev;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

// https://www.codewars.com/kata/give-me-a-diamond/train/java

public class Diamond {

	public static String print(int n) {
		// Even and negative numbers don't make good diamonds
		if(n%2 == 0 || n < 0) return null;
		
		// Break diamond in two halves, now processing top half
		int numSpaces = n/2, counter=0;
		String[] lines = new String[numSpaces];
		for(int numStars=1; numStars<n; numStars += 2) {
			lines[counter++] = printChars(numSpaces--, ' ')+printChars(numStars, '*')+"\n";
		}
		
		// Now processing bottom half by reversing the top half
		String result = Arrays.stream(lines).collect(Collectors.joining());
		Arrays.sort(lines, Collections.reverseOrder());
		result += printChars(n, '*')+"\n";
		result += Arrays.stream(lines).collect(Collectors.joining());
		
		return result;
	}

	private static String printChars(int num, char x) {
		char[] array = new char[num];
		Arrays.fill(array, x);
		return new StringBuilder().append(array).toString();
	}

}
