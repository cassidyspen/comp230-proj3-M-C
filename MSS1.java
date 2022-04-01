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
			for(int j=i; j<arr.length; j++)
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
	/*method for recurrsion*/
	public static int mss3Recursion(int[] arr, int first, int last)
	{
		//base case
		if (first == last)
			return arr[first];
		
		//find middle point
		int mid = (first + last) /2;

		//return max(maxLeftSum, maxRightSum, maxLeftBoundSum +
		//maxRightBoundSum)
		return Math.max(mss3Recursion(arr,first,mid),mss3Recursion(arr,mid+1,last),maxCross(arr,first,mid,last));

	}

}
