import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;
/**
 * This class implements method that are capable of using an iterator to an
 * arraylist and replacing certain values with the value chosen
 * @author Am10073106
 *
 */
public class IteratorReplacer
{
	private ArrayList<Integer> list;
	private int toRemove, replaceWith;
	/**
	 * Basic constructor that initalizes the list of values to change, the one to remove
	 * and the one to replace the removed value with
	 * @param The line of values
	 * @param The value to remove
	 * @param The value to replace
	 */
	public IteratorReplacer(String line, String rem, String rep)
	{
		list = new ArrayList<Integer>();
		setEmAll(line, rem, rep); //Initalizing
		toRemove = Integer.parseInt(rem); //Storing rem -> toRemove
		replaceWith = Integer.parseInt(rep); //Storing rep -> replaceWith
	}
	/**
	 * This method sets the array by splitting the values into individual elements
	 * and then storring it into an arraylist.
	 * @param The line of values
	 * @param The value to remove
	 * @param The value to replace
	 */
	public void setEmAll(String line, String rem, String rep)
	{
		String[] stringArray = line.split(" "); //Stores elements
		for(int i = 0; i < stringArray.length; i++) //Loops through
		{
			list.add(Integer.parseInt(stringArray[i])); //Puts elements to arraylist
		}
	}
	/**
	 * This method replaces the value chosen in the beginning with the value that was
	 * removed in the arraylist.
	 */
	public void replace()
	{
		ListIterator<Integer> here = list.listIterator();
		while(here.hasNext()) //Loops through
		{
			if(here.next().equals(toRemove)) //Checks values to remove
			{
				here.set(replaceWith); //Replaces vals with set() method
			}
		}
	}
	/**
	 * This method prints out the arraylist in string form [].
	 */
	public String toString()
	{
		return list.toString()+"\n\n";
	}
}