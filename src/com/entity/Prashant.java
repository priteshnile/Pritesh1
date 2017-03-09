package com.entity;

public class Prashant {

	public static void main(String[] args) {
		int n=4;
		for(int i=n;i>0;i++)
		{
			for(int j=0;j>4;j++)
			{
				if(j>=i)
				{
					System.out.print("*");
				}
				else
				{
					System.out.print(" ");
				}
				System.out.println();
			}
		}

	}

}
