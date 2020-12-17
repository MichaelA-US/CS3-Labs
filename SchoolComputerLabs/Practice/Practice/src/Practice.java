import java.util.*;
public class Practice
{
	public static void main(String args[])
	{
		String x = "rstuv";
		LinkedList<Character> q = new LinkedList<Character>();
		for(char let: x.toCharArray())
		{
			q.add(let);
		}
		q.remove();
		System.out.println(q);
		Stack<Integer> stk = new Stack<Integer>();
		stk.push(5);
		stk.push(7);
		stk.push(3);
		stk.push(2);
		System.out.println(stk);
	}
}
