package com.visa.training.stack;
import java.util.Random;

class StackUser {
		
		public void fill(Stack s)
		{
			Random r=new Random();
			for(int i=0;i<11;i++)
			{
				int value=r.nextInt(10)+1;
				Integer integer=new Integer(value);
				s.push(integer);
				System.out.println("Pushed: "+value);
			}
		}
		
		public void empty(Stack s)
		{
			for(int i=0;i<13;i++) System.out.println(s.pop());
		}
}

public class StackApp
{
	public static void main(String[] args) {
		FixedArrayStack f=new FixedArrayStack(10);
		StackUser s=new StackUser();
		
		s.fill(f);
		s.empty(f);
	}
}
