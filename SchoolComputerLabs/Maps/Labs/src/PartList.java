import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;
/**
 * This class implements methods to read the file and print out
 * a string representation of it
 * @author Michael
 *
 */
public class PartList
{
	private TreeMap<Part, Integer> partsMap;
	/**
	 * Basic constructor that initalizes the map to a treemap
	 */
	public PartList()
	{
		partsMap = new TreeMap<Part, Integer>();
	}
	/**
	 * Secondary constructor that receives the file
	 * and puts it into the map itself
	 * @param fileName - the file to read
	 */
	public PartList(String fileName)
	{
		this();
		try
		{
			//add code here to read from the file
			//and add Parts to the map
			Scanner scan = new Scanner(new File(fileName));
			while(scan.hasNext())
			{
				Part p = new Part(scan.nextLine());

				if(partsMap.get(p) == null)
				{
					partsMap.put(p, 0);
				}
				partsMap.put(p, partsMap.get(p) + 1);
			}



		}
		catch( IOException e )  //Most specific exceptions must be listed 1st
		{
			out.println(e);
		}
		catch( RuntimeException e )
		{
			out.println(e);
		}
		catch( Exception e )
		{
			out.println(e);
		}
		finally
		{
			//no code needed here
		}
	}
	/**
	 * Prints out the map in the way that
	 * they want it
	 */
	public String toString()
	{
		String output="";
		for(Part parts : partsMap.keySet())
		{
			output += parts + " - " + partsMap.get(parts) + "\n";
		}
		return output;
	}
}