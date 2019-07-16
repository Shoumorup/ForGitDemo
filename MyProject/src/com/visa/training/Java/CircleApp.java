package com.visa.training.Java;

import java.util.Random;

public class CircleApp
{
	public static void main(String[] args) {
		Random r=new Random();
		
		Circle c[]=new Circle[4];
		for(int i=0;i<4;i++)
		{
			c[i]=new Circle(r.nextInt());
			System.out.println(c[i].computeArea());
		}
		
	}
}