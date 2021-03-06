package com.visa.training.Concurrency;

public class Buffer {
	
	int data;
	boolean available = false;//If true, Consumer can go ahead
	
	public synchronized void produce(int newData)
	{	
		while(available)
		{
			try
			{
				this.wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Producer producing -->" + newData);
		this.data = newData;
		this.available = true;
		this.notify();
	}
	
	public synchronized int consume() {
		while(!available)
		{
			try
			{
				this.wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		System.out.println("Consumer consuming -->" + data);
		this.available =false;
		this.notify();// To notify that the boolean has been changed.
		return this.data;		
	}
}
