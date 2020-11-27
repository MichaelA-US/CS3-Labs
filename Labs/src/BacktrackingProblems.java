import java.util.*;
public class BacktrackingProblems
{
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
	private static void climbStairsHelper(int steps, String s, int n)
	{
		if(n == steps)
		{
			System.out.println(s.substring(0, s.length()-2));
		}
		else if(n > steps)
		{
			return;
		}
		else
		{
			climbStairsHelper(steps, s + 1 + ", ", n + 1);
			climbStairsHelper(steps, s + 2 + ", ", n + 2);
		}
	}
	public static void campsite(int x, int y)
	{
		if(x == 0 && y == 0)
		{
			System.out.println();
		}
		else
		{
			campsiteHelper(x, y, "", 0, 0);
		}
	}
	private static void campsiteHelper(int x, int y, String s, int c, int c1)
	{
		//c is the x value count for "E"
		//c1 is the y value count for "N"
		//x E
		//y N
		if(x == c && y == c1)
		{
			   System.out.println(s);
		}
		else if(c > x || c1 > y)
		{
			return;
		}
		{
			campsiteHelper(x, y, s + "E ", c + 1, c1);
			campsiteHelper(x, y, s + "N ", c, c1 + 1);
			campsiteHelper(x, y, s + "NE ", c + 1, c1 + 1);
		}
	}
	public static int getMax(List<Integer> nums, int limit)
	{
		if(nums.size() == 0 || limit <= 0)
		{
			return 0;
		}
		else
		{
			ArrayList<Integer> numbers = new ArrayList<Integer>(nums);
			int maxArr[] = new int[nums.size()];
			//System.out.println("");
			getMaxHelper(numbers, limit, 0, maxArr);
			return maxArr[0];
		}
	}
	public static void getMaxHelper(ArrayList<Integer> nums, int limit, int sum, int[] maxArr)
	{
		//System.out.println(nums);
		if(sum > maxArr[0] && sum <= limit)
		{
			maxArr[0] = sum;
		}
		if(nums.size() != 0)
		{
			int num = nums.remove(0);
			getMaxHelper(nums, limit, sum + num, maxArr);
			getMaxHelper(nums, limit, sum, maxArr);
			nums.add(num);
		}
	}
	/**
	 * Return the number of different way you can make change
	 * 
	 * @param amount
	 * @return
	 */
	public static int makeChange(int amount) 
	{
		int currIndex = 4;
		ArrayList<Integer> coins = new ArrayList<>();
		coins.add(1); coins.add(5); coins.add(10); coins.add(25); 
		return makeChangeHelper(coins, currIndex, amount);
	} 
	public static int makeChangeHelper(ArrayList<Integer> coins, int currIndex, int currAmount)
	{
		if(currAmount == 0)
		{
			return 1;
		}
		else if(currIndex <= 0 || currAmount < 0)
		{
			return 0;
		}
		int n1 = makeChangeHelper(coins, currIndex, currAmount - coins.get(currIndex-1));
		n1 += makeChangeHelper(coins, currIndex-1, currAmount);
		return n1;
	}
    public static void makeChangeCoinCount(int amount) 
    {
    	int i = 0;
    	int tot = 0;
    	ArrayList<Integer> coins = new ArrayList<>();
		coins.add(1); coins.add(5); coins.add(10); coins.add(25); 
		ArrayList<Integer> c = new ArrayList<Integer>();
        makeChangeCoinCountHelper(c, coins, amount, tot, i, 0, 0, 0, 0);
    }
    public static void makeChangeCoinCountHelper(ArrayList<Integer> c, ArrayList<Integer> coins, int amount, int tot, int i, int p, int n, int d, int q) {
        if (tot > amount)
        {
        	return;
        }
        if (i >= coins.size()) 
        {
            if (tot == amount)
            {
            	c.add(p); c.add(n); c.add(d); c.add(q);
                System.out.println(c);
                c.clear();
            }
            return;
        }

        makeChangeCoinCountHelper(c, coins, amount, tot, i + 1, p, n, d, q);
        if(coins.get(i) == 1)
        {
        	p++;
        }
        else if(coins.get(i) == 5)
        {
        	n++;
        }
        else if(coins.get(i) == 10)
        {
        	d++;
        }
        else if(coins.get(i) == 25)
        {
        	q++;
        }
        makeChangeCoinCountHelper(c, coins, amount, tot + coins.get(i), i, p, n, d, q);
    }

	public static String longestCommonSub(String a, String b)
	{
	    int s1 = a.length();
	    int s2 = b.length();
	    if(s1 == 0 || s2 == 0)
	    {
	        return "";
	    }
	    else if(a.charAt(s1-1) == b.charAt(s2-1))
	    {
	        return longestCommonSub(a.substring(0,s1 - 1), b.substring(0,s2 - 1)) + a.charAt(s1 - 1);
	    }
	    else
	    {
	        String sub1 = longestCommonSub(a, b.substring(0, s2 - 1));
	        String sub2 = longestCommonSub(a.substring(0, s1 - 1), b);
	        if(sub1.length() > sub2.length())
	        {
	        	return sub1;
	        }
	        else
	        {
	        	return sub2;
	        }
	    }
	}
	public static void main(String args[])
	{
		System.out.println("ClimbStairs(4): ");
		climbStairs(4);
		System.out.println();
		System.out.println("Campsite(2,1): ");
		campsite(2, 1);
		System.out.println();
		System.out.println("GetMax(Arrays.asList(30, 2, 8, 22, 6, 4, 20), 19): ");
		System.out.println(getMax(Arrays.asList(30, 2, 8, 22, 6, 4, 20), 19));
		System.out.println();
        System.out.println("MakeChange(25): ");
		System.out.println(makeChange(25));
        System.out.println("MakeChange(100): ");
		System.out.println(makeChange(100));
		System.out.println();
		System.out.println(" P N D Q ");
		System.out.println("---------");
		makeChangeCoinCount(11);
		System.out.println();
		System.out.println("longestCommonSub(\"ABCDEFG\", \"BGCEHAF\") >>> \"BCEF\"");
		System.out.println(longestCommonSub("ABCDEFG", "BGCEHAF"));
		System.out.println("longestCommonSub(\"12345\", \"54321 21 54321\") >>> \"123\"");
		System.out.println(longestCommonSub("12345", "54321 21 54321"));
	}
}
