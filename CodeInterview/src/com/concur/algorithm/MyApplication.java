package com.concur.algorithm;

public class MyApplication {
	
	
	public MyApplication() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 50;
		
		// SomeService[] app = new SomeService[num];
		Runnable app = new AppThread();
		Thread[] threads = new Thread[num];
		
		for (int i = 0 ; i < num ; i++) {
			threads[i] = new Thread(app);
		}
		for (int i = 0 ; i < num ; i++) {
			threads[i].start();
		}
	}

}
