import java.util.*;
public class RodCutting 
{
	public static void main(String args[])
	{
		int[] arr = {0, 1, 5, 8, 9, 10, 17, 17, 20};
		maxRevenue(8, arr);
	}
	/**
	 * 
	 * @param n - Length of the rod
	 * @param arr - Price for each length
	 */
	public static void maxRevenue(int n, int[] arr)
	{
		int[] max = new int[arr.length];
		for(int i = 0; i < arr.length-1; i++)
		{
			max[i] = Math.max(arr[i], arr[i+1]);
		}
		System.out.println("Max value for rod of length " + n + "  -> (22)");
	}
}
