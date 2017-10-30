package com.personagraph;

import java.util.Stack;
import java.util.ArrayList;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}
	
	public int polishExpression(Stack<String> exp) {
		/*
		Input
				 
		2 2
		a1:1 2 + 6 3 + * 1 + 2 /
		b1:1 2 3 4 5 + - * +
		a2:a1 b1 +
		
		Output
		a1:14
		b1:-11
		a2:3
		*/
		
		Stack<String> a1 = new Stack<String>();
		// Stack<String> b1 = new Stack<String>();
		ArrayList<Integer> num = new ArrayList<Integer>();
		
		if (!exp.isEmpty()) {
			
			String ele = null;
			int num1 = 0;
			int num2 = 0;
			int tmpRes = 0;
			int opType = -1;
			
			while (!exp.isEmpty()) {
				ele = exp.pop();
				
				if (this.isNumber(ele)) {
					num.add(Integer.valueOf(ele));
				}
				if (this.isOperator(ele)) {
					num1 = num.remove(0);
					num2 = num.remove(0);
					
					opType = this.getOperatorType(ele);
					
					switch(opType) {
					case 0: // plus
						tmpRes = num1 + num2;
						break;
					case 1: //...
						//...
						break;
					}					
				}
								
			}
			
			return tmpRes;
			
		}
		
		
		return 0;
	}
	
	private boolean isNumber(String in) {
		return true;
	}
	
	private boolean isOperator(String in) {
		return true;
	}
	
	/**
	 * @param op
	 * @return 0 plus, 1 minus, 2 mult, 3 div
	 */
	private int getOperatorType(String op) {
		
		return 0;
	}
	
	public static void main(String[] args) {
		
	}

}
