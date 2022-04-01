import java.io.*;
import java.util.Scanner;

public class MSS2 {
	public static void main(String[] args){
		BufferedReader input;
		String inputLine;

		//reading in the file
		try
		{
			String[] strArr;
			//int[] intArray;
			
			//TODO change file input to variable
			input = new BufferedReader(new FileReader("nums0.txt"));
			while((inputLine = input.readLine()) != null) {
				strArr = inputLine.split(",");
			
			
				//convert string array into int array
				int[] intArray = new int[strArr.length];
				for(int i=0; i<strArr.length; i++)
					intArray[i] = Integer.parseInt(strArr[i]);
			
			
				int mss1ans = mss1alg(intArray);
				int mss2ans = mss2alg(intArray);

				System.out.println("\nMss1 answer: "+mss1ans+"\nMss2 answer: "+mss2ans);
			}


		} //end try
		catch (FileNotFoundException e)
		{
			System.out.println("File not found, please enter a valid file name.");
			System.exit(1);
		} // catch
		catch (IOException e)
		{
			System.out.println(e.getMessage());
			System.exit(1);
		} // end catch
		
		
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

	/*MSS2 Algorithm*/
	public static int mss2alg(int[] arr)
	{
		int sum=0,maxSum=0;
		for(int i=0; i<arr.length; i++){
        	sum = 0;
            for(int j=i; j<arr.length; j++){
            	sum += arr[j];
                if(sum > maxSum)
                	maxSum = sum;
            }
        }
 
        return maxSum;
    }

	/*MSS3 Algorithm*/
	//Driver program for recursive function//
	public static int mss3alg(int[] arr)
	{
		int[] left = 
	}

	//Finds the max of the maxLeftBoundSum, maxRightBoundSum, and 
	//maxLeftBoundSum + maxRightBoundSum
	public static int middle(int[] arr, int first, int last)
	{
		//finding maxLeftBoundSum
		int sum=0;
		int maxLeftSum = arr[mid];
		for(int i = mid; i>first; i--)
		{
			sum += arr[i];
			if(sum>maxLeftSum)
				maxLeftSum = sum;
		}

		//finding maxRightBoundSum
		int sum = 0;
		int maxRightSum = arr[mid + 1];
		for(int i = mid + 1; i<last; i++)
		{
			sum += arr[i];
			if(sum>maxRightSum)
				maxRightSum = sum;	
		}

		return Math.max(maxRightSum + maxLeftSum, maxLeftSum, maxRightSum);
	}
}

