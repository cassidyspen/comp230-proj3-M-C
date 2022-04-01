/*comments :) */
import java.util.Scanner;

public class MSS1
{
	public static void main(String[] arg)
	{
		//decalare variables
		Scanner sc = new Scanner(System.in);

		//get input from the user
		System.out.println("Enter a sequence");
		String sequence = sc.nextLine();
		String[] strArr = sequence.split(",");

		int[] intArr = new int[strArr.length];

		for(int i=0; i<strArr.length; i++)
		{
			intArr[i] = Integer.parseInt(strArr[i]);
		}
		int answer = mss1alg(intArr);
		System.out.println("\n"+answer);


	}
	/*method for mss1*/
	public static int mss1alg(int[] arr)
	{
		int sum = 0,maxSum = 0;
		for(int i=0; i<arr.length; i++)
		{
			for(int j=i; i<arr.length; j++)
			{
				sum = 0;
				for(int k=i; k<=j; k++)
					sum += arr[k];
				if (sum > maxSum)
					maxSum = sum;
			}
		}
		return maxSum;
	}

}
