package com.visa.training.Concurrency;

import java.util.concurrent.Callable;

public class CallablePrimerSearch implements Callable<Integer>{
	
	long start,end;
	int count;
	volatile boolean resultReady;
	
	public CallablePrimerSearch(long start,long end)
	{
		this.start=start;
		this.end=end;
	}
	
	private boolean isPrime(long num)
	{
		for(int i=2;i<=Math.sqrt(num);i++)
		{
			if(num%i==0) return false;
		}
		return true;
	}
	
	@Override
	public Integer call()
	{
		for(long i=start;i<=end;i++)
		{
			if(isPrime(i)) count++;
		}
		resultReady=true;
		return count;
	}
}
