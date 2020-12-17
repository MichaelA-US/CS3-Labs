import java.io.*;
import java.util.*;
/**
 * This class implement dynamic programming problem for bottles
 * @author Michael
 *
 */
public class Bottles 
{
	static int numBottles;
	static int drinkableVolume;
	static ArrayList<String> bottlesList;
	static int[] array;
	public static void main(String args[]) throws FileNotFoundException
	{
		String[] bottles;
		Scanner scan = new Scanner(new File("bottles.dat"));
		int num = scan.nextInt();
		scan.nextLine();
		for(int i = 0; i < num; i++)
		{
			bottles = scan.nextLine().split(" ");
			bottlesList = new ArrayList<>(Arrays.asList(bottles));
			int vol1 = Integer.parseInt(bottlesList.remove(1));
			//System.out.println(vol1);
			int vol2 = 0;
			int vol3 = 0;
			numBottles = Integer.parseInt(bottlesList.get(0));
			System.out.println(dynamProgBottles(bottlesList, vol1, vol2, vol3));
			//System.out.println(fixDynam(bottlesList, bottles, vol1, vol2, vol3));
			System.out.println(bottlesList); //(check arraylist)
		}
	}
	/**
	 * Dynamic Programming problem that takes in a sequence of a number of bottles and
	 * checks how much you can drink between all of them making sure to not drink from
	 * 2 adj bottles
	 * @param bottles - the arraylist of bottles with their fluids
	 * @param v1 - the drinkable volume
	 * @param v2 - the previous drinkable volume
	 * @param v3 - the best vol 
	 * @return max drink vol possible
	 */
	public static int dynamProgBottles(ArrayList<String> bottles, int v1, int v2, int v3)
	{
		for (int i = 1; i <= numBottles-1; i++)
		{
//			//Before Updating each Adjacent (Mainting v2 as previous v1 keeping two adj)
//			System.out.print(v1 + " ");
//			System.out.print(": " + v2 + "|");
			if(v1 > v2)
			{
				v3 = v1; //Storing drinkable volume (first)
				v1 = v2 + Integer.parseInt(bottles.get(i)); //getting next drinkable vol 
				v2 = v3; //resetting to next drinkable vol
			}
			else
			{
				v3 = v2; //Storing previous drinkable volume of v1
				v1 = v2 + Integer.parseInt(bottles.get(i)); //getting next drinkable vol 
				v2 = v3; //resetting to next drinkable vol
			}
			//After Updating each Adjacent (Mainting v2 as previous v1 keeping two adj)
			System.out.print(v1 + " ");
			System.out.print(": " + v2 + "|");
		}
		//System.out.println(); //formatting for prev adj
		if(v1 > v2)
		{
			return v1;
		}
		return v2;
	}
//	public static int fixDynam(ArrayList<String> bot, String[] bottles, int v1, int v2, int v3)
//	{
//		bottles = new String[numBottles-1];
//		
//		for (int i = 1; i <= numBottles-1; i++)
//		{
//			if(Integer.parseInt(bottles[i]) > Integer.parseInt(bottles[i+1]))
//			{
//				v3 = Integer.parseInt(bottles[i]);
//				bottles[i] = "" + (Integer.parseInt(bottles[i+1]) + Integer.parseInt(bot.get(i)));
//				bottles[i+1] = "" + v3;
//			}
//			else
//			{
//				v3 = Integer.parseInt(bottles[i+1]);
//				bottles[i] = "" + (Integer.parseInt(bottles[i+1]) + Integer.parseInt(bot.get(i)));
//				bottles[i+1] = "" + v3;
//			}
//			System.out.println(Arrays.toString(bottles));
//		}
//		if(Integer.parseInt(bottles[bottles.length-1]) > Integer.parseInt(bottles[bottles.length-2]))
//		{
//			return Integer.parseInt(bottles[bottles.length-1]);
//		}
//		return Integer.parseInt(bottles[bottles.length-2]);
//		
//	}
}

