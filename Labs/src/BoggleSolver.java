

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BoggleSolver {
	private Set<String> dictionary;
	private Set<String> words;

	public BoggleSolver(String dictionaryName) 
	{
		dictionary = new HashSet<String>();
		words = new HashSet<String>();
		try 
		{
			Scanner scan = new Scanner(new File(dictionaryName));
			while (scan.hasNextLine())
			{
				dictionary.add(scan.nextLine());
			}
		} 
		catch (Exception e)
		{
		}
	}

	public Iterable<String> getAllValidWords(BoggleBoard board) 
	{
        final long S = System.nanoTime();
		for (int i = 0; i < board.rows(); i++)
		{
			for (int j = 0; j < board.cols(); j++)
			{
				validHelper(board, i, j, 0, "", new boolean [board.rows()][board.cols()]);
			}
		}
		final long E = System.nanoTime();
		 System.out.println("Time: " + (E - S) / 1000000000 + "seconds");
		return words;
	}

	public void validHelper(BoggleBoard board, int i, int j, int size, String word, boolean[][] v)
	{
		if (size >= 3 && dictionary.contains(word))
		{
			words.add(word);
		}

		if (notInBounds(i, j, board) || v[i][j])
		{
			return;
		}
		v[i][j] = true;
		int add = 1;
		if (addition(i, j, board).equals("Qu"))
			add = 2;
		for(int x = -1; x <= 1; x++)
		{
			for(int y = -1; y <= 1; y++)
			{
				validHelper(board, i + x, j + y, size + add, word + addition(i, j, board), v);
			}
		}
		v[i][j] = false;
	}

	public String addition(int i, int j, BoggleBoard board)
	{
		if (board.getLetter(i, j) == 'Q')
			return "QU";
		return board.getLetter(i, j) + "";
	}

	public int scoreOf(String word) {
		if (word.length() <= 4)
		{
			return 1;
		}
		if (word.length() == 5)
		{
			return 2;
		}
		if (word.length() == 6)
		{
			return 3;
		}
		if (word.length() == 7)
		{
			return 5;
		}
		if (word.length() >= 8)
		{
			return 11;
		}
		return 0;
	}
	public boolean notInBounds(int i, int j, BoggleBoard board)
	{
		return i < 0 || i >= board.rows() || j < 0 || j >= board.cols();
	}
	public static void main(String[] args) {
		System.out.println("WORKING");

		final String PATH = "";
		BoggleBoard board = new BoggleBoard(PATH + "board-q.txt");
		BoggleSolver solver = new BoggleSolver(PATH + "dictionary-algs4.txt");

		int totalPoints = 0;

		for (String s : solver.getAllValidWords(board)) {
			System.out.println(s + ", points = " + solver.scoreOf(s));
			totalPoints += solver.scoreOf(s);
		}

		System.out.println("Score = " + totalPoints);
	}
}
