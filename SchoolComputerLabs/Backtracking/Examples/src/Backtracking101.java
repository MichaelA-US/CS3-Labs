
public class Backtracking101
{

	public static void printBinary(int n)
	{
		if(n == 0)
		{
			System.out.println();
		}
		else
		{
			printBinaryHelper(n, "");
		}
	}
	private static void printBinaryHelper(int n, String res)
	{
		if(res.length() == n)
		{
			System.out.print(res + " ");
		}
		else
		{
			printBinaryHelper(n, res + 0);
			printBinaryHelper(n, res + 1);
		}
	}
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		printBinary(3);
	}

}
