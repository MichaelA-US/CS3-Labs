import java.util.Stack;
import java.util.*;

public class PostFix
{
	private Stack<Double> stack;
	private String expression;

	public PostFix()
	{
		stack = new Stack<Double>();
	}

	public PostFix(String exp)
	{
		stack = new Stack<Double>();
		setExpression(exp);
	}

	public void setExpression(String exp)
	{
		expression = exp;
	}

	public double calc(double one, double two, char op)
	{
		if (op=='+')
		{
			return (double) one + two;
		}
		else if (op=='-')
		{
			return (double)one - two;
		}
		else if (op=='*')
		{
			return (double)one * two;
		}
		else
		{
			return (double)one / two;
		}
	}


	public void solve()
	{
			for (int i = 0; i < expression.length(); i++)
			{
				char c = expression.charAt(i);
				if (c == '+' || c == '-' || c == '*' || c == '/')
				{
					double temp1 = stack.pop();
					double temp = stack.pop();
					stack.push(calc(temp,temp1,c));
				}
				else if (c ==' ')
				{
					continue;
				}
				else
				{
					String num = Character.toString(c);
					int num1 = Integer.parseInt(num);
					stack.push((double) num1);
				}
			}

	}

	public String toString()
	{
		return expression + " = " + stack.peek();
	}

}