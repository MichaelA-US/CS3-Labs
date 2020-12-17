import java.util.*;
import java.io.*;
public class HuffmanTree
{
	private int[] huffArr;
	@SuppressWarnings("rawtypes")
	Queue<Node> pQueue = new PriorityQueue<Node>();
	public HuffmanTree(int[] count)
	{
		for(int i = 0; i < count.length; i++)
		{
			huffArr[i] = count[i];
		}
	}
	public HuffmanTree(String codeFile) throws IOException
	{
		Scanner scan = new Scanner(new File(codeFile));
		while(scan.hasNext())
		{
			
		}
	}
	public void decode(BitInputStream in, String outFile)
	{
		
	}
	public void write(String filename)
	{
		
	}

public class Node<T> implements Comparable<T>
{
	Node node;
	Node left;
	Node right;
	public Node()
	{
		
	}
	@SuppressWarnings("unchecked")
	@Override
	public int compareTo(T obj)
	{
		// TODO Auto-generated method stub
		return (-1) * node.compareTo(obj);
	}

}
}
