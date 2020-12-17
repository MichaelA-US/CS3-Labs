import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Sets102
{

	public static void main(String[] args)
	{
		
		//Parsing words from a String to a Set via an Array and Collection (ArrayList)
		
		//.spit of the String class will use <space> as the delimiter to separate elements. "," and "-" are other common delimiters.
		String[] words = "memes are dreams".split(" ");
		
		//.asList() acts as a bridge between array-based and collection-based APIs
		//Use Collection.toArray() to go the other way
		Set<String> set = new TreeSet<String>(Arrays.asList(words));
		System.out.println(set + "\n");
		
		
		Iterator<String> it;
		it = set.iterator();
		while(it.hasNext())
		{
			System.out.println(it.next());
		}
		
		System.out.println("\n");
		
		for(String d: set)
			System.out.println(d);
		
		
	}

}
