package com.visa.training.Java;
import java.util.Random;

class ChemicalElement {
	int atomicNumber;
	String symbolicName,fullName;
	static boolean metal[];
	
	static
	{
		metal=new boolean[120];
		for(int i=0;i<120;i++) metal[i]=false;
		metal[13]=true;
		metal[49]=true;
		metal[50]=true;
		metal[81]=true;
		metal[82]=true;
		metal[83]=true;
		metal[113]=true;
		metal[114]=true;
		metal[115]=true;
		metal[116]=true;		
	}
	
	
	ChemicalElement(int atomicNumber,String symbolicName,String fullName)
	{
		this.atomicNumber=atomicNumber;
		this.symbolicName=symbolicName;
		this.fullName=fullName;
	}
	
	public boolean isAlkaliMetal()
	{
		switch(this.atomicNumber)
		{
			case 3:
			case 11:
			case 19:
			case 37:
			case 55:
			case 87: return true;
		}
		return false;
	}
	
	public boolean isTransitionMetal()
	{
		return(((this.atomicNumber>=21 && this.atomicNumber<=31) || (this.atomicNumber>=39 && this.atomicNumber<=48) || (this.atomicNumber>=72 && this.atomicNumber<=80) || (this.atomicNumber>=104 && this.atomicNumber<=112))?true:false);
	}
	
	public boolean isMetal()
	{
		return ChemicalElement.metal[this.atomicNumber];
	}	
	
	public boolean equals(Object o)
	{
		ChemicalElement c=(ChemicalElement)o;
		if(o instanceof ChemicalElement)
		{
			if(this.atomicNumber==c.atomicNumber) return true;
		}
		return false;
	}
}

public class ChemicalElementApp{
	
	public static void main(String args[])
	{
		ChemicalElement obj[] = new ChemicalElement[4];
		int atomicNumber[]= {8,30,31,19};
		String symbolicName[]= {"O","Zn","Ga","K"};
		String fullName[]= {"Oxygen","Zinc","Gallium","Potassium"};
		
		for(int i=0;i<4;i++)
		{
			obj[i]=new ChemicalElement(atomicNumber[i],symbolicName[i],fullName[i]);
			System.out.println("Is "+obj[i].atomicNumber+" Alkali metal? "+obj[i].isAlkaliMetal());
			System.out.println("Is "+obj[i].atomicNumber+" Transition metal? "+obj[i].isTransitionMetal());
			System.out.println("Is "+obj[i].atomicNumber+" metal? "+obj[i].isMetal());
		}
		
	    ChemicalElement c1=new ChemicalElement(19,"K","Potassium");
	    for(int i=0;i<4;i++)
	    {
	    	if(obj[i].equals(c1)) System.out.println("It's a match");
	    	else System.out.println("Not a match");
	    	
	    	if(obj[i]==c1) System.out.println("MATCH");
	    	else System.out.println("Duh!");
	    }	    	    
	}
}
