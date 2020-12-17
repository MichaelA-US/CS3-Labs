import java.util.LinkedList;
import java.util.Queue;

public class Queues101
{
	public static void main(String args[])
	{
		//A queue is an interface
		Queue<Integer> queue;
		
		//Linked list implements the queue interface (MIDTERM)
		queue = new LinkedList<Integer>();
		
		//Elements are added to the tail(back)
		//To add an element is to "enqueue" it
		queue.add(42);
		queue.add(90);
		queue.add(45);
		queue.add(31);
		
		System.out.println(queue);
		
		//Removing elements in first in, first out order (FIFO)
		//Remove() RETURNS the element removed, which is to "dequeue" it
		queue.remove();
		
		System.out.println(queue);
		queue.remove();
		queue.remove();
		
		queue.add(1);
		
		System.out.println(queue);
		
		
	}
}
