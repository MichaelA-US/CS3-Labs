import java.util.*;
public class PriorityQueue101
{
	public static void main(String args[])
	{
		Queue<Integer> pQueue = new PriorityQueue<>();
		
		pQueue.add(2);
		pQueue.offer(3);
		pQueue.add(6);
		pQueue.add(1);
		pQueue.add(8);
		pQueue.add(4);
		pQueue.add(5);
		pQueue.add(9);
		
		System.out.println("HEAD: " + pQueue.peek());
		System.out.println("HEAD: " + pQueue.element());
		System.out.println(pQueue);
		
		for(Integer num: pQueue)
		{
			System.out.print(num);
		}
		
		while(!pQueue.isEmpty()) 
		{
			System.out.println(pQueue.poll());
		}
	}
}
