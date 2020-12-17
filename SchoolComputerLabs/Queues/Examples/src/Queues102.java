import java.util.LinkedList;
import java.util.Queue;

public class Queues102
{
	public static void main(String args[])
	{
		Queue<String> names;
		names = new LinkedList<String>();
		
		names.add("David");
		names.add("Nick");
		System.out.println(names.add("Raymond"));
		System.out.println(names.add("Nhat-The"));
		System.out.println(names.add("Ari"));
		
		System.out.println("\nNumber of elements: " + names.size());
		
		System.out.println("Printing queue with loops: ");
		
		//for(int i = 0; i < names.size(); i++)
		//{
		//	System.out.println(i + " . " + names.get(i));
		//}
		//^^ Can't use basic for loop with queues
		
		for(String name : names)
		{
			System.out.println(name);
		}
		System.out.println();
		
		///////////////////////////////////////////////
		
		System.out.print("The element at 0: ");
		System.out.println(names.peek());
		
		System.out.println("Dequeing until isEmpty == false: ");
		while(!names.isEmpty())
		{
			System.out.println("Removing " + names.remove() + " from head of the queue.\nEmpty queue: " + names.isEmpty() + "\n");
		}
		
		System.out.println("\n" + names + "\n");
		
		System.out.print("The element at 0: ");
		System.out.println(names.peek());
		
		
		//Remove throws an exceptions (NoSuchElement) if there are no items in the queue
		//names.remove();
	}
}
