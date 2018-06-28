import java.util.Scanner;
import java.io.*;
public class testBuilder1
{
	public static String[][] build() throws IOException
	{
		File source = new File("cdc1.txt");
		Scanner input = new Scanner(source);
		String [][]buildTest = new String[100][5];
		
		for(int row = 0; row<100; row++)
		{
			for(int col = 0; col<5; col++)
			{
				buildTest[row][col] = input.nextLine();
			}
		}
		input.close();
		return buildTest;
	}
}