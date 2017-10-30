package com.textnow.coding;

import java.util.ArrayList;

public class Solution {
	
	public static String[] ERROR = new String[]{"-1"};

	public Solution() {
	}
	
	public static String[] generateParts(String long_message, int max_message_size) {
		
		if (long_message == null) {
			return Solution.ERROR;
		}
		if (long_message.isEmpty() == true) {
			return Solution.ERROR;
		}
		if (max_message_size < 10) {
			return Solution.ERROR;
		}
		
		if (long_message.length() < max_message_size) {
			return new String[]{long_message};
		}
		
		ArrayList<String> partsArray = new ArrayList<String>();
		String[] resultStrArray = null;
		
		/**
		 * "TextNow is the very first All-IP carrier.";
		 * 2 .. 9     -> ms = mx - 6
		 *    " (1/N)" .. " (9/N)" -> ms = mx - 6
		 *    LEVEL = 1, TOTAL = N(parts) < 10
		 *    
		 * 10 .. 99   -> ms = mx - 7 (- 8)
		 *    " (1/NN)" .. " (9/NN)"   -> ms = mx - 7
		 *    N(parts) = 9
		 *    " (10/NN)" .. " (99/NN)" -> ms = mx - 8
		 *    M(parts) >= 1, N(parts) <= 90
		 *    LEVEL = 2, TOTAL = N(parts) >= 10, N(parts) < 100
		 *    
		 * 100 .. 999 -> ms = mx - 8 (- 9, - 10)
		 *    " (1/NNN)" .. " (9/NNN)"     -> ms = mx - 8
		 *    N(parts) = 9
		 *    " (10/NNN)" .. " (99/NNN)"   -> ms = mx - 9
		 *    N(parts) >= 1, N(parts) <= 90
		 *    " (100/NNN)" .. " (999/NNN)" -> ms = mx - 10
		 *    N(parts) >= 1, N(parts) <= 900
		 *    LEVEL = 3, TOTAL = N(parts) >= 100, N(parts) < 1000
		 *    
		 * "TextNow";
		 * "TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier.";
		 */
		
		
		String part = null;
		String msg = null;
		
		int level = 1;
		
		msg = long_message;
		
		while (!msg.isEmpty()) {
		
			while (!msg.isEmpty() && !Solution.isOverflown(level, partsArray.size() + 1)) {
				
				part = Solution.fetchPart(msg, max_message_size, level, partsArray.size() + 1);
				
				while (part.endsWith(" ")) {
					part = part.substring(0, part.length() - 1);
				}
				
				// for debugging!!
				// System.out.println("part : " + part);
				
				partsArray.add(part);
				
				msg = msg.substring(part.length());
				
				while (msg.startsWith(" ")) {
					msg = msg.substring(1);
				}
				
			}
			
			if (!msg.isEmpty() && Solution.isOverflown(level, partsArray.size() + 1)) {
				partsArray.clear();
				level += 1;
				msg = long_message;
			}
			
		}
		
		if (partsArray.isEmpty() == true) {
			resultStrArray = Solution.ERROR;
		}
		
		////////////////////////////////////
		int total = partsArray.size();
		resultStrArray = new String[total];
		for (int i = 0 ; i < total ; i++) {
			resultStrArray[i] = partsArray.remove(0) + " (" + (i+1) + "/" + total +")";
		}
		
		return resultStrArray;
	}
	
	private static String fetchPart(String msg, int max_message_size, int level, int order) {
		// check msg, max_message_size, level, order
		
		
		String part = null;
		int postfixSize = 0;
		postfixSize += Integer.toString(order).length();
		postfixSize += Integer.toString((int)Math.pow(10, level) - 1).length();
		postfixSize += 4; // " (/)"
		int actualSize = max_message_size - postfixSize;
		
		int loc = actualSize - 1;
		
		if (actualSize >= msg.length()) {
			part = msg;
		}
		else {
			
			// for debugging!!
			// System.out.println(msg + "   " + loc);
			
			while (msg.charAt(loc) != ' ') {
				loc -= 1;
			}
			part = msg.substring(0, loc + 1);
		}
		
		// eliminate trailing spaces
		loc = part.length() - 1;
		while (part.charAt(loc) == ' ') {
			part = part.substring(0, loc);
			loc -= 1;
		}
		
		return part;
	}
	
	private static boolean isOverflown(int level, int parts) {
		
		if (parts >= Math.pow(10, level)) return true;
		
		return false;
	}

	public static void main(String[] args) {
		String[] testString = new String[]{
			"TextNow is the very first All-IP carrier.", 
			"TextNow",
			"TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier.",
			"TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier. TextNow is the very first All-IP carrier."
		};

		int[] testSize = new int[]{20, 20, 20, 20};
		
		String[] answer = null;
		
		for (int i = 0 ; i < testSize.length ; i++) {
			answer = Solution.generateParts(testString[i], testSize[i]);
			
			System.out.println("-------------------");
			
			for (String s : answer) {
				System.out.println(s);
			}
		
		}
		
		System.out.println(Solution.isOverflown(1, 9));
		System.out.println(Solution.isOverflown(1, 10));

	}

}
