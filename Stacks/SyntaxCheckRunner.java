
/**
* This class implements multiple test cases
* in order to ensure the SyntaxChecker class is working properly
*/
public class SyntaxCheckRunner
{
	public static void main ( String[] args )
	{
			SyntaxChecker check = new SyntaxChecker("(abc(*def)");	
			System.out.println(check);
			
			SyntaxChecker check1 = new SyntaxChecker("[{}]");	
			System.out.println(check1);
			
			SyntaxChecker check2 = new SyntaxChecker("[");	
			System.out.println(check2);
			
			SyntaxChecker check3 = new SyntaxChecker("[{<()>}]");	
			System.out.println(check3);
			
			SyntaxChecker check4 = new SyntaxChecker("{<html[value=4]*(12)>{$x}}");	
			System.out.println(check4);
			
			SyntaxChecker check5 = new SyntaxChecker("[one]<two>{three}(four)");
			System.out.println(check5);
			
			SyntaxChecker check6 = new SyntaxChecker("((car(cdr(a)(b)))");	
			System.out.println(check6);
			
			SyntaxChecker check7 = new SyntaxChecker("(car(cdra)(b))"); 
			System.out.println(check7);
		
	}
}
