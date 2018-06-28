import java.util.Scanner;
import java.io.*;
public class testBuilder
{
	public static String[][] build()
	{
		File source = new File("cdc.txt");
		Scanner input = new Scanner(source);
		String [][]buildTest = new String[400][5];
		
		for(int row = 0; row<400; row++)
		{
			for(int col = 0; col<5; col++)
			{
				buildTest[row][col] = input.nextLine();
			}
		}
		input.close();
		return buildTest;
	}
	public static String[] answer()
	{
		File ansFile = new File("cdcAnswer.txt");
		Scanner input = new Scanner(ansFile);
		
		String [] answerArray = new String[400];
		
		for(int i = 0; i < 400;i++)
			answerArray[i] = input.nextLine();
		input.close();
		return answerArray;
	}
}