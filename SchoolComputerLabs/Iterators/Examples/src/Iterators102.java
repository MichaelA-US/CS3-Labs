import java.util.*;

public class Iterators102
{

	public static void main(String[] args)
	{
		List<Integer> list1 = new ArrayList<Integer>();
		
		
		//ArrayList fill 10 Integers [1..10]
		
		for(int i = 0; i < 10; i++)
		{
			//Range = (max - min) + 1
			//Math.random() * (range) + min
			int num = ((int) (Math.random() * 10) + 1);
			list1.add(num);
		}
		
		System.out.println("ArrayList ");
		for(Iterator<Integer> i = list1.iterator(); i.hasNext();)
		{
			System.out.print(i.next() + " ");                                                                                                                                                                                                                                                          
		}

	}

}
