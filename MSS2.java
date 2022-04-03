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
				int mss3ans = mss3alg(intArray, 0, intArray.length-1);

				System.out.println("\nMSS1 answer: "+mss1ans+"\nMSS2 answer: "+mss2ans
									+ "\nMSS3 answer: " +mss3ans);
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

	//Finds the max of the maxLeftBoundSum, maxRightBoundSum, and 
	//maxLeftBoundSum + maxRightBoundSum
	public static int middle(int[] arr, int first,int mid, int last)
	{
		//finding maxLeftBoundSum
		int sum=0;
		int maxLeftSum = arr[mid];
		for(int i = mid; i>= first; i--)
		{
			sum += arr[i];
			if(sum>maxLeftSum)
				maxLeftSum = sum;
		}

		//finding maxRightBoundSum
		int sum2 = 0;
		int maxRightSum = arr[mid + 1];
		for(int i = mid + 1; i<=last; i++)
		{
			sum2 += arr[i];
			if(sum2>maxRightSum)
				maxRightSum = sum2;	
		}

		return Math.max(maxRightSum + maxLeftSum, Math.max(maxLeftSum, maxRightSum));
	}
 /*method for recursion*/
     public static int mss3alg(int[] arr, int first, int last)
     {
         //base case
         if (first == last)
             return arr[first];
 
         //find middle point
         int mid = (first + last) /2;
 
         //return max(maxLeftSum, maxRightSum, maxLeftBoundSum +
         //maxRightBoundSum)
         return Math.max(mss3alg(arr,first,mid), Math.max(mss3alg(arr,mid+1,last),middle(arr,first,mid,last)));
 
     }	
}

