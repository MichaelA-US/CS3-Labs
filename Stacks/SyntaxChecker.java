  
import java.util.*;
import java.util.ArrayList;
/**
 * This class implements multiple methods
 * to check whether a string is properly
 * has a closed bracket etc paired with an open one
 */
public class SyntaxChecker
{
	private String exp;
	private Stack<Character> symbols;
	/**
	 * Default constructor
	 * that initalizes the stack and expression
	 */
	public SyntaxChecker()
	{
		exp = "";
		symbols = new Stack<Character>();
	}
	/**
	 * Second constructor that sets
	 * the given string to check to the
	 * expression
	 * @param the string given
	 */
	public SyntaxChecker(String s)
	{
		this();
		exp = s;
		setExpression(s);
	}
	/**
	 * Sets the expression of the string
	 * given to check its 'syntax'
	 * @param the string given
	 */
	public void setExpression(String s)
	{
		for(char c : exp.toCharArray())
		{
			if(c ==  '{' || c == '(' || c == '<' || c == '[') //If open
			{
				symbols.push(c); //Push to stack
			}
			else if(!symbols.isEmpty() && c ==  '}' || c == ')' || c == '>' || c == ']') //If close
			{
				symbols.pop(); ///Pop to stack
			}
			else
			{
				symbols.push(c);
				symbols.pop();
			}
		}
	}
	/**
	 * Checks if the expression is empty
	 * and has no elements
	 * @return whether it is or is not empty - (true/false)
	 */
	public boolean checkExpression()
	{
		if(symbols.isEmpty())
		{
			return false;
		}
		return true;
	}

	//write a toString
	/**
	 * Tells whether the expression is correct and incorrect
	 * in string form
	 * @return the string 
	 */
	@Override
	public String toString()
	{
		if(checkExpression())
		{
			return exp + " is incorrect";
		}
		return exp + " is correct";
	}
}
