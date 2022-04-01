import java.io.*;
import java.util.Scanner;

public class MSS2 {
	public static void main(String[] args){
		BufferedReader input;
		String inputLine;
		int maxSum = 0;
		int sum = 0;

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
			
			
				//MSS2 Algorithm
				for(int i=0; i<intArray.length; i++){
					sum = 0;
					for(int j=i; j<intArray.length-1; j++){
						sum += intArray[j];
						if(sum > maxSum)
							maxSum = sum;
					}
				}

				System.out.println(maxSum);
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
}

