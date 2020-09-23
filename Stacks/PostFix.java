import java.util.Stack;
import java.util.*;
/**
 * This class implements methods in order to be able
 * to solve reverse polish notation aka postfix
 */
public class PostFix
{
	private Stack<Double> stack;
	private String expression;
	/**
	 * Basic constructor of the class
	 */
	public PostFix()
	{
		stack = new Stack<Double>();
	}
	/**
	 * Secondary constructor that intalizes
	 * the stack object and sets
	 * the expression for the setExpression method
	 * @param the postfix string
	 */
	public PostFix(String exp)
	{
		stack = new Stack<Double>();
		setExpression(exp);
	}
	/**
	 * Sets the expression variable
	 * @param the postfix string
	 */
	public void setExpression(String exp)
	{
		expression = exp;
	}
	/**
	 * Determines whether the user
	 * wants to do addition, subtraction,
	 * mult, divis
	 * @param the two numbers, and its operator
	 * @return the numbers performed with that operation
	 */
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

	/**
	 * Solves the expression by using a stack
	 * to pop the values and calculate the 
	 * values in the right order
	 */
	public void solve()
	{
			for (int i = 0; i < expression.length(); i++) //Loops through the expression
			{
				char c = expression.charAt(i); //Checks each letter in the expression
				if (c == '+' || c == '-' || c == '*' || c == '/') //Checks what operation is being used
				{
					double temp1 = stack.pop();
					double temp = stack.pop();
					stack.push(calc(temp,temp1,c)); //Calculates the values given in the expression
				}
				else if (c ==' ') //Checks if empty
				{
					continue;
				}
				else
				{
					String num = Character.toString(c);
					int num1 = Integer.parseInt(num); //Changes it to a number
					stack.push((double) num1); //Pushs the number with the operation performed
				}
			}

	}
	/**
	 * Returns the string of the number
	 * that was created through the 
	 * operations of both numbers given originally
	 */
	public String toString()
	{
		return expression + " = " + stack.peek(); 
	}

}
