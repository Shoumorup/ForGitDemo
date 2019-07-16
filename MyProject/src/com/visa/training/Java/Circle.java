package com.visa.training.Java;

public class Circle{
	double radius;
	public double getRadius()
	{
		return this.radius;
	}
	public Circle(double radius)
	{
		this.radius=radius;
	}
	
	public String getShapeName()
	{
		return "Circle";
	}
	
	public double computeArea()
	{
		return (3.14*this.radius*this.radius);
	}
}

