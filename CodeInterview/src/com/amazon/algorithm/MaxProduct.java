package com.amazon.algorithm;

public class MaxProduct {

	public MaxProduct() {
	}
	
	public int maxInteger(int[] array) {
		int max = Integer.MIN_VALUE;
		
		for (int i = 0 ; i < array.length ; i++) {
			if (max < array[i]) {
				max = array[i];
			}
		}
		
		return max;
	}
	
	/**
	 * Gets 3 most positives
	 */
	public int[] maxPositives(int[] array) {
		int[] max = {-1, -1, -1};
		int[] tempArray = new int[array.length];
		
		for (int i = 0 ; i < array.length ; i++) {
			tempArray[i] = array[i];
		}
		
		int maxi;
		for (int count = 0 ; count < 3 ; count++) {
			
			maxi = -1;
			for (int i = 0 ; i < tempArray.length ; i++) {
				if (max[count] < tempArray[i]) {
					max[count] = tempArray[i];
					maxi = i;
				}
			}
			tempArray[maxi] = Integer.MIN_VALUE;
			
		}
		
		return max;
	}
	
	/**
	 * Gets 1 most positive and 2 most negatives
	 */
	public int[] max1Pos2Neg(int[] array) {
		int[] max = {0, 0, 0};
		int[] tempArray = new int[array.length];
		
		max[0] = this.maxInteger(array);
		
		/**
		 * [1] Gets most positive number
		 */
		for (int i = 0 ; i < array.length ; i++) {
			tempArray[i] = array[i];
		}
		
		/**
		 * [2] Gets most 2 negatives
		 */
		int maxi;
		for (int count = 1 ; count < 3 ; count ++) {
			
			maxi = -1;
			for (int i = 0 ; i < array.length ; i++) {
				if (tempArray[i] < 0 && max[count] > tempArray[i]) {
					max[count] = tempArray[i];
					maxi = i;
				}
			}
			tempArray[maxi] = Integer.MAX_VALUE;
			
		}
		
		return max;
	}

	public static void main(String[] args) {
		
		MaxProduct maxPro = new MaxProduct();
		int max1 = -1;
		int max2 = -1;
		
		int[] input = {-10, -20, 3, 3, 3};
		
		/*
		 * Gets 3 most positives and product
		 */
		int[] pos = maxPro.maxPositives(input);
		max1 = pos[0] * pos[1] * pos[2];
		
		/*
		 * Gets 1 most positive and 2 negatives, and product
		 */
		int[] pnn = maxPro.max1Pos2Neg(input);
		max2 = pnn[0] * pnn[1] * pnn[2];
		
		/*
		 * Gets greater among the products
		 */
		if (max1 > max2) {
			System.out.println("Maximum product is " + max1);
		}
		else {
			System.out.println("Maximum product is " + max2);
		}

	}

}
