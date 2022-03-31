import java.io.*;

public class MSS2 {
	public static void main(String[] args){
		BufferedReader input;
		StringTokenizer line;
		String inputLine;
		int maxSum = 0;
		int sum = 0;
		
		//reading in the file


		for(int i=0; i<n; i++){
			sum = 0;
			for(int j=i; j<n-1; j++){
				sum += a[j];
				if(sum > maxSum)
					maxSum = sum;
			}
		}
	}
}

