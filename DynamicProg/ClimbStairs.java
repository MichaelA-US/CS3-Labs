import java.util.*;
import java.io.*;
public class ClimbStairs 
{
	static int count;
	public static void main(String args[]) throws FileNotFoundException
	{
		/**(dat file)
		5
		1
		3
		7
		20
		27
		 */
		Scanner scan = new Scanner(new File("steps.dat"));
		int num = scan.nextInt();
		for(int i = 0; i < num; i++)
		{
			climbStairs(scan.nextInt());
			System.out.println(count);
			count = 0;
		}
	}
	/**
	 * (Totally not backtracking stairs but with a count var lmao)
	* Method that climbs stairs depending on number of steps taken and finds all combinations.
	* @parm steps - amount of steps to take at the start
	*/
	public static void climbStairs(int steps)
	{
		if(steps == 0)
		{
			System.out.println();
		}
		else
		{
			climbStairsHelper(steps, "", 0);
		}
	}
	/**
	 * (Totally not backtracking stairs but with a count var lmao)
	* Climb stairs helper method that recursively adds each steps and make sure that the last comma is not printed.
	*@param steps - steps given
	*@param s - string to append stairs to
	*@param n - keeps track of number of stairs
	*/
	private static void climbStairsHelper(int steps, String s, int n)
	{
		if(n == steps)
		{
			count++;
		}
		else if(n > steps)
		{
			return;
		}
		else
		{
			climbStairsHelper(steps, s + 3 + ", ", n + 3);
			climbStairsHelper(steps, s + 2 + ", ", n + 2);
			climbStairsHelper(steps, s + 1 + ", ", n + 1);
		}
	}
}
