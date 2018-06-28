import java.util.Random;

public class pickerC
{
	Random random = new Random();
	int setNum;
	static int counter = 0;
	public int counts = 0;
	public int test;
	int[] numUsed = new int[100];
	
	public int numPicker()
	{
		do
		{
			test = 1;
			setNum = random.nextInt(100);
			numUsed[counter] = setNum;
			for(int i = 0; i < counter; i++)
			{
				if(numUsed[i] == setNum)
				{
					test = 0;
					break;
				}
			}
		}
		while(test == 0);
		counter++;
		return setNum;
	}
}