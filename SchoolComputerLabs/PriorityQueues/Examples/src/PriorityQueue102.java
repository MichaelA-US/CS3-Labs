import java.util.*;

public class PriorityQueue102
{
	public static void main(String[] args)
	{
		Student michael = new Student(10011, "Michael", 11, 3.5);
		Student ari = new Student(10042, "Ari", 9, 3.5);
		Student nick = new Student(10069, "Nick", 10, 3.5);
		Queue<Student> pQueue = new PriorityQueue<>();
		pQueue.offer(michael);
		pQueue.offer(ari);
		pQueue.offer(nick);
		
		System.out.println(pQueue);
		int count = 1;
		while(!pQueue.isEmpty()) 
		{
			System.out.println(pQueue);
			System.out.println("\nDequeue " + count++ + " --> " + pQueue.poll());
		}
	}
}
