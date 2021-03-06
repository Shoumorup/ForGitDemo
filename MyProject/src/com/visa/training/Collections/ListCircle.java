package com.visa.training.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.visa.training.Java.Circle;

public class ListCircle {
	public static void main(String args[])
	{
		List<Circle> l=new LinkedList<Circle>();
		Random r=new Random();
		while(true)
		{
			double x=r.nextDouble();
			if(x<0.01) break;
			l.add(new Circle(x));					
		}
		System.out.println("Size is: "+l.size());
		for(Circle c:l)
		{
			System.out.println(c.computeArea());
		}
		Iterator<Circle> i=l.iterator();
		while(i.hasNext())
		{
			Circle c=i.next();
			if(c.getRadius()<0.5) i.remove();
		}
		System.out.println("Size is: "+l.size());
	}
}
