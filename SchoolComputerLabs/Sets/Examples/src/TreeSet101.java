import java.util.Set;
import java.util.TreeSet;

public class TreeSet101
{
	public static void main(String args[])
	{
		Set<Integer> nums;
		nums = new TreeSet<Integer>();
		nums.add(3);
		nums.add(2);
		System.out.println(nums.add(6));
		System.out.println("nums: " + nums + "\n");
		
		System.out.println(nums.add(6)); //duplicates will not be added
		System.out.println("nums: " + nums + "\n");
		
		nums.add(-4);
		System.out.println("nums: " + nums + "\n"); //natural ordering is maintained
		//removing elements
		System.out.println(nums.remove(2));
		System.out.println(nums.remove(5));
		System.out.println("nums: " + nums + "\n");

		System.out.println("==============================================\n");
		
		Set<String> words;
		words = new TreeSet<String>();
		words.add("rock");
		words.add("paper");
		System.out.println(words.add("scissors"));
		System.out.println("words: " + words + "\n");
		
		System.out.println(words.add("rock")); //duplicates will not be added
		System.out.println("words: " + words + "\n");
		
		words.add("lizard");
		System.out.println("words: " + words + "\n"); //natural ordering is maintained

		//removing elements
		System.out.println(words.remove("scissors"));
		System.out.println(words.remove("spock"));
		System.out.println("nums: " + words + "\n");
	}
	

}
