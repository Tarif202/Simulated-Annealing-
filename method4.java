import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class method4 {
static List<Integer> solution = new ArrayList<>(Arrays.asList(5, 4, 2, 6, 3, 0, 1));
	public static int method4check(List<Integer> solution, int[][] martin) {
		int fitnessSum=0;
		int backToSquare1=0;
		int length = solution.size();
		int finalCity=length-1; // 7 
		 for (int i = 0; i < length; i++) {
			 	if(i!=finalCity) {
				 	int x = solution.get(i);
					 int y = solution.get(i+1);					 
					 int  dist = matrix[x][y];
					 System.out.println(dist);
					 
					  fitnessSum += dist;
					  
			 }
			 	else {
			 		int z = solution.get(length-1);
			 		int firstCity = solution.get(0);
			 		backToSquare1 = matrix[firstCity][z];
			 	
			 	}
		 }
			 
	
		 fitnessSum = fitnessSum+backToSquare1;
	
		return fitnessSum;}
}
