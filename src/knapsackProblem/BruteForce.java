package knapsackProblem;

/**
 * Created by dkilian
 * knapsackProblem.Algorithm class used for resolving knapsack problem with Brute Force method.
 */
public class BruteForce extends Algorithm {

    /**
     * This method is returning solution for instance of knapsack problem.
     * It's using brute force method.
     * @param instance An instance of kanpsack problem.
     * @return knapsackProblem.Solution class instance.
     */
    @Override
    public Solution foundSolution(Instance instance) {
        Solution tmpSolution;
        Solution solution = new Solution();
        int n = instance.getListOfItems().size();
        for (int i = 0; i < 1 << n; i++) {
            tmpSolution = new Solution();
            for (int j = 0; j < n; j++) {
                if((1 << j & i) != 0){
                    tmpSolution.addItem(instance.getListOfItems().get(j));
                }
            }
            if (tmpSolution.getSolutionWeight() <= instance.getKnapsackMaxWeight() && tmpSolution.getSolutionValue() > solution.getSolutionValue()){
                solution = tmpSolution;
            }
        }
        return solution;
    }

    /**
     * To get description of this algorithm.
     * @return string with description of this algorithm.
     */
    @Override
    public String showDescription() {
        return "Algorytm rozwiązujący problem plecakowy metodą przeglądu zupelnego \"bruteforce, metoda silowa\".";
    }

    /**
     * To get name of this algorithm.
     * @return string with name of this algorithm.
     */
    @Override
    public String getName() {
        return "Brute force";
    }


}
