**CS2004 Algorithms and Applications - Travelling Salesperson Problem Implementation**

**Project Overview**

Successfully completed a comprehensive Java programming assignment implementing a heuristic search solution for the classic Travelling Salesperson Problem (TSP). 
This substantial coursework required developing a complete algorithmic framework capable of finding near-optimal solutions to the NP-hard combinatorial 
optimization problem using simulated annealing as the core optimization strategy.

**Technical Implementation**

The implementation consisted of six progressive components that build toward a complete TSP solver. The matrix validation system provides robust validation for distance matrices, ensuring they meet the required mathematical properties of being square and symmetric with non-negative distances and zero diagonal elements. The tour generation and validation components create algorithms for generating valid initial permutation-based tours and validating complete tour solutions against the problem constraints. 

**Core Algorithmic Components**

The fitness function calculator forms the heart of the optimization system, efficiently evaluating tour quality by calculating total travel costs using the standard mathematical formula for tour optimization. The small change operator implements solution modification techniques using permutation swapping to systematically explore the solution space. The complete heuristic search algorithm brings together all components in a simulated annealing framework, utilizing temperature-based acceptance criteria to balance exploitation and exploration while avoiding local optima through controlled probabilistic acceptance of worse solutions.

**Simulated Annealing Implementation**

The simulated annealing algorithm implementation incorporates a sophisticated cooling schedule that gradually reduces the acceptance probability of inferior solutions over time. This approach allows the algorithm to initially explore the solution space broadly before converging toward optimal regions. The temperature parameter controls the probability of accepting worse solutions, enabling the algorithm to escape local optima in the early stages while focusing on refinement as the temperature decreases. The implementation includes customizable iteration limits and temperature schedules to adapt to different problem scales and computational constraints.
