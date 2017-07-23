package com.hp.test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardPolicy;
import java.util.concurrent.TimeUnit;

import com.crawl.core.util.SimpleThreadPoolExecutor;
import com.crawl.core.util.ThreadPoolMonitor;

public class TestThreadPoolMonitor extends Thread{
	
	

	@Override
	public void run() {
		int i=0;
		while(true){
			System.out.println("start....");
			try {
				i++;
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(i>10)
				break;
		}
		
	}

	public static void main(String[] args) {
		 TestThreadPoolMonitor testThreadPoolMonitor = new TestThreadPoolMonitor();
//	     testThreadPoolMonitor.start();
		/**
	     * 代理测试线程池
	     */
		ThreadPoolExecutor proxyTestThreadExecutor;
		 proxyTestThreadExecutor = new SimpleThreadPoolExecutor(20, 20,
	                0L, TimeUnit.MILLISECONDS,
	                new LinkedBlockingQueue<Runnable>(10000),
	                "proxyTestThreadExecutor");
		 proxyTestThreadExecutor.execute(testThreadPoolMonitor);
		 
		
	     ThreadPoolMonitor threadPoolMonitor = new ThreadPoolMonitor(proxyTestThreadExecutor, "ProxyTestThreadPool");
	     threadPoolMonitor.run();
	}


}
