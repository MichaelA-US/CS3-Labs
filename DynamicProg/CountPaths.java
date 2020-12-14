import java.util.*;
import java.io.*;
/**
 * Class that implements a method that takes in a 2d array of rows and cols and finds all paths up
 * to the location
 * @author Michael
 *
 */
public class CountPaths 
{
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("paths.dat"));
		int num = scan.nextInt();
		for(int i = 0; i < num; i++)
		{
			System.out.println(numPaths(scan.nextInt(), scan.nextInt()));
		}
	}
	/**
	 * Num paths method that takes in the rows and cols and populates the 2d array with 1s, then
	 * loop through each rectangular indices in a given cell and account for right and down, right,
	 * and down then storing back into array to avoid repeats 
	 * @param r - rows
	 * @param c - cols
	 * @return max num paths
	 */
	public static int numPaths(int r, int c)
	{
	    int[][] paths = new int[r + 1][c + 1];
		if(r == 0 || c == 0)
		{
			return 0;
		}
	    
	        for (int i = 1; i <= r; i++)
	        {
	        	paths[i][1] = 1;
	        }
	        for (int j = 1; j <= c; j++) 
	        {
	        	paths[1][j] = 1;
	        }

	        
	        for (int i = 2; i <= r; i++) 
	        {
	            for (int j = 2; j <= c; j++) 
	            {
	            	//System.out.print("x");
	            	paths[i][j] = paths[i-1][j-1] + paths[i - 1][j] + paths[i][j - 1];
	            }
	        }
//			for(int i = 0; i < paths.length; i++)
//			{
//				for(int j = i; j < paths[0].length; j++)
//				{
//					System.out.print(paths[i][j] + " ");
//				}
//				System.out.println();
//			}
	        return paths[r][c];
	}
}
