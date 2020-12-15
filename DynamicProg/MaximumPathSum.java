import java.util.*;
import java.io.*;
/**
 * This class implements a method that goes through a triangle and checks for the largest'
 * value in each subsection and adds them to a max value (Using Dynamic programming)
 * @author Michael
 *
 */
public class MaximumPathSum 
{
	static int sum;
	static int best;
	static int[][] triangle;
	static String[] temp;
	public static void main(String args[]) throws FileNotFoundException
	{
		List<String[]> row = new ArrayList<String[]>();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(new File("triangle.txt"));
		while(scan.hasNext())
		{
			String[] nums = scan.nextLine().split(" ");
			row.add(nums);
			//System.out.println(Arrays.toString(nums));
		}
		scan.close();
		scan = new Scanner(new File("triangle.txt"));
		//System.out.println(row);
		triangle = new int[row.size()][ row.get(row.size()-1).length];
		for(int i = 0; i < triangle.length; i++)
		{
			String[] n = scan.nextLine().split(" ");
			//System.out.println(Arrays.toString(n));
			for(int j = 0; j < n.length; j++)
			{
				triangle[i][j] = Integer.parseInt(n[j]);
				//System.out.println(triangle[i][j] + " ");
			}
			//System.out.println();
		}
		//System.out.println(row.size());
		//System.out.println(row.get(row.size()-1).length);
		System.out.println(max(triangle, triangle.length, row.get(row.size()-1).length));
	}
	/**
	 * Max method that iteratively goes through the triangle starting at the bottom and compares
	 * each value in the section and adds it back into the triangle at the cell and
	 * Continually builds the table until we hit the max sum
	 * @param triangle - the triangle to go through
	 * @param row - rows of triangle
	 * @param col - cols of triangle
	 * @return
	 */
	public static int max(int triangle[][], int row, int col)
	{
		for (int i = row - 2; i >= 0; i--) 
		{
			for (int j = 0; j <= i; j++)
			{
				triangle[i][j] += Math.max(triangle[i+1][j], triangle[i+1][j+1]); 
			}
		}
		return triangle[0][0];
	}
}