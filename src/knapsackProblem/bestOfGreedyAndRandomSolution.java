package knapsackProblem;

import knapsackProblem.Greedy;
import knapsackProblem.RandomSolution;
/**
 * Created by dkilian
 * knapsackProblem.Algorithm class used for resolving knapsack problem with two methods: Greedy and Random solution.
 */
public class bestOfGreedyAndRandomSolution extends Algorithm {

    /**
     * This method is returning best of two solutions for instance of knapsack problem.
     * It's using greedy and random solution methods.
     * @param instance An instance of kanpsack problem.
     * @return knapsackProblem.Solution class instance.
     */
    @Override
    public Solution foundSolution(Instance instance) {
        Solution solutionGreedy = new Greedy().foundSolution(instance);
        Solution solutionRandomSolution = new RandomSolution().foundSolution(instance);
        if(solutionGreedy.getSolutionValue() > solutionRandomSolution.getSolutionValue()) return solutionGreedy;
        else return  solutionRandomSolution;
    }

    /**
     * To get description of this algorithm.
     * @return string with description of this algorithm.
     */
    @Override
    public String showDescription() {
        return "Algorytm rozwiązujący problem plecakowy metodą zachłanną oraz losową. Zwraca lepszy z wyników.";
    }

    @Override
    public String getName() {
        return "bestOfGreedyAndRandomSolution";
    }
}
