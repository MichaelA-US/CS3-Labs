//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
/**
 * This class implements the MathSet class and has 
 * test cases to check that all the methods
 * are functioning properly
 * @author Am10073106
 *
 */
public class MathSetRunner
{
	public static void main( String args[] ) throws IOException
	{
		
		Scanner newFile = new Scanner(new File("mathsetdata.dat")); //reading .dat file
    while(newFile.hasNextLine()) //Looping through .dat
    {
      try
      {
         MathSet m = new MathSet(newFile.nextLine(), newFile.nextLine()); //Initalizing new object
         System.out.print(m); //Printing toString
      }
      catch(Exception e)
      {
        return;
      }
    }
				
	}
}
