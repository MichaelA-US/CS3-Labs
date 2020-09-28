import java.util.EmptyStackException;
/**
 * This class implements multiple methods to recreate a replica of the Stack class
 */
public class MyStack implements StackADT
{
    private Square[] stack;
    private int size;
    /**
     * Default constructor of the class
     */
    public MyStack()
    {
        this(10);
    }
    /**
     * Second constructor that
     * initalized the variables and size
     */
    public MyStack(int initCap)
    {
        stack = new Square[initCap];
        size = initCap;
    }
    /**
     * Finds if the stack doesn't have any objects in it
     * @return a true or false - true being if it is empty, false if not
     */
    public boolean isEmpty()
    {
        if(size == 0)
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
    public Square Peek()
    {
        if(isEmpty())
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
    public Square pop()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        Square temp = stack[size - 1];
        size--;
        return temp;
    }
    /**
     * Adds an item to the stack
     * @param item to add
     */
    public void push(Square item)
    {
        if(size == stack.length)
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
        Square[] tempStack = new Square[stack.length * 2];
        for(int i = 0; i < stack.length; i++)
        {
            tempStack[i] = stack[i];
        }
        stack = tempStack;
    }
    /**
     * Convert the stack to a string in a
     * 'stack' like way
     * @return the stack
     */
    @Override
    public String toString() //open to changes
    {
        String str = "[";
        for (int i=size-1;i>-1;i--)
        {
            if(stack[i] == null)
            {
                break;
            }
            str+=stack[i]+",";
        }
        if(size > 0)
        {
            return str.substring(0,str.length()-1)+"]";
        }
        else
        {
            return "[]";
        }
    }

    //Advanced
    public Square getMin()
    {
        return null;
    }

    @Override
    public Square peek()
    {
        // TODO Auto-generated method stub
        return this.peek();
    }

    @Override
    public int size()
    {
        // TODO Auto-generated method stub
        return size;
    }

    @Override
    public void clear()
    {
        // TODO Auto-generated method stub
        stack = new Square[1];
        size = 0;

    }
}
