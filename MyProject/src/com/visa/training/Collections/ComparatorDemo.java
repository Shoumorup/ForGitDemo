package com.visa.training.Collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class StringLengthComparator implements Comparator<String>
{
	public int compare(String s1,String s2)
	{
		return s1.length()-s2.length();
	}
}

public class ComparatorDemo {
	public static void main(String[] args) {
		String words[]= {"this","is","a","set","of","training","words","to","sort","arrays"};
		List<String> listword=Arrays.asList(words);
		
		System.out.println("Before Sorting:"+listword);
		Collections.sort(listword,new StringLengthComparator());
		System.out.println("After Sorting:"+listword);
	}
}
