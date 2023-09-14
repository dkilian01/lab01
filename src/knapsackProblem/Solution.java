package knapsackProblem;

import java.util.ArrayList;

/**
 * Created by dkilian
 * knapsackProblem.Item class used for storing information about solution of knapsack problem.
 */
public class Solution {
    private ArrayList<Item> listOfItems = new ArrayList<>();
    private int solutionWeight;
    private double solutionValue;

    /**
     * This method is adding item to solution's list of items. It is also summing.
     * weight and values of items object in list.
     * @param item a new item for solution
     */
    public void addItem(Item item){
        listOfItems.add(item);
        solutionWeight += item.getWeight();
        solutionValue += item.getValue();
    }

    /**
     * Get total value of items in solution.
     * @return total solution value
     */
    public double getSolutionValue() {
        return solutionValue;
    }

    /**
     * To set a solution total value.
     * @param solutionValue a new solution total value
     */
    public void setSolutionValue(double solutionValue) {
        this.solutionValue = solutionValue;
    }

    /**
     * This is a constructor to initialize solution object.
     * @param listOfItems an initial solution's item list
     * @param solutionWeight an initial total weight of solution
     * @param solutionValue an initial total value of solution
     */
    public Solution(ArrayList<Item> listOfItems, int solutionWeight, double solutionValue ) {
        this.listOfItems = listOfItems;
        this.solutionWeight = solutionWeight;
        this.solutionValue = solutionValue;
    }

    /**
     * This is a default constructor
     */
    public Solution() {
    }

    /**
     * Get list of items from knapsack problem solution
     * @return list of items
     */
    public ArrayList<Item> getListOfItems() {
        return listOfItems;
    }

    /**
     * To set a list of items for kanpsack problem solution
     * @param listOfItems a new list of items
     */
    public void setListOfItems(ArrayList<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    /**
     * Get total weight of items in knapsack problem solution
     * @return total items wieght
     */
    public int getSolutionWeight() {
        return solutionWeight;
    }

    /**
     * To set a total items weight for knapsack problem solutions
     * @param solutionWeight a new total weight
     */
    public void setSolutionWeight(int solutionWeight) {
        this.solutionWeight = solutionWeight;
    }



    /**
     * Returns a string representation of the solution
     * @return string representation of the solution
     */
    @Override
    public String toString() {
        return "knapsackProblem.Solution{" +
                "solutionValue=" + solutionValue +
                ", solutionWeight=" + solutionWeight +
                ", listOfItems=" + listOfItems +
                '}';
    }
}
