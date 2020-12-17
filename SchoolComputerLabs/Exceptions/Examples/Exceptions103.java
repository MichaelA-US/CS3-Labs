import java.util.Scanner;

public class Exceptions103
{

	public static void main(String[] args)
	{
		DivideTester2 test = new DivideTester2();
		Scanner keyboard = new Scanner(System.in);
		String ans;

		do
		{
			test.getNumbers(); // get two numbers
			//We still get a default divide by zero exception here
			//test.divide(); // calculate the quotient
			//test.printResults(); // print the results
			
			//Now it is the responsibility of the calling method, main, to handle the exceptions.
			try
			{
				test.divide(); // calculate the quotient
				test.printResults(); // print the results
			}
			catch(ArithmeticException e)
			{
				System.out.println("You can't divide by 0!\n");
			}
			
			System.out.print("Continue[Y/N]?");
			ans = keyboard.nextLine();
			System.out.println();
		} while (ans.equalsIgnoreCase("y"));
	}
}

class DivideTester2
{
	private int dividend;
	private int divisor;
	private int quotient;

	public void getNumbers()
	{
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the Dividend-->");
		dividend = keyboard.nextInt();
		System.out.print("Enter the Divisor-->");
		divisor = keyboard.nextInt();
		System.out.println();
	}
	/*
	 * Marking a method with the throws keyword the JVM to pass any exceptions
	 * that occur within the method onto the calling method so they can be 
	 * handled there.
	 */
	public void divide() throws ArithmeticException
	{

			quotient = dividend / divisor; 

	}

	public void printResults()
	{
		System.out.println(dividend + " / " + divisor + " = " + quotient);
		System.out.println();
	}

}
