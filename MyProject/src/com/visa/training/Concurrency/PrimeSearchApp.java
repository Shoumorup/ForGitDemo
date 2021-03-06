package com.visa.training.Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeSearchApp {
	
	public static void main(String[] args) throws Exception{
		RunnablePrimerSearch w1= new RunnablePrimerSearch(1, 10000);
		RunnablePrimerSearch w2= new RunnablePrimerSearch(10000, 25000);
		/* STYLE 1
		Thread t1 = new Thread(w1);
		Thread t2 = new Thread(w2);
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		System.out.println("Primes between 1 and 10000 are: "+w1.count);
		System.out.println("Primes between 10000 and 25000 are: "+w2.count);*/
		
		ExecutorService pool = Executors.newFixedThreadPool(4);
		/*
		pool.execute(w1);
		pool.execute(w2);
		
		while(!(w1.resultReady && w2.resultReady))
		{
			Thread.sleep(200);
		}
		System.out.println("Primes between 1 and 10000 are: "+w1.count);
		System.out.println("Primes between 10000 and 25000 are: "+w2.count);*/
		
		CallablePrimerSearch c1 = new CallablePrimerSearch(1,100000);
		CallablePrimerSearch c2 = new CallablePrimerSearch(100000, 250000);
		
		Future<Integer> r1 = pool.submit(c1);
		Future<Integer> r2 = pool.submit(c2);
		
		System.out.println("Primes between 1 and 100000 are: "+r1.get());
		System.out.println("Primes between 100000 and 250000 are: "+r2.get());
		
		pool.shutdown();
		
	}

}
