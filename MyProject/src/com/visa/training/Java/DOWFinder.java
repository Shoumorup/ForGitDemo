package com.visa.training.Java;
import java.io.*;
import java.util.Scanner;

public class DOWFinder {
	
	String findDOW(int day,int month,int year)
	{
		String days[]= {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		int daysInAMonth[]= {31,28,31,30,31,30,31,31,30,31,30,31};
		int totalNoOfDays=0;
		totalNoOfDays= (year-1900)*365;
		int leaps=(year-1900)/4;
		
		if(year%4==0 && (month==1 || month==2)) leaps--;
		totalNoOfDays+=leaps;
		for(int i=0;i<month-1;i++) totalNoOfDays+=daysInAMonth[i];
		
		totalNoOfDays+=day;
		return days[totalNoOfDays%7];
	}
	
	public static void main(String args[])
	{
		DOWFinder dw=new DOWFinder();
		int day,month,year;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter date,month,year");
		day=sc.nextInt();
		month=sc.nextInt();
		year=sc.nextInt();
		
		String resultDay=dw.findDOW(day,month,year);
		System.out.println(resultDay);
	}
}
