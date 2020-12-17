
public enum Fruit
{
	APPLE("RED"), BANANA("YELLOW"), GRAPES("GREEN"), Orange;
	private String color;
	
	private Fruit()
	{
		System.out.println("Constructor called for: " + this.name());
	}
	
	private Fruit(String color)
	{
		System.out.println("Constructor called for: " + this.toString());
		this.color = color;
	}

	public String getColor()
	{
		return color;
	}
	
	

}
