package com.visa.training.Java;
import java.util.Random;

class Rectangle{
	private int width,height;
	
	public Rectangle(int height,int width)
	{
		this.height=height;
		this.width=width;
	}
	
	public String getShapeName()
	{
		return "Rectangle";
	}
	
	public double computeArea()
	{
		return (this.height*this.width);
	}
}

public class RectangleApp
{
	public static void main(String[] args) {
		Random r=new Random();
		
		Rectangle c[]=new Rectangle[4];
		for(int i=0;i<4;i++)
		{
			c[i]=new Rectangle(r.nextInt(),r.nextInt());
			System.out.println(c[i].computeArea());
		}
		
	}
}