package com.lambdaExpr;

public interface MyInterface{

	//SAM
	void add(int i,int j);
	
	default void display()
	{
		System.out.println("MyInterface.display()");
	}
}


