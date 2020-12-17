import java.util.NoSuchElementException;

public class IntTree 
{
	private IntTreeNode overallRoot;
	public int getMin()
	{
		if(overallRoot == null)
		{
			throw new NoSuchElementException();
		}
		return getMin(overallRoot);
	}
	private int getMin(IntTreeNode node)
	{
		if(node == null)
		{
			return node.data;
		}
		return getMin(node.left);
	}
	public IntTreeNode remove(int value)
	{
		return remove(value);
		
	}
	private IntTreeNode remove(IntTreeNode node, int value)
	{
		if(node.data == value)
		{
			
		}
		return node;
	}
}
