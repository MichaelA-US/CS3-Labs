import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * This class implements a greedy WorstFit algorithm of a priority
 * queue
 * @author Am10073106
 *
 */
public class WorstFit 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner scan = new Scanner(new File("input20.txt"));
		PriorityQueue<Disk> pDisk = new PriorityQueue<Disk>();
		
		
		int dskNum = 0;
		pDisk.add(new Disk(dskNum++));
		while(scan.hasNextLine()) //looping through the file given
		{
			int disk = scan.nextInt();
			Disk lowDisk = pDisk.poll();
			Integer size = disk;
			if(lowDisk.newDisk(size))  //If we don't need to create a new disk
			{
				lowDisk.add(size); // add to current disk
				pDisk.add(lowDisk); // add it to the priority queue
			}
			else //if need to make a new disk (since full)
			{
				pDisk.add(lowDisk);
				Disk newDisk = new Disk(dskNum++); //make new disk and increase size of disks
				newDisk.add(size);
				pDisk.add(newDisk);
			}
		}

		double gigs = 0.0;
		for(Disk disk : pDisk)
		{
			gigs += disk.getSizeGig(); //get the gigs
		}
		System.out.println("Total size: " + gigs + " GB");
		System.out.println("Disks req'd = " + pDisk.size() + "\n");
		System.out.println("\t# Avail");
		while(!pDisk.isEmpty())
		{
			System.out.print("\t" + pDisk.poll() + "\n"); //print them out in order 
		}
	}
}
