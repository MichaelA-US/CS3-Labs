import java.util.*;

public class Iterators101
{
	public static void main(String args[])
	{
		List<Integer> list1 = new ArrayList<Integer>();
		List<Double> list2 = new LinkedList<Double>();
		Set<Integer> list3 = new HashSet<Integer>();
		Set<Double> list4 = new TreeSet<Double>();
		
		//ArrayList fill 10 Integers [1..10]
		
		for(int i = 0; i < 10; i++)
		{
			//Range = (max - min) + 1
			//Math.random() * (range) + min
			int num = ((int) (Math.random() * 10) + 1);
			list1.add(num);
		}
		
		//LinkedList fill 10 Double [0.0 .. 0.99]
		
		for(int i = 0; i < 10; i++)
		{
			double num = ((int) (Math.random() * 100) / 100.00);
			list2.add(num);
		}
		
		//HashSet fill 10 Integers [2..12]
		
		for(int i = 0; i < 10; i++)
		{
			int num = ((int) (Math.random() * 11) + 2);
			list3.add(num);
		}
		
		//TreeSet fill 10 Doubles [0.0 .. 1.99]
		
		for(int i = 0; i < 10; i++)
		{
			double num = (((int) (Math.random() * 100) / 100.00) + 1);
			list4.add(num);
		}
		
		Iterator<Integer> here1 = list1.iterator(); // ArrayList
		Iterator<Double> here2 = list2.iterator(); // LinkedList
		Iterator<Integer> here3 = list3.iterator(); // HashSet
		Iterator<Double> here4 = list4.iterator(); // TreeSet
		
		
		System.out.println("ArrayList: ");
		while(here1.hasNext())
		{
			System.out.print(here1.next() + " ");
		}
		
		System.out.println("\nLinkedList: ");
		while(here2.hasNext())
		{
			System.out.print(here2.next() + " ");
		}
		
		System.out.println("\nHashSet: ");
		while(here3.hasNext())
		{
			System.out.print(here3.next() + " ");
		}
		
		System.out.println("\nTreeSet: ");
		while(here4.hasNext())
		{
			System.out.print(here4.next() + " ");
		}
		
	}
}
