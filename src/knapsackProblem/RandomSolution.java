package knapsackProblem;

import knapsackProblem.Algorithm;
import knapsackProblem.Instance;
import knapsackProblem.Item;
import knapsackProblem.Solution;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by dkilian
 * knapsackProblem.Algorithm class used for resolving knapsack problem with random method.
 */
public class RandomSolution extends Algorithm {

    /**
     * This method is returning solution for instance of knapsack problem.
     * It's using random method.
     * @param instance An instance of kanpsack problem.
     * @return knapsackProblem.Solution class instance.
     */
    @Override
    public Solution foundSolution(Instance instance) {
        Random generator = new Random();
        ArrayList<Item> tmpItemList;
        Solution bestSolution = new Solution();
        Solution tmpSolution;
        int randIndex;
        Item tmpItem;

        for (int i = 0; i < 100; i++) {
            tmpItemList = new ArrayList<>(instance.getListOfItems());
            tmpSolution = new Solution();

            while (tmpSolution.getSolutionWeight() < instance.getKnapsackMaxWeight() && !tmpItemList.isEmpty()) {
                randIndex = generator.nextInt(tmpItemList.size());
                tmpItem = tmpItemList.get(randIndex);
                tmpItemList.remove(tmpItem);
                if (tmpSolution.getSolutionWeight() + tmpItem.getWeight() <= instance.getKnapsackMaxWeight()){
                    tmpSolution.addItem(tmpItem);
                }
            }
            if(tmpSolution.getSolutionValue() > bestSolution.getSolutionValue()) bestSolution = tmpSolution;
        }
        return bestSolution;
    }

    /**
     * To get description of this algorithm.
     * @return string with description of this algorithm.
     */
    @Override
    public String showDescription() {
        return "Algorytm rozwiązujący problem plecakowy metodą przeglądu losowego";
    }

    /**
     * To get name of this algorithm.
     * @return string with name of this algorithm.
     */
    @Override
    public String getName() {
        return "Random";
    }
}
