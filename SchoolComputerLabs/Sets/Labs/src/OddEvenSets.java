//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

/**
 * This class implements a couple of methods that take two lists and 
 * sorts them into odd and even sets with treesets
 * @author Am10073106
 *
 */
public class OddEvenSets
{
	private Set<Integer> odds;
	private Set<Integer> evens;
/**
 * Main constructor that initalizes the two (odd/even) treesets
 */
	public OddEvenSets()
	{
    odds = new TreeSet<Integer>();
    evens = new TreeSet<Integer>();
	}
	/**
	 * Basic constructor that takes in the line and
	 * stores it into an array of multiple elements and back
	 * into the two treesets organizing it by both even and odds
	 * @param line
	 */
	public OddEvenSets(String line)
	{
    this();
    String[] words = line.split(" "); //Storing elements into an array
    
    for(int i = 0; i < words.length; i++) //Looping through
    {
      if((Integer.parseInt(words[i]) % 2 == 0)) //If Even
      {
        evens.add(Integer.parseInt(words[i])); //Add to even
      }
      else //If odd
      {
        odds.add(Integer.parseInt(words[i])); //Add to odd
      }
      
    }
    System.out.println(this);
	}
	/**
	 * Making a string to print out the odds and even treesets
	 */
	@Override
	public String toString()
	{
		return "ODDS : " + odds + "\nEVENS : " + evens + "\n\n";
	}
}