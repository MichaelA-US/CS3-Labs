///(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Set;
import java.util.TreeSet;
import java.util.Arrays;
import static java.lang.System.*;
/**
 * This class implements multiple methods using the two list inputs and
 * gets either the union/intersection/differenceA-B/differenceB-A/Symmetric Difference
 * @author Am10073106
 *
 */
public class MathSet
{
	private Set<Integer> one;
	private Set<Integer> two;

	/**
	 * Main constructor that nstantiates the two treesets
	 */
	public MathSet()
	{
	    one = new TreeSet<Integer>();
	    two = new TreeSet<Integer>();
	}
	/**
	 * Secondary Constructor that takes in the strings and puts the values given into
	 * the treesets
	 * @param The first line
	 * @param The second line
	 */
	public MathSet(String o, String t)
	{
		this();
	    String[] wordsOne = o.split(" "); //Converting it to individual items in an array
	    String[] wordsTwo = t.split(" ");
	    for(String words: wordsOne)
	    {
	      one.add(Integer.parseInt(words)); //Storing it into the treeset
	    }
	    for(String words1: wordsTwo)
	    {
	      two.add(Integer.parseInt(words1));
	    }
	}
	/**
	 * Takes the union (addAll) of the two lists
	 * @return the final list
	 */
	public Set<Integer> union()
	{
	    Set<Integer> temp = new TreeSet<Integer>();
		temp.addAll(one); //Using addAll method
		temp.addAll(two);
	    return temp;
	}
	/**
	 * Takes the intersection (retainAll) of the two lists
	 * @return the final list
	 */
	public Set<Integer> intersection()
	{
	    Set<Integer> temp = new TreeSet<Integer>();
	    temp.addAll(one);
		temp.retainAll(two); //Using retainAll method
        return temp;
	}
	/**
	 * Takes the set difference (removeAll) 
	 * between the two lists in the A - B fashion
	 * @return the final list
	 */
	public Set<Integer> differenceAMinusB()
	{
	    Set<Integer> temp = new TreeSet<Integer>();
	    temp.addAll(one);
		temp.removeAll(two); //Using removeAll method
        return temp;
	}
	/**
	 * Takes the set difference (removeAll)
	 *  between the two lists in the B - A fashion
	 * @return the final list
	 */
	public Set<Integer> differenceBMinusA()
	{
	    Set<Integer> temp = new TreeSet<Integer>();
		temp.addAll(two);
		temp.removeAll(one); //Using removeAll method
		
    return temp;
	}
	/**
	 * Takes the symmetric difference (addAll -> removeAll(intersection)) 
	 * of the two lists
	 * @return the final list
	 */
	public Set<Integer> symmetricDifference()
	{		
	    Set<Integer> temp = union(); //Getting the total
	    temp.removeAll(intersection()); //Removing out the intersections
		return temp;
	}	
	/**
	 * Makes a string of all the methods and
	 * the two lists
	 * @return the string of all methods
	 */
	@Override
	public String toString()
	{
		return "\n\n\n\nSet one " + one + "\n" +	"Set two " + two +  "\n\nUnion - " + union() +
		"\nIntersection - " + intersection() + "\nDifference A-B - " + differenceAMinusB()
		+ "\nDifference B-A - " + differenceBMinusA() + "\nSymmetric Difference - " + symmetricDifference();
				
	}
}