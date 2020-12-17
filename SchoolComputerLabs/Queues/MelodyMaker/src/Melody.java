import java.util.*;
/**
 * This class implements multiple methods to be able to
 * to change a queue of notes of scientific pitch notation from a song
 * for multiple uses
 * @author Am10073106
 *
 */
public class Melody
{
	private Queue<Note> notes;
	
	/**
	 * Basic constructor that initalizes
	 * the melody of notes
	 * @param song
	 */
	public Melody(Queue<Note> song) //1
	{
		notes = new LinkedList<Note>(song);
	}
	/**
	 * Returns the total length of the melody. If
	 * the song is repeated adds that section
	 * @return
	 */
	public double getTotalDuration() //2
	{
		Queue<Note> notesTemp = new LinkedList<Note>(notes);
		double total = 0;
		while(!notesTemp.isEmpty())
		{
			Note temp = notesTemp.poll();
			if(temp.isRepeat())
			{
				total += temp.getDuration()*2;
			}
			else
			{
				total += notesTemp.poll().getDuration();
			}
		}
		return total;
		
	}
	/**
	 * Returns a string of all the notes in a melody
	 * @return str which is the string of all the notes
	 */
	@Override
	public String toString() //1
	{
		Queue<Note> notesTemp = new LinkedList<Note>(notes);
		String str = "";
		while(!notesTemp.isEmpty())
		{
			str += notesTemp.poll().toString() + "\n";
		}
		return str;
		
	}
	/**
	 * Changes the tempo of each note to its set value	
	 * @param tempo - the value to change the songs tempo
	 */
	public void changeTempo(double tempo) //2
	{
		Queue<Note> notesTemp = new LinkedList<Note>();
		while(!notesTemp.isEmpty())
		{
			Note temp = notesTemp.poll();
			temp.setDuration(temp.getDuration() * tempo);
		}
	}
	/**
	 * Reverses the order of notes of
	 * the song
	 */
	public void reverse() //3
	{
		Queue<Note> tempNotes = new LinkedList<Note>(notes);
		Queue<Note> tempNotes1 = new LinkedList<Note>();
		while(!tempNotes.isEmpty())
		{
			tempNotes1.offer(tempNotes.poll());
		}
	}
	/**
	 * Getter method for the notes in a melody
	 * @return
	 */
	public Queue<Note> getNotes()
	{
		return notes;
	}
	/**
	 * Adds all the notes from the other song to the end
	 * of the melody
	 * @param other - the other song with the notes supplied
	 */
	public void append(Melody other) //3
	{
		Queue<Note> tempNotes = other.getNotes();
		while(!tempNotes.isEmpty())
		{
			notes.offer(tempNotes.poll());
		}
	}
	/**
	 * Plays the song by calling each note's
	 * play method
	 */
	public void play() //4
	{
		try
		{
			Queue<Note> tempNotes = new LinkedList<Note>(notes);
			while(!notes.isEmpty())
			{
				Note temp = tempNotes.poll();
				temp.play();
			}
		}
		catch(NullPointerException e)
		{
			System.out.println("End of song");
		}
	}
}
