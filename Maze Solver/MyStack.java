import java.util.EmptyStackException;

public class MyStack implements StackADT
{
    private Square[] stack;
    private int size;

    public MyStack()
    {
        size = 0;
    }

    public MyStack(int initCap)
    {
        this();
        stack = new Square[initCap];
        size = initCap;
    }

    public boolean isEmpty()
    {
        if(stack.length == 0)
        {
            return true;
        }
        return false;
    }

    public Square Peek()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        return stack[size - 1];

    }

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

    public void push(Square item)
    {
        if(size == stack.length)
        {
            doubleCapacity();
        }
        stack[size] = item;
        size++;
    }

    public void doubleCapacity()
    {
    	Square[] tempStack = new Square[stack.length * 2];
        for(int i = 0; i < stack.length; i++)
        {
            tempStack[i] = stack[i];
        }
        stack = tempStack;
    }
    @Override
    public String toString()
    {
        if(isEmpty())
        {
            return "[]";
        }
        String s = "[";
        for(Square i: stack)
        {
            if(i == null)
            {
                break;
            }
            s += i + ", ";
        }
        return s.substring(0, s.length()-2) + "]";
    }

    //Advanced
    public Square getMin()
    {
        return null;
    }
}

