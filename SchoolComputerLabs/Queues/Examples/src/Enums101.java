
public class Enums101
{
	Day day;
	
	public Enums101(Day day)
	{
		this.day = day;
	}
	
	public void dayIsLike()
	{
		switch(day)
		{
			case MONDAY:
				System.out.println("Mondays are bad.");
				break;
			case FRIDAY:
				System.out.println("Fridays are better.");
				break;
			case SATURDAY:
			case SUNDAY:
				System.out.println("Weekends are best.");
				break;
			default:
				System.out.println("Midweek days are so-so");		
		}
	}
	
	public void isItWeekend()
	{
		Day d1 = Day.valueOf("SATURDAY");
		Day d2 = Day.valueOf("SUNDAY");
		if(day == d1 || day == d2)
			System.out.println("Time to get lit!");
		else
			System.out.println("It's NOT the weekend. Get back to work!");
	}
	//Driver Method
	public static void main(String[] args)
	{
		String str = "SATURDAY";
		Enums101 t1 = new Enums101(Day.valueOf(str));
		t1.dayIsLike();
		t1.isItWeekend();
	}
}
