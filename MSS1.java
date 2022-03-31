/*comments :) */
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


		
	}
}

