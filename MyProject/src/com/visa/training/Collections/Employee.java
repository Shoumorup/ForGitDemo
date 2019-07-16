package com.visa.training.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Employee {
	public static void main(String[] args) {
		Map<String,String> emp=new HashMap<String,String>();
		emp.put("E1234","Steve Jobs");
		emp.put("E2345","Bill Gates");
		emp.put("E3456","Larry Ellison");
		emp.put("E4567","Jeff Bezos");
		emp.put("E8765","Mark Zuckerberg");
		emp.put("E6789","Larry Page");
		
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<3;i++)
		{
			System.out.println("Enter an employee ID:");
			String id=sc.nextLine();
			if(emp.get(id)!=null) System.out.println(emp.get(id));
			else System.out.println("Employee record doesn't exist");
		}
	}
}
