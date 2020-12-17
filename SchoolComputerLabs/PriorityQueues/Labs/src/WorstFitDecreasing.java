import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * This class implements the Worst fit decreasing algorithm for a greedy
 * similar to the WorstFit but in reverse
 * @author Am10073106
 *
 */
public class WorstFitDecreasing 
{
	public static void main(String[] args) throws IOException 
	{
		Scanner scan = new Scanner(new File("input20.txt"));
		PriorityQueue<Disk> pDisk = new PriorityQueue<Disk>();
		ArrayList<Integer> pDisk2 = new ArrayList<Integer>();
		double gigs = 0.0;
		int dskNum = 0;
		while(scan.hasNextLine()) 
		{
			pDisk2.add(scan.nextInt()); //adding the files to an arraylist
		}
		Collections.sort(pDisk2); //sorting it in order
		pDisk.add(new Disk(dskNum++)); 
		for(int i = pDisk2.size()-1; i >= 0; i--) //looping through the arraylist
		{
			int size = pDisk2.get(i);
			Disk lowDisk = pDisk.poll();

			if(lowDisk.newDisk(size)) //if we dont need to make a new disk
			{
				lowDisk.add(size); //add the disk to the current one
				pDisk.add(lowDisk);
			}
			else //if full we make the new disk
			{
				pDisk.add(lowDisk);
				Disk newDisk = new Disk(dskNum++); //add the disk with the amount
				newDisk.add(size);
				pDisk.add(newDisk);
			}
		}
		for(Disk disk : pDisk) 
		{
			gigs += disk.getSizeGig(); //get the size in gigs
		}
		System.out.println("Total size: " + gigs + " GB");
		System.out.println("pDisk req'd = " + pDisk.size() + "\n");
		System.out.println("\t# Avail");
		while(!pDisk.isEmpty()) 
		{
			System.out.print("\t" + pDisk.poll() + "\n"); //return them in sorted order
		}
	}
}
