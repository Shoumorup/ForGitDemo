package com.visa.training.Concurrency;

public class Consumer extends Thread{
	
	Buffer buffer;
	public Consumer(Buffer buffer)
	{
		super();
		this.buffer = buffer;
	}
	
	@Override
	public void run()
	{
		for(int i=0;i<10;i++) 
		{
			int x = buffer.consume();
		}
	}

}
