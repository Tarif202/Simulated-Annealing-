import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class method3 {
	 static int[][] matrix = {
	            {0, 3, 6},
	            {3, 0, 5},
	            {6, 5, 0}
	            
	        };
	 
	
	public static void main(String[] args) {
		 ArrayList<Integer> solution = new ArrayList<>();
	 	{
	 	solution.add(10);
		solution.add(30);
		solution.add(15);
		;
		}
	 	
		
		
		 
	//	  System.out.println(solution);
	//	  System.out.println(size);
		 System.out.println(method3check(solution, matrix));
	}
	
	
	public static int method3check(ArrayList<Integer> solution, int[][] martin) {
		 for (int i = 0; i < matrix.length; i++) {
	            int check = matrix[i].length;
	            if (check != matrix.length) {
	                return -1;
	            }
	        }

	        for (int j = 0; j < matrix.length; j++) {
	            if (matrix[j][j] != 0) {
	                return -1;
	            }
	            else {
	                for (int k = 0; k < matrix.length; k++) {
	                    if (matrix[j][k] < 0) {
	                        return -1;
	                    }
	                }
	                for (int z = 0; z < matrix.length; z++) {
	                    for (int p = 0; p < matrix.length; p++) {
	                        if (matrix[z][p] != matrix[p][z])
	                            return -1;
	                    }
	                }
	            }
	        }
		 int size = solution.size();
		 if (size!=martin[1].length) {
			 return -1; 	
			 
		 
		 }
		 
		 Set<Integer> unique = new HashSet<>();

		 for (int i = 0; i < solution.size(); i++) {
		     Integer num = solution.get(i);
		     if (!unique.add(num)) {
		         return -1; // Found a duplicate
		     }
		 }

		 return 1;
			
		 
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
