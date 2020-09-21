import java.util.*;
import java.util.Stack;
public class Runner
{
	public static void main (String args[])
	{
		StackProbs test = new StackProbs();
		int[] nums = {1,3,5,0,-1};
		int[] nums1 = {2, 9, -4, 3, -1, 0, -6};
		int[] nums2 = {7, 23, -7, 0, 22, -8, 4, 5};
		System.out.println(test.doubleUp(makeStack(nums)));
		System.out.println(test.posAndNeg(makeStack(nums1)));
		System.out.println(test.shiftByN(makeStack(nums2), 3));
		System.out.println(test.reverseVowels("hello how are you"));
	}
	public static Stack<Integer> makeStack(int[] nums)
	{
		StackProbs probs = new StackProbs();
		Stack<Integer> stack = new Stack<>();
		for (int num : nums)
		{
			stack.push(num);
		}
		return stack;
	}
}
