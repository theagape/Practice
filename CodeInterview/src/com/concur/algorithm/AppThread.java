/**
 * 
 */
package com.concur.algorithm;

/**
 * @author theagape
 *
 */
public class AppThread implements Runnable {

	/**
	 * 
	 */
	public AppThread() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		SomeService service = new SomeService();
		
		System.out.println(service.foo());
	}

}
