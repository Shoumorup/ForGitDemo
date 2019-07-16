package com.visa.training.Collections;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	Scanner sc=new Scanner(System.in);
	public void Demo(Set<String> words)
	{
		while(true)
		{
			System.out.println("Enter 10 unique names");
			String word=sc.nextLine();
			if(!words.add(word)) System.out.println("Duplicate");
			if(words.size()==10) break;
		}
		
		for(String i: words) System.out.println(i);	
	}
	
	public static void main(String[] args) {
		Set<String> words=new HashSet<String>();
		
		SetDemo sd=new SetDemo();
		sd.Demo(words);	
		words=new TreeSet<String>();
		sd.Demo(words);
	}
}
