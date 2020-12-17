import java.util.*;

public class ListIterator101
{
	private static List<Integer> convertToIntegerList(String input)
	{
		//An easy way to transfer elements from a String to an Array
		
		//.split of the String class
		String[] stringArray = input.split(" ");
		List<Integer> numList = new ArrayList<Integer>();
		
		for(int i = 0; i < stringArray.length; i++)
		{
			numList.add(Integer.parseInt(stringArray[i]));
		}
		
		return numList;
	}
	
	public static void printForwardsThenBackwards(List<Integer> inputList)
	{
		ListIterator<Integer> here = inputList.listIterator();
		
		System.out.println("ArrayList ");
		
		while(here.hasNext())
		{
			System.out.println(here.next() + " ");
		}
		System.out.println();
		while(here.hasPrevious())
		{
			System.out.println(here.previous() + " ");
		}
	}
	
	public static void main (String args[])
	{
		String input = "15 25 23 18 21 16";
		List<Integer> list = convertToIntegerList(input);
		printForwardsThenBackwards(list);
	}
}
