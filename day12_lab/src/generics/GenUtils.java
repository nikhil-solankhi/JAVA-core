package generics;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import fruits.Fruit;
import fruits.Mandarine;
import fruits.Mango;
import fruits.Orange;

public class GenUtils {
	/*
	 * Write a method to print elements from ANY collection of ANY type eg :
	 * AL/LL/Vector | HS/LHS/TS : String/Customer/Date...
	 */
	public static void printDetails(Collection<?> collection) {
		// implicit itr
//		for(Object e : collection)
//			System.out.println(e);
		// explicit Iterator
		Iterator<?> itr = collection.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
	}

	// Can above method be written using T ? YESS
	public static <T> void printDetails2(Collection<T> collection) {
		/*
		 * for (T t : collection) System.out.println(t);
		 */
		// Iterator
		Iterator<T> itr = collection.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
	}
	// 1.2 Write a method to return square root of sum of numbers passed in any
	// Collection.
	public static double findSqRtOfSum(Collection<? extends Number> collection)
	{
		double sum=0;
		for (Number o : collection)
			sum += o.doubleValue();
		return Math.sqrt(sum);
			
	}
//	1.3 Write a method to display tastes of all the fruits in the basket(basket : List)
//	Test cases : Mango basket , Mandarine Basket ....
	public static void displayTastes(List<? extends Fruit> basket)
	{
//		for(Fruit f : basket)
//			f.taste();
		//OR can be done with the Iterator
		Iterator<? extends Fruit> itr=basket.iterator();
		while(itr.hasNext())
			System.out.println(itr.next().taste());
//		basket.add(new Mango());
//		basket.add(new Orange());
//		basket.add(new Mandarine());
//		basket.add(new Fruit());
//		basket.add(new Object());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
