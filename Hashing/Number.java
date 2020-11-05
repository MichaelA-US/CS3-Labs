/**
 * Class that defines the Number object
 * @author Michael
 *
 */
public class Number
{
	private int theValue;
	/**
	 * Basic constructor that initalizes the value of the obj
	 * @param value - its value
	 */
	public Number(int value)
	{
		theValue = value;
	}	
	/**
	 * Returns the value of the obj
	 * @return - the value
	 */
	public int getValue()
	{
		return theValue;
	}
	/**
	 * Compares the obj to thevalue to see if they are 
	 * equal
	 * @return - true or false
	 */
	public boolean equals(Object obj)
	{
		return theValue == ((Number) obj).theValue;
	} 
	/**
	 * Hashcode of the value is definined by modulus diving it by 10
	 * @return its hashcode
	 */
	public int hashCode()
	{
		return theValue % 10;
	}
	/**
	 * Return a string representation of the value
	 * @return the string
	 */
	public String toString()
	{
		return "" + theValue;
	}	
}