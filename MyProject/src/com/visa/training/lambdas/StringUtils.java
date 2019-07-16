package com.visa.training.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@FunctionalInterface
interface SortChecker{
	int eChecker(String s1,String s2);
}

@FunctionalInterface
interface TwoStringPredicate{
	int betterTwoStringPredicate(String s1,String s2);
}

public class StringUtils {
	
	public static int eChecker(String s1,String s2)
	{
		return ((s1.contains("e")&& !s2.contains("e"))?-1:1);
	}
	
	public static String betterString(String s1,String s2,TwoStringPredicate t) 
	{
		return (t.betterTwoStringPredicate(s1, s2)>0?s1:s2);
	}
	
	public static <T> List<T> allMatches(List<T> words,Predicate<T> match)
	{
		List<T> result=new ArrayList<>();
		for(T w:words)
		{
			if(match.test(w)) result.add(w);
		}
		return result;
	}
	
	public static List<String> transformedList(List<String> words,Function<String,String> mapper)
	{
		List<String> result=new ArrayList<>();
		for(String w:words) result.add(mapper.apply(w));
		return result;
	}
	
	public static <T,R> List<R> transformedListGeneric(List<T> input,Function<T,R> mapper)
	{
		List<R> result=new ArrayList<>();
		for(T w:input) result.add(mapper.apply(w));
		return result;
	}
	
	public static void main(String[] args) {
		String words[]= {"this","is","a","set","of","eaining","words","to","eort","arrays"};
	    List<Integer> nums=Arrays.asList(1,10,100,1000,10000);
		
	    Arrays.sort(words,(s1,s2)->s1.length()-s2.length());
	    System.out.println("Array after sorting in order of length:"+Arrays.asList(words));
	    
	    Arrays.sort(words,(s1,s2)->s2.length()-s1.length());
	    System.out.println("Array after sorting in order of reverse length:"+Arrays.asList(words));
	    
	    Arrays.sort(words,(s1,s2)->s1.charAt(0)-s2.charAt(0));
	    System.out.println("Array after sorting in order of first character:"+Arrays.asList(words));
	    
	    Arrays.sort(words,StringUtils::eChecker);
	    System.out.println("Array after sorting in order of first character being e or not:"+Arrays.asList(words));
	
	    System.out.println(StringUtils.betterString(words[0],words[1],(s1,s2)->s1.length()-s2.length()));
	    System.out.println(StringUtils.allMatches(Arrays.asList(words),s->s.length()%2==0));
	    System.out.println(StringUtils.allMatches(nums,n->n>500));
	    
	    System.out.println(StringUtils.transformedList(Arrays.asList(words),s->s.toUpperCase()));
	    System.out.println(StringUtils.transformedListGeneric(Arrays.asList(words),s->s.length()));	    
	}
}
