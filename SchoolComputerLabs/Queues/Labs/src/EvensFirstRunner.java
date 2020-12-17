import java.util.LinkedList;
import java.util.Queue;
public class EvensFirstRunner
{
	public static void main(String args[])
	{
		Queue<Integer> nums1 = new LinkedList<Integer>();
		nums1.add(3);
		nums1.add(5);
		nums1.add(4);
		nums1.add(17);
		nums1.add(6);
		nums1.add(83);
		nums1.add(1);
		nums1.add(84);
		nums1.add(16);
		nums1.add(37);
		EvensFirst test = new EvensFirst();
		test.putEvensFirst(nums1);
		System.out.println(test.combine());
	}
}
