
import java.util.LinkedList;
import java.util.Scanner;
/**
 * Class that defines the HashTable
 * @author Michael
 *
 */
public class HashTable
{
	private LinkedList[] table;
	/**
	 * Constructor that loads the size into the hashTable
	 * and adds the linked lists to it
	 */
	public HashTable( )
	{
		table = new LinkedList[10];
		for(int i = 0; i < table.length; i++)
		{
			table[i] = new LinkedList();
		}
	}
	/**
	 * Adds the obj to the hashTable
	 * makes sure that it doesn't already exists
	 * @param obj - obj to add
	 */
	public void add(Object obj)
	{
		//System.out.println("add");
		int i = obj.hashCode();
		if(!table[i].contains(obj))
		{
			table[i].add(obj);
		}
	}
	/**
	 * Returns a string representation of the hashTable without
	 * any brackets or commas for some reason
	 * @return the output
	 */
	public String toString()
	{
		String output="HASHTABLE\n";
		for(int i = 0; i < table.length; i++)
		{
			String tab = table[i].toString().replaceAll(",", "");
			tab = tab.replaceAll("]", "");
			tab = tab.substring(1, tab.length());
			//tab = tab.replaceAll("[", "");
			output += "bucket " + i + ": " + tab;
			output += "\n";
		}
		return output;
	}
}