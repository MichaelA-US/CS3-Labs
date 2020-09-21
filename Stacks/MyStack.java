import java.util.EmptyStackException;

public class MyStack
{
    private Integer[] stack;
    private int size;

    public MyStack()
    {
        size = 0;
    }

    public MyStack(int initCap)
    {
        this();
        stack = new Integer[initCap];
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

    public Integer Peek()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        return stack[size - 1];

    }

    public Integer pop()
    {
        if(isEmpty())
        {
            throw new EmptyStackException();
        }
        int temp = stack[size - 1];
        size--;
        return temp;
    }

    public void push(Integer item)
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
        Integer[] tempStack = new Integer[stack.length * 2];
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
        for(Integer i: stack)
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
    public Integer getMin()
    {
        return 0;
    }
}
