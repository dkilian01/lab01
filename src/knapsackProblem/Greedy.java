package knapsackProblem;

import knapsackProblem.Algorithm;
import knapsackProblem.Solution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created by dkilian
 * knapsackProblem.Algorithm class used for resolving knapsack problem with knapsackProblem.Greedy method.
 */
public class Greedy extends Algorithm {

    /**
     * Private class used for storing value to weight ratio and an index.
     */
    private class ValueToWeightRatio{
        /**
         * The value to weight ratio.
         */
        private double valueToWeightRatio;

        /**
         * The index from a list.
         */
        private int index;

        /**
         * This is a constructor to initialize ValueToWeightRatio object.
         * @param valueToWeightRatio an initial value of ratio
         * @param index an initial index value
         */
        public ValueToWeightRatio(double valueToWeightRatio, int index) {
            this.valueToWeightRatio = valueToWeightRatio;
            this.index = index;
        }

        /**
         * This i a default constructor
         */
        public ValueToWeightRatio() {
        }

        /**
         * Get ratio value.
         * @return value to weight ratio.
         */
        public double getValueToWeightRatio() {
            return valueToWeightRatio;
        }

        /**
         * To set item value to weight ratio.
         * @param valueToWeightRatio item value to weight ratio.
         */
        public void setValueToWeightRatio(double valueToWeightRatio) {
            this.valueToWeightRatio = valueToWeightRatio;
        }

        /**
         * Get item index from items list.
         * @return item index.
         */
        public int getIndex() {
            return index;
        }

        /**
         * To set item index in list of items.
         * @param index a new index value.
         */
        public void setIndex(int index) {
            this.index = index;
        }

        /**
         * Returns a string representation of valueToWeightRatio object.
         * @return string representation of the valueToWeightRatio object.
         */
        @Override
        public String toString() {
            return "ValueToWeightRatio{" +
                    "valueToWeightRatio=" + valueToWeightRatio +
                    ", index=" + index +
                    '}';
        }
    }

    /**
     * This method is returning solution for instance of knapsack problem.
     * It's using greedy method.
     * @param instance An instance of kanpsack problem.
     * @return knapsackProblem.Solution class instance.
     */
    @Override
    public Solution foundSolution(Instance instance) {
        ArrayList<ValueToWeightRatio> valueToWeightRatioArray = new ArrayList<>();
        int i = 0;
        double vToW_ratio;
        for(Item item : instance.getListOfItems()){
            vToW_ratio = item.getValue() / item.getWeight();
            valueToWeightRatioArray.add(new ValueToWeightRatio(vToW_ratio, i));
            i++;
        }
        valueToWeightRatioArray.sort(Comparator.comparing(ValueToWeightRatio::getValueToWeightRatio).reversed());
        Solution solution = new Solution();
        Iterator<ValueToWeightRatio> it = valueToWeightRatioArray.iterator();

        while(solution.getSolutionWeight() < instance.getKnapsackMaxWeight() && it.hasNext()){
            ValueToWeightRatio nextVToW = it.next();
            if(solution.getSolutionWeight() + instance.getListOfItems().get(nextVToW.index).getWeight() <= instance.getKnapsackMaxWeight()){
                solution.addItem(instance.getListOfItems().get(nextVToW.index));
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
        return "Algorytm rozwiązujący problem plecakowy metodą zachłanną \"greedy\".";
    }

    /**
     * To get name of this algorithm.
     * @return string with name of this algorithm.
     */
    @Override
    public String getName() {
        return "Greedy";
    }
}
