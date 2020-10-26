/**
 * This class implements multiple methods in order to simulate a Binary Search Tree (BST)
 * data structure.
 * @author Am10073106
 *
 */
import java.util.*;
public class MyBST
{
	/**
	 * Basic BSTNode class that initializes the node for the BST.
	 */
	private class BSTNode
	{
	    Integer val;
	    BSTNode left, right;
	    
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
           return size(root);
	}
	private int size(BSTNode root)
	{
		if(root == null)
		{
			return 0;
		}
		
		return 1 + size(root.right) + size(root.left);
	}
	/**
	 * Add a node to the the tree with the value n
	 * @param n - the value that is getting added to the tree
	 */
	public void insert(Integer n)
	{
        if(root == null)
	    {
            root = new BSTNode(n);
		    return;
	    }
		insert(n, root);
	}
	private void insert(Integer n, BSTNode root)
	{
		if(n < root.val)
		{
	        if (root.left == null)
		    {
               root.left = new BSTNode(n);
               return;
            }
            	insert(n, root.left);
			}
			else
			{
				if(root.val == n)
				{
					return;
				}
				if (root.right == null)
				{
                   root.right = new BSTNode(n);
                   return;
                 }
                 insert(n, root.right);
			}
			
	}
	/**
	 * Find a node with the same value given in the tree
	 * @param n - the value to check for
	 * @return - true or false depending on whether or not it is found
	 */
	public boolean contains(Integer n) 
	{
        return contains(root, n);
    }
    private boolean contains(BSTNode root, Integer n) 
	{
        if (root == null) 
        {
        	return false;
        }
        if (root.val.equals(n))
        {
        	return true;
        }
       	return contains(root.left, n) || contains(root.right, n);
    }
	/**
	 * Returns the largest value in the tree,
	 * or null if the tree is empty
	 * @return
	 */
	public Integer getMax()
	{
		if(root == null)
		{
			return null;
		}
		return getMax(root);
	}
	private Integer getMax(BSTNode root)
	{
		if(root.right == null)
		{
			return root.val;
		}
		return getMax(root.right);
	}
	/**
	 * Returns the smallest value in the tree,
	 * or null if the tree is empty
	 * @return
	 */
	public Integer getMin()
	{
		if(root == null)
		{
			return null;
		}
		return getMin(root);
	}
	public Integer getMin(BSTNode root)
	{
		if(root.left == null)
		{
			return root.val;
		}
		return getMin(root.left);
	}
	/**
	 * Delete a node in the tree with value n. Does nothing if n
	 * doesn't exist in the tree itself.
	 * @param n
	 */
	public void delete(Integer n)
	{
		delete(n, root);
	}
	private void delete(Integer n, BSTNode root)
	{
		if(root.val.equals(n))
		{
			if(root.right == null && root.left == null)
			{
				root.val = 0;
			}
		}
		
	}
	public void inOrder()
	{
		System.out.print("[");
		inOrder(root);
		System.out.print("]");
	}
	private void inOrder(BSTNode root)
	{
		if(root == null)
		{
			return;
		}
		inOrder(root.left);
		if(root.val < (getMax()))
		{
			System.out.print(root.val + ", ");
		}
		else
		{
			System.out.print(root.val);
		}
		inOrder(root.right);
	}
	public void print()
	{
		print(root, 0);
	}
	private void print(BSTNode root, int level)
	{
		
		if(root == null)
		{
			return;
		}
		print(root.right, level +1);
		System.out.println(helpIndent(level) + root.val);
		print(root.left, level +1);
	}
	public String helpIndent(int level)
	{
		int tab = 4;
		StringBuilder storeSpaces = new StringBuilder();
		for(int i = 0; i < level * tab; i++)
		{
			storeSpaces.append(" ");
		}
		return storeSpaces.toString();
	}
}
