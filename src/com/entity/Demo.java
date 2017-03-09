package com.entity;

public class Demo {

	public static void main(String[] args) {
		int n=7;
		for(int i=1; i<=n;i++)
		{
			int k=1;
			for(int j=i;k<=n;k++)
			{
				if(j==n)
				{
				System.out.print("*");
			
				
				}
				else
				{
					System.out.print(" ");
					j++;
		
				}
				
				
			}
			System.out.println();
		}

	}

}
