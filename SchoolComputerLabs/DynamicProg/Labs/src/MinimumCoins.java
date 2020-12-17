import java.util.*;
import java.io.*;
public class MinimumCoins
{
//	4 - num times
//	11 - val to get
//	1 3 5
//	7
//	2 4 10
//	12
//	2 5 6
//	106
//	1 3 12 25
	public static void main(String args[]) throws FileNotFoundException
	{
		Scanner scan = new Scanner(new File("coins.dat"));
		int num = scan.nextInt();
		for(int i = 0; i < num; i++)
		{
			int totalSum = scan.nextInt();
			scan.nextLine();
			String[] line = scan.nextLine().split(" ");
			int[] nums = new int[line.length];
			int[] dpNums = new int[line.length + 1];
			for(int j = 0; j < line.length; j++)
			{
				nums[j] = Integer.parseInt(line[j]);
			}
			System.out.println(totalSum);
			System.out.println(Arrays.toString(nums));
			minCoinsDP(1, dpNums, nums);
			if(totalSum <= dpNums.length)
			{
				System.out.println(dpNums[totalSum]);
			}
			
		}
	}
	/**
	 * 
	 * @param S - total sum
	 * @param vals
	 * @return
	 */
	public static void minCoinsDP(int S, int[] dpVals, int[] vals)
	{
		if(S >= dpVals.length)
		{
			return;
		}
		else
		{
			int min = Integer.MIN_VALUE;
			for(int i = 0; i < vals.length; i++)
			{
				if(S - vals[i] >= 0)
				{
					int n = dpVals[S - vals[i]];
					if(n == Integer.MAX_VALUE)
					{
						continue;
					}
					min = Math.max(dpVals[S - vals[i]] + 1, min);
					//System.out.println(min);
				}
				dpVals[S] = min;
				//System.out.println(Arrays.toString(dpVals));
				minCoinsDP(S+1, dpVals, vals);
			}
		}
	}
}
