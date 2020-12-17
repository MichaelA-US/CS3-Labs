import java.util.*;
public class Vertex
{
	private int x, y, ID;
	private List<Integer> edges;
	private boolean visited;
	private double distance;
	public Vertex(int x, int y, int ID)
	{
		this.x = x;
		this.y = y;
		this.ID = ID;
	}
	public void eucDist(int x, int y)
	{
		
	}
	public int compareTo(Object o)
	{
		return 1;
	}
	@Override
	public String toString()
	{
		return "";
	}
}
