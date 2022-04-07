/*Description: This program will read a set of integer numbers from a user
 * specified file and allow the user to run an individual algorithm separately
 * or all four algorithms together. Then the program will display the maximum
 * subsequence sum and the corresponding elapsed execution time. 
 *Authors: Madeleine Woo and Cassidy Spencer
 *Date: 4/6/22
 */

import java.io.*;
import java.util.Scanner;
import java.awt.*;

public class Proj3 
{
	public static void main(String[] args)
	{	
		//declare variables
		BufferedReader input;
		String inputLine;
		String rerun = "";
		Scanner scan = new Scanner(System.in);
		String[] strArr;

		do {
			//reading in the file
			try
			{
				//get user input for file name
				System.out.println("What file would you like to use?");
				String user_input = scan.nextLine();
			
				//display menu
				System.out.println("\nYour menu, madam/sir (please enter your number selection)\n");
				System.out.print("Item # \t Name \t Cost\n"
								  +"---------------------------------");
				System.out.println("\n1.     \t MSS1 \t Muy Expensive");
				System.out.println("2.     \t MSS2 \t Expensive");
				System.out.println("3.     \t MSS3 \t A lil Expensive");
				System.out.println("4.     \t MSS4 \t CHEAP");
				System.out.println("5.     \t ALL  \t Oooh you fancy\n");
	
				//user input for menu choice
				int choice = scan.nextInt();
				while(choice<1 || choice>5)
				{
					System.out.println("\nError: Please enter 1 to 5");
					choice = scan.nextInt();
				}


				input = new BufferedReader(new FileReader(user_input));
				inputLine = input.readLine();	
				strArr = inputLine.split(",");
				input.close();	
			
				//convert string array into int array
				int[] intArray = new int[strArr.length];
				for(int i=0; i<strArr.length; i++)
					intArray[i] = Integer.parseInt(strArr[i]);
				
				//switch statement for the menu choice
				System.out.println();
				switch(choice)
				{
					case 1:
						runAlgs(intArray,choice);
						break;
					case 2:
						runAlgs(intArray,choice);
						break;
					case 3:
						runAlgs(intArray,choice);
						break;
					case 4:
						runAlgs(intArray,choice);
						break;
					default:
						System.out.print("MSS1:\t");
						runAlgs(intArray,1);
						System.out.print("MSS2:\t");
						runAlgs(intArray,2);
						System.out.print("MSS3:\t");
						runAlgs(intArray,3);
						System.out.print("MSS4:\t");
						runAlgs(intArray,4);
				}
			} //end try
			catch (FileNotFoundException e)
			{
				System.out.println("\nFile not found, please rerun with a valid file name.");
				System.exit(1);
			} // catch
			catch (IOException e)
			{
				System.out.println(e.getMessage());
				System.exit(1);
			} // end catch
		
			Toolkit.getDefaultToolkit().beep(); //beep to notify when it's done
			
			//user input for rerun
			System.out.println("\nDo you want to run the program again (y for yes and n for no)?");
			rerun = scan.nextLine();
			rerun = scan.nextLine();
				
			while((!rerun.equalsIgnoreCase("y")) && (!rerun.equalsIgnoreCase("n"))){
				System.out.println("\nInvalid input: please enter a 'y' or 'n'");
				rerun = scan.nextLine();
			}
		}
		while(rerun.equalsIgnoreCase("y"));
		
	}

	/*This method will run a specified algorthim, calculate the time elapsed,
	 * and print out to the user the time and the answer
	 *
	 * @param intArray, int[] with the sequence of numbers
	 * @param alg, int for the algorithm number to run
	 */
	public static void runAlgs(int[] intArray,int alg)
	{
		long firstTime = System.nanoTime();
		long answer = 0;
		
		//run alg
		if(alg==1)
			answer = mss1alg(intArray);
		else if(alg==2)
			answer = mss2alg(intArray);
		else if(alg==3)
			answer = mss3alg(intArray, 0, intArray.length-1);
		else
			answer = mss4alg(intArray);

		//get time
		long lastTime = System.nanoTime();
		long time = lastTime - firstTime;

		//display to user
		System.out.println("Answer: "+answer+"\tTime (nanoseconds): "+time);

	}
	/*This method will implement the first approach to the mss problem.
	 *
	 * @param arr, int[] with the sequence of numbers
	 * @returns an int for the maximum sum
	 * */
     public static long mss1alg(int[] arr)
     {
         long sum = 0,maxSum = 0;
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

	/*This method will implement the second approach to the mss problem.
     *
	 *@param arr, int[] with the sequence of numbers
     *@returns an int for the maximum sum
     * */
	public static long mss2alg(int[] arr)
	{
		long sum=0,maxSum=0;
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

	/*This method will find the maximum sequence sum that goes across the
	 * middle of a sequence.
	 *
	 * @param arr, int[] for the sequence of numbers
	 * @param first, int for the first index
	 * @param mid, int for the middle index
	 * @param last, int for the last index
	 *
	 * @returns the max sum across the middle 
	 *
	 */
	public static long middle(int[] arr, int first,int mid, int last)
	{
		//finding maxLeftBoundSum
		long sum=0, maxLeftSum = 0;
		for(int i = mid; i>= first; i--)
		{
			sum += arr[i];
			if(sum>maxLeftSum)
				maxLeftSum = sum;
		}

		//finding maxRightBoundSum
		long sum2 = 0,maxRightSum = 0;
		for(int i = mid + 1; i<=last; i++)
		{
			sum2 += arr[i];
			if(sum2>maxRightSum)
				maxRightSum = sum2;	
		}

		return Math.max(maxRightSum + maxLeftSum, Math.max(maxLeftSum, maxRightSum));
	}
	/*This method impements the third approach to the mss problem. It uses
	 * recursion and the middle function to find the max of the left and right
	 * sums and the sum across the middle
	 *
	 * @param arr, int[] for the number sequence
	 * @param first, int for the first index
	 * @param last, int for the last index
	 *
	 * @returns an int for the maximum sum
	 * */
     public static long mss3alg(int[] arr, int first, int last)
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
	 /*This method will implement the fourth approach to the mss problem.
      *
      *@param arr, int[] with the sequence of numbers
      *@returns an int for the maximum sum
      * */
	 public static long mss4alg(int[] arr)
	 {
		long maxSum = 0, sum = 0;
		for(int j=0; j<arr.length; j++)
		{
			sum += arr[j];
			if(sum > maxSum)
				maxSum = sum;
			else if(sum < 0)
				sum = 0;
		}
		return maxSum;
	 }

}//end class

