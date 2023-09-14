package knapsackProblem;

import knapsackProblem.Solution;

/**
 * Created by dkilian
 * This is a abstract class which are base for class resolving knapsack problem.
 * Algoritm abstract class used for implementation algorithms solving knapsack problem.
 */
public abstract class Algorithm {
    /**
     * Abstract method to get solution of an instance.
     * @param instance class used for storing instance of knapsack problem.
     * @return knapsackProblem.Solution class object containing the solution for instance of knapsack problem.
     */
    public abstract Solution foundSolution(Instance instance);

    /**
     * Abstract method to get description of the algorithm.
     * @return string with description of the algorithm.
     */
    public abstract String showDescription();

    /**
     * Abstract method to get name of the algorithm.
     * @return string with name of the algorithm.
     */
    public abstract String getName();
}
