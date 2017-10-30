/**
 * 
 */
package com.concur.algorithm;

/**
 * @author theagape
 *
 */
public class RateLimiter01 extends Thread {
	
	static boolean flag = false;
	private static int tps;
	private static int waitMillis;

	/**
	 * 
	 */
	public RateLimiter01() {
		// TODO Auto-generated constructor stub
	}
	
	public RateLimiter01(int tps) {
		this.tps = tps;
		this.waitMillis = 1000 / tps;
	}
	
	public static RateLimiter01 createRateLimiter(int tps) {
		return new RateLimiter01(tps);
	}
	
	public static int getWaitMillis() {
		return RateLimiter01.waitMillis;
	}
	
	synchronized public static void getFlag() {
		
		if (RateLimiter01.flag == false) {
			RateLimiter01.flag = true;
			try {
				Thread.sleep(RateLimiter01.waitMillis);
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
		else {
			// ??????
		}
		
		RateLimiter01.flag = false;
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
