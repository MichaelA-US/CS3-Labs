
public class IntTreeNode {
	int data;
	IntTreeNode left;
	IntTreeNode right;
	public IntTreeNode(int data)
	{
		this(data, null, null);
	}
	public IntTreeNode(int data, IntTreeNode left, IntTreeNode right)
	{
		this.data= data; 
		this.left = left;
		this.right = right;
	}
	
}
