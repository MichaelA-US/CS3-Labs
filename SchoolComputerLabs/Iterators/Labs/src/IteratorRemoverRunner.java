import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
/**
 * This class implements test cases for the IteratorRemover Class
 * @author Am10073106
 *
 */
public class IteratorRemoverRunner
{
	public static void main ( String[] args )
	{
		IteratorRemover test = new IteratorRemover("a b c a b c a", "a"); 
		test.remove();
		System.out.println(test.toString());

		IteratorRemover test1 = new IteratorRemover("a b c d e f g h i j x x x x", "x");
		test1.remove();
		System.out.println(test1.toString());

		IteratorRemover test2 = new IteratorRemover("1 2 3 4 5 6 a c a c", "b");
		test2.remove();
		System.out.println(test2.toString());


	}
}