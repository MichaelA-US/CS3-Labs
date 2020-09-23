import java.util.Stack;
/**
 * This class implements multiple methods
 * in order to fundamentally understand
 * the purpose of a stack and its uses
 */
public class StackProbs
{
    /**
     * Doubles a stacks values twice 
     * from its original state
     * ex. 1,2,3 --> 1,1,2,2,3,3
     * @param the stack with numbers
     * @return the stack with dubbed numbers
     */
	public Stack<Integer> doubleUp(Stack<Integer> nums)
	{
		if (nums.empty())
		{
			return nums;
		}
		int num = nums.pop();
		doubleUp(nums); //Recursively add the values
		nums.push(num); //Double it
		nums.push(num);
		return nums;
	}
	/**
	 * This class uses two stacks
	 * in order to sort a stack
	 * by its negative numbers than its
	 * positive numbers
	 * @param the stack with numbers
	 * @return the posNeg stack
	 */
	public Stack<Integer> posAndNeg(Stack<Integer> nums)
	{
		Stack<Integer> neg = new Stack<>();
		Stack<Integer> pos = new Stack<>();

		while (!nums.empty())
		{
			int num = nums.pop();
			if (num < 0)
			{
				neg.push(num); //Adds neg numbers to neg stack
			}
			else
			{
				pos.push(num); //Pos to pos stack
			}
		}

		Stack<Integer> posNeg = new Stack<>();
		while (!neg.empty())
		{
			posNeg.push(neg.pop()); //Combines the stacks
		}
		while (!pos.empty())
		{
			posNeg.push(pos.pop()); //Combines the stacks
		}
		return posNeg;
	}
	/**
	 * Takes a stack and a number and shifts the stack
	 * over by the number given
	 * @param the stack, and the number to shift it over
	 * @return the shifted over stack
	 */
	public Stack<Integer> shiftByN(Stack<Integer> nums, int n)
	{
		Stack<Integer> pushN = new Stack<>();
		while(!nums.isEmpty())
		{
			pushN.push(nums.pop());
		}
		Stack<Integer> k = new Stack<>();
		for (int i = 0; i < n; i++)
		{
			k.push(pushN.pop());
		}
		while(!pushN.isEmpty())
		{
			nums.push(pushN.pop()); //Pops the values in order to shift them
		}
		for (int i = 0; i < n; i++)
		{
			pushN.push(k.pop());

		}
		for (int i = 0; i < n; i++)
		{
			nums.push(pushN.pop());

		}
		return nums;
	}
	/**
	 * Reverse the vowels in a given string using a stack
	 * @param the string to reverse
	 * @return the reversed string
	 */
	public String reverseVowels(String str)
	{
		Stack<Character> vowels = new Stack<>();
		for(int i = 0 ;i < str.length(); i++)
		{
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u')
			{
				vowels.push(str.charAt(i)); //Adds the vowels to the stack
			}

		}
		String str1 = "";
		for(int i = 0 ;i < str.length(); i++)
		{
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i)== 'i' || str.charAt(i)== 'o' || str.charAt(i) == 'u')
			{
				str1 += vowels.pop();
			}
			else
			{
				str1 += str.charAt(i); //Adds the reversed vowels
			}

		}
		return str1;
	}
}
