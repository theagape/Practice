package com.datatron.coding;

import java.util.ArrayList;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<ArrayList<Integer>> getStepArrays(int[] input) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		    
		    
		// check parameters input ==> null? violating rules?
		// return error code... null
		if (input == null) {
			return result;
		}
		if (input.length < 1) {
			return result;
		}
		
		/* == Second Try ==
		1. get total number of subsets <-- num of ele in input
		2. loop by the total number of subsets
		    2.1 transcode current order --> binary from 0 -- (TNS-1)
		    2.2 participate each element of input according to the binary '0', '1'
		    2.3 add the array list into result
		3. return the result
		*/
		
		// find out the total number of subset
		int numSubsets = (int) Math.pow(2, input.length);
		
		ArrayList<Integer> subset = null;
		String binary = null;
		int temp = 0;
		int bin = 0;
		
		for (int i = 0 ; i < numSubsets ; i++) {
			subset = new ArrayList<Integer>();
			
			// building binary (String) form of current subset
			temp = i;
			binary = "";
			
			for (int c = 0 ; c < input.length; c++) {
				bin = temp % 2;
				binary = bin + binary;
				temp = temp / 2;
			}
			
			// filling the subset accroding to the binary form
			for (int e = 0 ; e < binary.length() ; e++) {
				if (binary.charAt(e) == '1') {
					subset.add(input[e]);
				}
			}
			
			// adds the subset into result set
			result.add(subset);
		}
		
		return result;
		
		/* == First Try ==
		result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> array = null;
		if (step == 1) {
		    // will generate array with each element(int) of input
		    for (int e : input) {
		        array = new ArrayList<Integer>();
		        array.add(e);
		        result.add(array);
		    }
		    
		    return result;
		    
		}
		
		
		for (int i = 0 ; i < input
		*/
		
	}

	public static void main(String[] args) {
		int[] input = {1, 2, 3};
		
		ArrayList<ArrayList<Integer>> subsets = Solution.getStepArrays(input);
		System.out.println(subsets.toString());
	}

}
