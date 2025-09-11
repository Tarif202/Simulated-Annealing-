import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MultiClass {
    static double[][] matrix = {
        {0, 18, 51, 58, 58, 83, 81, 100, 93, 112, 106, 118, 131, 168, 163},
        {18, 0, 46, 24, 37, 76, 64, 99, 75, 87, 127, 121, 147, 135, 160},
        {51, 46, 0, 28, 43, 49, 51, 79, 70, 78, 109, 95, 117, 127, 129},
        {58, 24, 28, 0, 18, 48, 33, 60, 77, 80, 94, 88, 101, 115, 126},
        {58, 37, 43, 18, 0, 33, 20, 36, 58, 78, 67, 83, 113, 97, 129},
        {83, 76, 49, 48, 33, 0, 49, 29, 57, 43, 80, 62, 108, 87, 93},
        {81, 64, 51, 33, 20, 49, 0, 16, 21, 59, 56, 84, 67, 106, 107},
        {100, 99, 79, 60, 36, 29, 16, 0, 45, 26, 59, 73, 84, 90, 97},
        {93, 75, 70, 77, 58, 57, 21, 45, 0, 33, 31, 54, 48, 73, 95},
        {112, 87, 78, 80, 78, 43, 59, 26, 33, 0, 42, 46, 39, 69, 88},
        {106, 127, 109, 94, 67, 80, 56, 59, 31, 42, 0, 25, 30, 30, 58},
        {118, 121, 95, 88, 83, 62, 84, 73, 54, 46, 25, 0, 40, 28, 39},
        {131, 147, 117, 101, 113, 108, 67, 84, 48, 39, 30, 40, 0, 29, 46},
        {168, 135, 127, 115, 97, 87, 106, 90, 73, 69, 30, 28, 29, 0, 34},
        {163, 160, 129, 126, 129, 93, 107, 97, 95, 88, 58, 39, 46, 34, 0}
    };

    public static void main(String[] args) {
        double result = TSP(15, matrix, 1000);
        System.out.println("Final result: " + result);
    }

    public static double TSP(int numCities, double[][] distanceMatrix, int iterations) {
      
        
        ArrayList<Integer> updatedTour = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        ArrayList<Integer> bestTour = new ArrayList<>();
        Random random = new Random();
        double minCoolingRate = 0.7;
        double maxCoolingRate = 0.95;
        int iterationsSinceImprovement = 0;
        int stuckThreshold = 10;
        double currFitness = 0;
        double updatedFitness = 0;
        double bestFitness = 0;
        double coolingRate = 0.8;

        double temp = 1000;
        int iteration = iterations;

        method1.checkSquare(distanceMatrix);

        current = method2.initialStartingPoint(numCities);
        System.out.println("Initialtour: " + current);
        boolean x = method3.method3check(current, distanceMatrix);

        if (x == true) {
            currFitness = method4.method4check(current, distanceMatrix);
            bestTour = new ArrayList<>(current);
            bestFitness = currFitness;
            
            // Record initial fitness values
            iterationFitnessList.add(currFitness);
            bestFitnessList.add(bestFitness);

            for (int i = 0; i < iteration; i++) {
                long startTime = System.currentTimeMillis();
                updatedTour = improvedMethod5.ChangedTour(new ArrayList<>(current));
                
                updatedFitness = method4.method4check(updatedTour, distanceMatrix);

                // passes only when the new one is not good
                if (updatedFitness > currFitness) {  // Worse solution
                    double deltaChange = -(updatedFitness - currFitness); // Make negative for worse solutions
                    double p = Math.exp(deltaChange / temp);  // Now p will be between 0 and 1
                    double r = random.nextDouble();
                    if (p > r) {
                        current = new ArrayList<>(updatedTour);
                        currFitness = updatedFitness;
                    }
                } else {
                    current = new ArrayList<>(updatedTour);
                    currFitness = updatedFitness;
                }

                if (currFitness < bestFitness) {
                    bestTour = new ArrayList<>(current);
                    bestFitness = currFitness;
                    coolingRate = Math.min(maxCoolingRate, coolingRate + 0.05);
                    iterationsSinceImprovement = 0;
                } else {
                    iterationsSinceImprovement++;
                    
                    // speed up cooling to escape local optima
                    if (iterationsSinceImprovement > stuckThreshold) {
                        coolingRate = Math.max(minCoolingRate, coolingRate - 0.02);
                        iterationsSinceImprovement = 0; // Reset counter
                    }
                }
                
                // Record fitness values for this iteration
                iterationFitnessList.add(updatedFitness);
                bestFitnessList.add(bestFitness);
                
                temp = temp * coolingRate;
                long endTime = System.currentTimeMillis();
                long duration = endTime - startTime;
                System.out.println("Iteration execution time: " + duration + " milliseconds");
            }
        } else {
            return bestFitness;  // return best tour
        }

        return bestFitness;
    }
}
