/*Creates a set of test files to use for MSS*/

import java.io.*;
import java.util.Random;

public class CreateFiles
{
	public static void main(String[] args) throws IOException
	{
		//declare file names
		String[] files = {"50words.txt","150words.txt","250words.txt","350words.txt","450words.txt"};
		int[] nums = {50,150,250,350,450};
		Random rn = new Random();

		//loop for creating files
		for(int i=0; i<nums.length; i++)
		{
			FileWriter fw = new FileWriter(files[i],true);
			PrintWriter pw = new PrintWriter(fw);
			for(int j=0; j<nums[i]; j++)
			{
				pw.print(rn.nextInt());
				if(j<nums[i]-1)
					pw.print(",");
			}
			pw.close();
		}
		
		System.exit(0);
	}
}
