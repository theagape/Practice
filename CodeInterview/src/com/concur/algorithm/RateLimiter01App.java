/**
 * 
 */
package com.concur.algorithm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author theagape
 *
 */
public class RateLimiter01App {

	/**
	 * 
	 */
	public RateLimiter01App() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int TPS = 1;
		long start;
		
		RateLimiter01 rateLimiter = RateLimiter01.createRateLimiter(TPS);
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		start = System.currentTimeMillis();
		
		for (int i = 0; i < 100 ; i++){
			rateLimiter.getFlag(); // may wait
			executorService.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println("doing by " + Thread.currentThread().getName());
				}
			});
		}
	}

}
