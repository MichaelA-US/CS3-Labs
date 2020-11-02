public class Part implements Comparable<Part>
{
	private String make, mode, rest;
	private int year;

	public Part(String line)
	{
		String[] list = line.split(" ");
		int len = list.length;
		rest = "";
		for(int i = 0; i < list.length - 3; i++)
		{
			rest += " " + list[i];
		}
		make = list[len-3];
		mode = list[len-2];
		year = Integer.parseInt(list[len-1]);
	}

	//have to have compareTo if implements Comparable
	public int compareTo( Part rhs )
	{
		if(make.equals(rhs.make))
		{
			if(mode.equals(rhs.mode))
			{
				if(year == rhs.year)
				{
					return rest.compareTo(rhs.rest);
				}
				else if(year > rhs.year)
				{
					return 1;
				}
				return -1;
			}
			return mode.compareTo(rhs.mode);
		}
		return make.compareTo(rhs.make);
	}

	public String toString()
	{
		return "" + make + " " + mode + " " + year + " " + rest;
	}
}