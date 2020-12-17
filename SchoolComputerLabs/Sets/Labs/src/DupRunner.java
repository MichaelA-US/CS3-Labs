//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import static java.lang.System.*;
import java.util.*;
/**
 * This class uses the UniquesDupes class and implements test cases to test its methods
 * @author Am10073106
 *
 */
public class DupRunner
{
	public static void main( String args[] )
	{
		UniquesDupes test = new UniquesDupes();
		System.out.println("Original List: a b c d e f g h a b c d e f g h i j k");
		System.out.print("Uniques: ");
		System.out.print(test.getUniques("a b c d e f g h a b c d e f g h i j k"));
		System.out.print("\nDupes: ");
		System.out.print(test.getDupes("a b c d e f g h a b c d e f g h i j k"));
		
		System.out.println();
		System.out.println();
		
		UniquesDupes test1 = new UniquesDupes();
		System.out.println("Original List: one two three one two three six seven one two");
		System.out.print("Uniques: ");
		System.out.print(test1.getUniques("one two three one two three six seven one two"));
		System.out.print("\nDupes: ");
		System.out.print(test1.getDupes("one two three one two three six seven one two"));
		
		System.out.println();
		System.out.println();
		
		UniquesDupes test2 = new UniquesDupes();
		System.out.println("Original List: 1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6");
		System.out.print("Uniques: ");
		System.out.print(test2.getUniques("1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6"));
		System.out.print("\nDupes: ");
		System.out.print(test2.getDupes("1 2 3 4 5 1 2 3 4 5 1 2 3 4 5 6"));
		
	}
}