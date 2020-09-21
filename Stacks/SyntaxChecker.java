import java.util.*;
import java.util.ArrayList;
public class SyntaxChecker
{
	private String exp;
	private Stack<Character> symbols;

	public SyntaxChecker()
	{
		exp = "";
		symbols = new Stack<Character>();
	}

	public SyntaxChecker(String s)
	{
		this();
		exp = s;
		setExpression(s);
	}
	
	public void setExpression(String s)
	{
		for(char c : exp.toCharArray())
		{
			if(c ==  '{' || c == '(' || c == '<' || c == '[')
			{
				symbols.push(c);
			}
			else if(!symbols.isEmpty() && c ==  '}' || c == ')' || c == '>' || c == ']')
			{
				symbols.pop();
			}
			else
			{
				symbols.push(c);
				symbols.pop();
			}
		}
	}

	public boolean checkExpression()
	{
		if(symbols.isEmpty())
		{
			return false;
		}
		return true;
	}

	//write a toString
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