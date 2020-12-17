import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
public class Maps101
{
	public static void main(String args[])
	{
		Map<Integer, String> mapOne = new TreeMap<Integer, String>();
		mapOne.put(1, "Raymond");
		mapOne.put(11, "Michael");
		mapOne.put(8, "David");
		mapOne.put(3, "Numair");
		mapOne.put(5, "Chloe");
		System.out.println("Map One: " + mapOne + "\n");
		
		System.out.println("Element at index 1 : " + mapOne.get(1));
		
		System.out.println(mapOne.put(2,  "Rushi"));
		System.out.println(mapOne.put(3,  "Nhat-The"));
		System.out.println("Map One: " + mapOne);
		
		System.out.println("-----------------------------------");
		Map<Integer, String> mapTwo = new HashMap<Integer, String>();
		mapTwo.put(1, "Raymond");
		mapTwo.put(11, "Michael");
		mapTwo.put(8, "David");
		mapTwo.put(3, "Numair");
		mapTwo.put(5, "Chloe");
		System.out.println("Map One: " + mapTwo + "\n");
		
		System.out.println("Element at index 1 : " + mapTwo.get(1));
		
		System.out.println(mapTwo.put(2,  "Rushi"));
		System.out.println(mapTwo.put(3,  "Nhat-The"));
		System.out.println("Map One: " + mapTwo);
		
		System.out.println("-----------------------------------");
		
	}
}
