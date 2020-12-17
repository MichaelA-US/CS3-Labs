import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * This class implements multiple methods using iterators to remove a certain value
 * from an arraylist.
 * @author Am10073106
 *
 */
public class IteratorRemover
{
	private ArrayList<String> list;
	private String toRemove;
	/**
	 * Basic constructor that initializes the list to use and the variable to remove
	 * @param the list
	 * @param the value to remove from the list
	 */
	public IteratorRemover(String line, String rem)
	{
		setTest(line, rem);
		toRemove = rem;
	}
	/**
	 * Sets the arraylist by implementing the split method that makes each individual 
	 * element in its own index.
	 * @param The line of the list
	 * @param The value to remove from the list
	 */
	public void setTest(String line, String rem)
	{
		String[] stringArray = line.split(" ");
		list = new ArrayList<String>(Arrays.asList(stringArray)); //Converts array to arraylist
	}
	/**
	 * This method removes the value chosen from the arraylist using iterators.
	 */
	public void remove()
	{
		ListIterator<String> here = list.listIterator();
		while(here.hasNext()) //Loops through
		{
			String temp = here.next();
			if(temp.equals(toRemove)) //Checks if it equals remove
			{
				here.remove(); //Removes val
			}
		}
	}
	/**
	 * Prints out the finalized array to a string with [].
	 */
	public String toString()
	{
		return list.toString() + "\n\n";
	}
}