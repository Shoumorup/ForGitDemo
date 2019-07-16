package com.visa.training.lambdas;

@FunctionalInterface
interface TwoElementPredicate
{
	public <T> int betterTwoElementPredicate(T o1,T o2);
}
public class ElementUtils {
	
	public static <T> T betterElement(T o1,T o2,TwoElementPredicate tw)
	{
		return (tw.betterTwoElementPredicate(o1,o2)>0?o1:o2);
	}
	
	public static void main(String args[])
	{
	    System.out.println(ElementUtils.betterElement("fsdbvjdfbvjh","fvbkjj",(s1,s2)->s1.length()-s2.length()));

	}
}
