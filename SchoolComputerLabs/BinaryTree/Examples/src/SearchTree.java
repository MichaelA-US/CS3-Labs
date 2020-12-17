
public class SearchTree 
{
	private IntTreeNode overallRoot;
	public boolean contains(int value)
	{
		return contains(overallRoot, value);
	}
	public IntTreeNode add(int value)
	{
		return add(overallRoot, value);
	}
	private IntTreeNode add(IntTreeNode node, int value)
	{
		if(node == null)
		{
			node = new IntTreeNode(value);
		}
		else if(node.data > value)
		{
			node.left = add(node.left, value);
		}
		else if(node.data < value)
		{
			node.right = add(node.right, value);
		}
		return node;
	}
	
	private boolean contains(IntTreeNode node, int value)
	{
		if(node == null)
		{
			return false;
		}
		else if(node.data == value)
		{
			return true;
		}
		else if(node.data > value)
		{
			return contains(node.left, value);
		}
		else
		{
			return contains(node.right, value);
		}
	}
}
