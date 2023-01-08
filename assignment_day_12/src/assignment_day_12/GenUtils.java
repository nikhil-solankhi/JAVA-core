package assignment_day_12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class GenUtils {
	public static void printDetails(Collection<?> collection) {
		Iterator<?> itr = collection.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
		for (Object o : collection)
			System.out.println(o);
	}
}