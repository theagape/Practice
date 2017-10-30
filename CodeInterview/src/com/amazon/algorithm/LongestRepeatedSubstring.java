package com.amazon.algorithm;

import java.util.HashSet;

/**
 * 
 *    ababababa
 *  ->abababa
 *  ->  abababa
 *  -> longest : 7
 *  -> answer  : abababa
 * 
 * @author theagape
 *
 */
public class LongestRepeatedSubstring {

	public LongestRepeatedSubstring() {
		// TODO Auto-generated constructor stub
	}
	
	public static int getLongestSubstring(String str) {
		
		HashSet<String> strSet = new HashSet<String>();
		
		int longest = 0;
		int os = -1;
		int oe = -1;
		int rs = -1;
		
		String origin = null;
		
		int count = 1;
		for (os = 0 ; os < str.length() - 1 ; os++) {
			
			for (oe = os ; oe < str.length() ; oe++) {
				
				if ((oe + 1) - os == str.length()) {
					continue;
				}
				
				origin = str.substring(os, oe + 1);
				
				if (!strSet.contains(origin)) {
					strSet.add(origin);
					
					System.out.println("origin[" + count + "] = " + origin);
					count++;
					
				}
				
				if (str.indexOf(origin, os + 1) > -1 && longest < origin.length()) {
					longest = origin.length();
					rs = str.indexOf(origin, os + 1);
				}
				
			}
			
		}
		
		System.out.println("longest length = " + longest);
		System.out.println("repeat start   = " + rs);
		System.out.println("longest string = " + str.substring(rs, rs + longest));
		
		return longest;
	}

	public static void main(String[] args) {
		String str = "ababababa";
		str = "abaaaaxaaaa";
		System.out.println(LongestRepeatedSubstring.getLongestSubstring(str));

	}

}
