import java.util.*;
	class Table
	{
		private LinkedList<Integer>[] table;
		
		public Table(int size)
		{
			table = new LinkedList[size];
			for(int i = 0; i < table.length; i++)
			{
				table[i] = new LinkedList<Integer>();
			}
		}
		
		public void add(int val)
		{
			table[val % (table.length + 1)].add(val);
		}
		
		@Override
		public String toString()
		{
			String output = "";
			for(LinkedList<Integer> thing: table)
			{
				for(Object word: table)
				{
					System.out.print(thing + " -> ");
				}
				System.out.println();
			}
			
			return output;
		}
	}
	public class HashTable103
	{
		public static void main(String args[])
		{
			Table t = new Table(10);
			t.add(3);
			t.add(7);
			t.add(11);
			t.add(31);
			t.add(17);
			t.add(15);
			System.out.println(t);
		}
	}
