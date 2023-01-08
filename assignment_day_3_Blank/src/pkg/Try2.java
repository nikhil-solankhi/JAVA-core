package pkg;

import java.util.Scanner;

public class Try2 {

	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in)) {
			int a = sc.nextInt();
			Validate.ValidateValue(a);
			System.out.println(" in try but after validation");

		} catch (CustomExp e) {
			System.out.println(e.getStackTrace());
			System.out.println(e.getMessage());
			System.out.println("exception handled");
		}finally {
			System.out.println("in finally block");
		}
		System.out.println("continue");
	}
}

class Validate {
	public static void ValidateValue(int a) throws CustomExp{
		if(a>20)
			throw new CustomExp("value is greater than 20");
		
		System.out.println("number is less 20");
	}
}

class CustomExp extends Exception{
	public CustomExp(String str){
		super(str);
	}	
}
