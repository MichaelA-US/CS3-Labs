/**
* This class implements multiple test cases
* to confirm that the PostFix classs is working properly
*/
public class PostFixRunner
{
	public static void main ( String[] args )
	{
		PostFix fix = new PostFix("2 7 + 1 2 + +");
		fix.solve();
		System.out.println(fix);

		fix.setExpression("1 2 3 4 + + +");
		fix.solve();
		System.out.println(fix);

		fix.setExpression("9 3 * 8 / 4 +");
		fix.solve();
		System.out.println(fix);

		fix.setExpression("3 3 + 7 * 9 2 / +");
		fix.solve();
		System.out.println(fix);

		fix.setExpression("9 3 / 2 * 7 9 * + 4 -");
		fix.solve();
		System.out.println(fix);

		fix.setExpression("5 5 + 2 * 4 / 9 +");
		fix.solve();
		System.out.println(fix);
	}
}
