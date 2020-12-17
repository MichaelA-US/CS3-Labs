import java.awt.Color;
import java.util.Stack;
public class Stacks101
{
	public static void main(String[] args)
	{
		//Here's the old way using Stacks (which still works, buy you may get a warning message)
		Stack myStack = new Stack();
		
		//push() adds item to the stack
		System.out.println("Pushing");
		
		System.out.println("Color.RED");
		myStack.push(Color.red);
		
		System.out.println("abcde");
		myStack.push("abcde");
		
		System.out.println("409");
		myStack.push(409); //Autoboxing as an object
		
		System.out.println("\nPrinting stack with toString: ");
		System.out.println(myStack + "\n");
		
		//pop() removes item from the stack
		System.out.println("Popping");
		
		Integer x = (Integer) myStack.pop(); //OLD Method without autoboxing
		System.out.println(myStack.pop());
		System.out.println(myStack.pop());
		
	}
}
