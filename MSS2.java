import java.io.*;
import java.util.Scanner;

public class MSS2 {
	public static void main(String[] args){
		BufferedReader input;
		String inputLine;
		String rerun = "";
		Scanner scan = new Scanner(System.in);
		String[] strArr;

		do {
			//reading in the file
			try
			{
				//declare variables
				//int[] intArray;
			//	int time1 = 0, time2 = 0, time3 = 0, time4 = 0, firstTime = 0, lastTime = 0;
	
				//TODO change file input to variable
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
	
				//user input
				int choice = scan.nextInt();
				while(choice<1 || choice>5)
				{
					System.out.println("\nError: Please enter 1 to 5");
					choice = scan.nextInt();
				}


				input = new BufferedReader(new FileReader(user_input));
				//if((inputLine = input.readLine()) != null) 
				inputLine = input.readLine();	
				strArr = inputLine.split(",");
				input.close();	
			
				//convert string array into int array
				int[] intArray = new int[strArr.length];
				for(int i=0; i<strArr.length; i++)
					intArray[i] = Integer.parseInt(strArr[i]);
				
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
	
				//	System.out.println("\nMSS1 answer: "+mss1ans+"\nMSS2 answer: "+mss2ans
				//						+ "\nMSS3 answer: " +mss3ans+"\nMSS4 answer: "+mss4ans);
				//}
			

			} //end try
			catch (FileNotFoundException e)
			{
				System.out.println("\nFile not found, please enter a valid file name.");
				System.exit(1);
			} // catch
			catch (IOException e)
			{
				System.out.println(e.getMessage());
				System.exit(1);
			} // end catch
		
			
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

	public static void runAlgs(int[] intArray,int alg)
	{
		long firstTime = System.nanoTime();
		int answer = 0;
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
		System.out.println("Answer: "+answer+"\tTime: "+time);

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
	 /*method for mss4*/
	 public static int mss4alg(int[] arr)
	 {
		int maxSum = 0, sum = 0;
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
}

