import java.util.ArrayList;
import java.util.Random;

public class method2 {


	public static ArrayList<Integer> initialStartingPoint(int n) {
			
	    ArrayList<Integer> generate = new ArrayList<>(n);
	    Random random = new Random();
	   for (int i =0; i<n;i++) {
		   int randomValue = random.nextInt(n);
		   while (generate.contains(randomValue)) {
			   	randomValue = random.nextInt(n) ;           
	        }
		   generate.add(randomValue);
	   }
			
		return generate;
	}
	
	
	

}
