import java.util.Stack;

public class StackProbs
{
	public Stack<Integer> doubleUp(Stack<Integer> nums)
	{
		if (nums.empty())
		{
			return nums;
		}
		int num = nums.pop();
		doubleUp(nums);
		nums.push(num);
		nums.push(num);
		return nums;
	}
	
	public Stack<Integer> posAndNeg(Stack<Integer> nums)
	{
		Stack<Integer> neg = new Stack<>();
		Stack<Integer> pos = new Stack<>();

		while (!nums.empty())
		{
			int num = nums.pop();
			if (num < 0)
			{
				neg.push(num);
			}
			else
			{
				pos.push(num);
			}
		}

		Stack<Integer> posNeg = new Stack<>();
		while (!neg.empty())
		{
			posNeg.push(neg.pop());
		}
		while (!pos.empty())
		{
			posNeg.push(pos.pop());
		}
		return posNeg;
	}
	
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
			nums.push(pushN.pop());
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
	
	public String reverseVowels(String str)
	{
		Stack<Character> vowels = new Stack<>();
		for(int i = 0 ;i < str.length(); i++)
		{
			if (str.charAt(i) == 'a' || str.charAt(i) == 'e' || str.charAt(i) == 'i' || str.charAt(i) == 'o' || str.charAt(i) == 'u')
			{
				vowels.push(str.charAt(i));
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
				str1 += str.charAt(i);
			}

		}
		return str1;
	}
}
