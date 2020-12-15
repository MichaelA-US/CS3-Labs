/**
 * Rod cutting class that uses Dynamic Programming to find max rev for a certain length of
 * rod given the values for the amount of sections the rod is split into
 * Ex. length 4 = $8 but length 2 and length 2 = $5 x 2 = $10
 * @author Michael
 *
 */
public class RodCutting 
{
	public static void main(String args[])
	{
		System.out.println(cutRod(4, new int[] {0, 1, 5, 8, 9}));
		System.out.println(cutRod(8, new int[] {0, 1, 5, 8, 9, 10, 17, 17, 20}));
	}
	/**
	 * Constructs the given mathemetical algo from pdf by 
	 * "rn=max(r1+rn-1,r2+rn-2,...,rn-1+r1,pi)"
	 * Basically loops through the length of the rod and compares our current max value
	 * to the next max value we obtain of the rod for the permutations
	 * @param n - length of rod
	 * @param price - all the prices for each rod length
	 * @return
	 */
    public static int cutRod(int n, int price[]) 
    { 
        int val[] = new int[n+1]; 
        val[0] = 0; 
        for (int i = 1; i <= n; i++) 
        { 
            double max_val = Double.NEGATIVE_INFINITY; 
            for (int j = 0; j < i; j++)
            {
                max_val = Math.max(max_val, price[j+1] + val[i-j-1]); 
            }
            val[i] = (int) max_val; 
        } 
  
        return val[n]; 
    } 
    
}
