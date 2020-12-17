//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import static java.lang.System.*;
/**
 * This class implements the OddEvenSets class and uses
 * test cases to make sure all the methods are functioning
 * properly
 * @author Am10073106
 *
 */
public class OddRunner
{
	public static void main( String args[] ) throws IOException
	{
		Scanner newFile = new Scanner(new File("oddevent.dat")); //Reading the .dat file
    while(true) //Looping through .dat
    {
      try
      {
         new OddEvenSets(newFile.nextLine()); //Initalizing new .dat object
      }
      catch(Exception e)
      {
        return;
      }
    }
				
	}
}