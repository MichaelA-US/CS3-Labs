/**
* This class implements multiple methods to define the parts of a car with the
* make, model, and year and its rest.
* @author Michael
*/
public class Part implements Comparable<Part>
{
	private String make, mode, rest;
	private int year;
/**
*	Basic Constructor that initalizes the parts into a list with
* the make model and year.
* @param the line provided for the car information
*/
	public Part(String line)
	{
		String[] list = line.split(" ");
		int len = list.length;
		rest = "";
		for(int i = 0; i < list.length - 3; i++)
		{
			rest += " " + list[i];
		}
		make = list[len-3];
		mode = list[len-2];
		year = Integer.parseInt(list[len-1]);
	}
	/**
	* This class compares the make of the car with the make
	* and checks whether those are equal, and then goes through
	* to check the model and the years of the car provided
	* @param rhs the model of the car to compare
	* @return the compared value
	*/
	//have to have compareTo if implements Comparable
	public int compareTo( Part rhs )
	{
		if(make.equals(rhs.make))
		{
			if(mode.equals(rhs.mode))
			{
				if(year == rhs.year)
				{
					return rest.compareTo(rhs.rest);
				}
				else if(year > rhs.year)
				{
					return 1;
				}
				return -1;
			}
			return mode.compareTo(rhs.mode);
		}
		return make.compareTo(rhs.make);
	}
	/**
	* Returns a string representation of the car
	* @return the car in a string format
	*/
	public String toString()
	{
		return "" + make + " " + mode + " " + year + " " + rest;
	}
}
