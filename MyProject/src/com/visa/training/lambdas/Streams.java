package com.visa.training.lambdas;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;

public class Streams {
	public static void printWithTwoSpaces(String s)
	{
		System.out.println("  "+s);
	}
	public static void main(String[] args) {
		List<String> words=Arrays.asList("this","is","a","set","of","eaining","words","to","dort","arrays");
		//Printing using Explicit Lambda
		words.stream().forEach(s->System.out.println("  "+s));
		
		//Printing using a Method reference
		words.stream().forEach(Streams::printWithTwoSpaces);
		
		//Producing lists with map
		words.stream().filter(s->s.length()%2==0).forEach(System.out::println);
	
		//Concatenating upper case strings
		System.out.println(words.stream().reduce("",(s1,s2)->s1.toUpperCase()+s2.toUpperCase()));
	
	    //Concatenate using map then reduce
		System.out.println(words.stream().map(String::toUpperCase).reduce("",String::concat));
		
		//Concatenate with commas
		System.out.println(words.stream().reduce((s1,s2)->s1.concat(","+s2)).get());
		Random r=new Random();
		double randDoubles[]=new double[100];		
		for(int i=0;i<100;i++) randDoubles[i]=r.nextDouble();
		
		//Print Square roots
		DoubleStream.of(randDoubles).map(Math::sqrt).forEach(System.out::println);
		//Print Square roots in parallel
		DoubleStream.of(randDoubles).parallel().map(Math::sqrt).forEach(System.out::println);
		//Verifying
		//System.out.println(DoubleStream.of(randDoubles).map(Math::sqrt).allMatch(DoubleStream.of(randDoubles).parallel().map(Math::sqrt)));
	}
}
