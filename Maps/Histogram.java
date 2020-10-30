
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Scanner;
import static java.lang.System.*;
public class Histogram
{
	private Map<String,Integer> histogram;
	private String sent = "";
	public Histogram()
	{
		//call setSentence
		setSentence();
		sent = "";
	}

	public Histogram(String sent)
	{
		//call setSentence
		setSentence();
		this.sent = sent;
	}
	
	public void setSentence()
	{
		histogram = new TreeMap<String,Integer>();
		String[] data = sent.split(" ");
		for(int i = 0; i < data.length; i++)
		{
			if(histogram.get(data[i]) == null)
			{
				histogram.put(data[i], 0);
			}
			histogram.put(data[i],histogram.get(data[i]) + 1);
		}
	}

	public String toString()
	{
		String output="";
		for(String s : histogram.keySet())
		{
			output += s + "    ";
			output += "\t";
			String getStr = "";
			for(int i = 0; i < histogram.get(s); i++)
			{
				getStr = getStr + "*";
			}
			output += getStr + "\n";
		}
		return output+"\n\n";
	}
}