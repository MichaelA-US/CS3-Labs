import java.util.ArrayList;
/**
 * This class implements the Disk class to act a pQueue for the object
 * @author Am10073106
 *
 */
public class Disk implements Comparable<Disk> 
{
	private int totalSizeGigs;
	private int numDisks;					
	private int usedSize;
	private Integer remSizeKB;	
	private ArrayList<Integer> files;
	/**
	 * Basic constructor that initalizes the Disk object and its
	 * values
	 */
	public Disk()
	{
		totalSizeGigs = 0;
		numDisks = 0;
		usedSize = 1000000;
		remSizeKB = 1000000;
		files = new ArrayList<Integer>();
		
	}
	/**
	 * Secondary constructor that initalizes the values and the number of
	 * disks currently stored
	 * @param diskNum - the number of disks
	 */
	public Disk(int diskNum) 
	{
		totalSizeGigs = 0;
		remSizeKB = 1000000;
		files = new ArrayList<Integer>();
		numDisks = diskNum;
		usedSize = 1000000 - remSizeKB;
	}
	/**
	 * Checks whether a new disk has to be made because the capacity is full
	 * if false we do not have to make a new disk.
	 * @param capacity - the capacity of the disk given
	 * @return true or false depending on if we can add it or not
	 */
	public boolean newDisk(Integer capacity)
	{
		return remSizeKB - capacity >= 0;
	}
	/**
	 * Adds the disk into the arraylist of files keeps track of the size
	 * that is going on currently in the number of files
	 * @param other - the size of the disk to add
	 * @return the remaining size avaiable
	 */
	public int add(Integer other) 
	{
		files.add(other);
		remSizeKB -= other;
		usedSize = 1000000 - remSizeKB;
		totalSizeGigs += other;
		return remSizeKB;
	}
	/**
	 * Returns the total size in gigs of the disk
	 * @return the total size in gigs
	 */
	public double getSizeGig()
	{
		return (double) totalSizeGigs / 1000000;
	}
	/**
	 * Returns the remaining size in KB
	 * @return the remaining size within the disk
	 */
	public int getRemSize()
	{
		return remSizeKB;
	}
	/**
	 * Returns the used amount size
	 * @return the used amount of size
	 */
	public int getUsedSize() 
	{
		return usedSize;
	}
	/**
	 * Compares the remaining size KB by checking whether they are
	 * equal or if its greater than we return -1 or else we return 1
	 * @return the value when compared
	 */
	@Override
	public int compareTo(Disk obj)
	{
		if(remSizeKB == obj.remSizeKB)
		{
			return 0;
		}
		else if (remSizeKB > obj.remSizeKB)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	/**
	 * Return a string representation of the string by displaying the files
	 * and the number of disks in there with the remaining size in KB.
	 */
	@Override
	public String toString () 
	{
		String output = "";
		output += numDisks + " " + remSizeKB + ": ";
		for(Integer file : files)
		{
			output += file + " ";
		}
		return output;
	}
}
