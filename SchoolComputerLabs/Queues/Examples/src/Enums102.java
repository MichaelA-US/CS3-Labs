
public class Enums102
{
	public static void main(String args[])
	{
		//Calling values()
		Element arr[] = Element.values();
		
		//enum with loop
		for(Element e : arr)
		{
			System.out.println(e + " at index " + e.ordinal());
		}
		
		//Using valueOf() returns an object of
		//Element with given const.
		System.out.println(Element.valueOf("FIRE"));
		
		//IllegalArgumentExeception
		//System.out.println(Element.valueOf("LOVE"));
		
		
	}
}
