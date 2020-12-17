//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.ArrayList;
import static java.lang.System.*;
/**
 * This class implements methods that sort the dupes found into a list to a set
 * and returns it. It also finds the unique values in a list and puts those in a set
 * and returns it.
 * @author Am10073106
 *
 */
public class UniquesDupes
{
	/**
	 * This method finds the uniques in a list and returns them
	 * @param The list to check for
	 * @return The list with the uniques
	 */
	public static Set<String> getUniques(String input)
	{
		//Treeset automaically removes dupes
		String[] words = input.split(" ");
		Set<String> uniques = new TreeSet<String> (Arrays.asList(words));

		return uniques;
	}
	/**
	 * This method finds the dupes in a list and returns them
	 * @param The list to check for
	 * @return The list with the dupes
	 */
	public static Set<String> getDupes(String input)
	{
		String[] words = input.split(" ");
		Set<String> set = new TreeSet<String>();
		Set<String> list = new TreeSet<String>();
		for(String words1: words) //Loop through tree set
		{
			if(!set.add(words1)) //Check if adding it is false, which means its a duplicate
			{
				list.add(words1); //Adds duplicate to new tree set
			}
		}
		
		return list;
	}
}