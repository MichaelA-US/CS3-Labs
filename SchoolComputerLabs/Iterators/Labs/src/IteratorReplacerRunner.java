import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;
/**
 * this class implements the IteratorReplacer class and calls upon its methods
 * @author Am10073106
 *
 */
public class IteratorReplacerRunner
{
	public static void main ( String[] args )
	{
		IteratorReplacer test = new IteratorReplacer("1 2 3 1 2 4", "1", "5");
		test.replace();
		System.out.println(test.toString());

		IteratorReplacer test1 = new IteratorReplacer("1 2 3 4 5 6 7 8 9 1 0 -1 -1 -1", "-1", "42");
		test1.replace();
		System.out.println(test1.toString());

		IteratorReplacer test2 = new IteratorReplacer("3 1 4 1 5 9 3 3 72 -3 2 3 6", "3", "0");
		test2.replace();
		System.out.println(test2.toString());
	}
}