/**
 * 
 */
package com.concur.algorithm;

import java.util.Date;

/**
 * @author theagape
 *
 */
public class SomeService {

	/**
	 * 
	 */
	public SomeService() {
		// TODO Auto-generated constructor stub
	}
	
	public synchronized String foo() {
		String result = null;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		result = new Date(System.currentTimeMillis()).toString();
		
		return result;
	}

}
