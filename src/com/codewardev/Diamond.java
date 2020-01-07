package com.codewardev;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

// https://www.codewars.com/kata/give-me-a-diamond/train/java

public class Diamond {

	public static String print(int n) {
		/*
		 * System.out.println("  *\n ***\n*****\n ***\n  *\n");
		 * System.out.println(" *\n***\n *\n");
		 */
		
		if(n%2 == 0 || n < 0) return null;
		
		String[] lines = new String[n/2];
		String aLine = "";
		int numSpaces = n/2;
		int counter=0;
		for(int i=1; i<n; i += 2) {
			for(int k=0; k<numSpaces; k++) {
				aLine += " ";
			}
			for(int j=0; j<i; j++) {
				aLine += "*";
			}
			aLine += "\n";
			numSpaces--;
			lines[counter] = aLine;
			counter++;
			aLine ="";
		}
		
		String result = Arrays.stream(lines).collect(Collectors.joining());
		Arrays.sort(lines, Collections.reverseOrder());
		for(int i=0; i<n; i++) {
			aLine += "*";
		}
		aLine += "\n";
		result += aLine;
		result += Arrays.stream(lines).collect(Collectors.joining());
		
		System.out.println(result);
		
		return result;
	}

}
