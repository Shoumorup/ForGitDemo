package com.visa.training.Concurrency;

public class RunnablePrimerSearch implements Runnable{
	
	long start,end;
	int count;
	volatile boolean resultReady;
	
	public RunnablePrimerSearch(long start,long end)
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
	public void run()
	{
		for(long i=start;i<=end;i++)
		{
			if(isPrime(i)) count++;
		}
		resultReady=true;
	}
}
