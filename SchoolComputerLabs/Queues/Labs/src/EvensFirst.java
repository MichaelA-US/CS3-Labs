import java.util.LinkedList;
import java.util.Queue;
/**
 * This class implements methods that change a queue to have the
 * evens first in the order
 * @author Am10073106
 *
 */
public class EvensFirst
{
	private Queue<Integer> nums1;
	private Queue<Integer> nums2;
	/**
	 * Basic constructor that initalizes the queues that stores the evens and odds
	 */
	public EvensFirst()
	{
		nums1 = new LinkedList<Integer>();
		nums2 = new LinkedList<Integer>();
	}
	/**
	 * Recursively stores the even nums into the queue,
	 * with the odds in another queue
	 * @param nums
	 * @return
	 */
	public Queue<Integer> putEvensFirst(Queue<Integer> nums)
	{
		int temp = nums.poll();
		if(temp % 2 == 0)
		{
			//System.out.println(temp);
			nums1.offer(temp);
		}
		else if(temp % 2 != 0)
		{
			//System.out.println(temp);
			nums2.offer(temp);
		}
		while(nums.size() != 0)
		{
			//System.out.println(nums);
			//System.out.println(nums2);
			putEvensFirst(nums);
		}
		return nums1;
	}
	/**
	 * Intersects the two queues with the evens and odds
	 * @return
	 */
	public Queue<Integer> combine()
	{
		nums1.addAll(nums2);
		return nums1;
	}
}
