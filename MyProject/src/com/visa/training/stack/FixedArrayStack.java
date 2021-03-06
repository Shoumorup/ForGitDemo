package com.visa.training.stack;

public class FixedArrayStack implements Stack{
	Object arr[];
	int top,size;
	FixedArrayStack(int size)
	{
		this.size=size;
		arr=new Object[this.size];
		top=0;
	}
	
	public void push(Object o)
	{
		try
		{
			arr[top]=o;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Stack is full"); 
		}
		++top;
	}
	
	public Object pop()
	{
		Object obj;
		try
		{
			top--;
			obj=arr[top];			
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Stack Empty");
			return null;
		}
		return obj;
	}
}
