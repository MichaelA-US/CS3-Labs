/**
 * This class implements multiple methods in order to simulate a Binary Search Tree (BST)
 * data structure.
 * @author Am10073106
 *
 */
public class MyBST
{
	/**
	 * Basic BSTNode class that initializes the node for the BST.
	 */
	private class BSTNode
	{
	    Integer val;
	    BSTNode left, right;
	    public BSTNode()
	    {
	    	this.val = null;
	    	left = right = null;
	    }
		public BSTNode(Integer val) 
		{
			this.val = val;
			left = right = null;
		}
		@Override
		public String toString() 
		{ 
			return "" + this.val; 
		}
	}
	private BSTNode root;
	/**
	 * Return the number of elements in the tree
	 * @return # of elements in tree
	 */
	public int size()
	{
		if(this.root == null)
		{
			return 0;
		}
		//return size() + 1;
		return 1;
	}
	/**
	 * Add a node to the the tree with the value n
	 * @param n - the value that is getting added to the tree
	 */
	public void insert(Integer n)
	{
		if(this.root == null)
		{
			this.root = new BSTNode(n);
		}
		else if(n < this.root.left.val)
		{
			root.left.val = n;
		}
		else if(n > this.root.right.val)
		{
			root.right.val = n;
		}
	}
	/**
	 * Find a node with the same value given in the tree
	 * @param n - the value to check for
	 * @return - true or false depending on whether or not it is found
	 */
	public boolean contains(Integer n)
	{
		if(this.root == null)
		{
			return false;
		}
		else if(root.val == n)
		{
			return true;
		}
		else if(root.val > n)
		{
			//return contains(root.left.val);
			return false;
		}
		else
		{
			//return contains(root.right.val);
			return false;
		}
	}
	/**
	 * Returns the largest value in the tree,
	 * or null if the tree is empty
	 * @return
	 */
	public Integer getMax()
	{
		int max = 0;
		int tmp = 0;
		if(root == null)
		{
			return 0;
		}
		if(root != null)
		{
			tmp = root.val;
			if(tmp > max)
			{
				max = tmp;
				//tmp = root.right.val;
			}
		}
		return max;
	}
	/**
	 * Returns the smallest value in the tree,
	 * or null if the tree is empty
	 * @return
	 */
	public Integer getMin()
	{
		int min = 0;
		int tmp = 0;
		if(root == null)
		{
			return 0;
		}
		if(root != null)
		{
			tmp = root.val;
			if(tmp < min)
			{
				min = tmp;
				tmp = root.left.val;
			}
		}
		return min;
	}
	/**
	 * Delete a node in the tree with value n. Does nothing if n
	 * doesn't exist in the tree itself.
	 * @param n
	 */
	public void delete(Integer n)
	{
		
	}
	public void inOrder()
	{
		
	}
	public void print()
	{
		System.out.println(root);
	}
	
}
