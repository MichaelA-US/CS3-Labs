import java.util.EmptyStackException;
/**
 * This class implements multiple methods to recreate a replica of the Stack class
 */
public class MyStack
{
    private Integer[] stack;
    private int size;
    /**
     * Default constructor of the class
     */
    public MyStack()
    {
        size = 0;
    }
    /**
     * Second constructor that
     * initalized the variables and size
     */
    public MyStack(int initCap)
    {
        this();
        stack = new Integer[initCap];
        size = initCap;
    }
    /**
     * Finds if the stack doesn't have any objects in it
     * @return a true or false - true being if it is empty, false if not
     */
    public boolean isEmpty()
    {
        if(stack.length == 0) //Checks if stack is empty
        {
            return true;
        }
        return false;
    }
    /**
     * Finds the top value on the stack
     * Throws an exception if not possible
     * @return the value on the top
     */
    public Integer Peek()
    {
        if(isEmpty()) //If no elements throw exception
        {
            throw new EmptyStackException();
        }
        return stack[size - 1];

    }
    /**
     * Removes the top value and returns it; throws an exception
     * if not possible
     * @return the value removed
     */
    public Integer pop()
    {
        if(isEmpty()) //If no elements throw exception
        {
            throw new EmptyStackException();
        }
        int temp = stack[size - 1];
        size--;
        return temp;
    }
    /**
     * Adds an item to the stack
     * @param the item to add
     */
    public void push(Integer item)
    {
        if(size == stack.length) //Checks if stack is at max size
        {
            doubleCapacity();
        }
        stack[size] = item;
        size++;
    }
    /**
     * Doubles the capacity of the array
     * to ensure the stack has enough space when adding items
     */
    public void doubleCapacity()
    {
        Integer[] tempStack = new Integer[stack.length * 2]; //Double the stack
        for(int i = 0; i < stack.length; i++)
        {
            tempStack[i] = stack[i]; //Add values
        }
        stack = tempStack; 
    }
    /**
     * Convert the stack to a string in a
     * 'stack' like way
     * @return the stack
     */
    @Override
    public String toString()
    {
        if(isEmpty())
        {
            return "[]"; 
        }
        String s = "[";
        for(Integer i: stack)
        {
            if(i == null) //If the element is null don't add the item to string
            {
                break;
            }
            s += i + ", ";
        }
        return s.substring(0, s.length()-2) + "]";
    }

    //Advanced
    public Integer getMin()
    {
        return 0;
    }
}
