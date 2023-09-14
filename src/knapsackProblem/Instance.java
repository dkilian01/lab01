package knapsackProblem;

import java.util.ArrayList;

/**
 * Created by dkilian
 * knapsackProblem.Instance class used for storing instance of knapsack problem
 */
public class Instance {
    /**
     * Weight limit for items storing in knapsack
     */
    private int knapsackMaxWeight;

    /**
     * List of available items
     */
    private ArrayList<Item> listOfItems = new ArrayList<>();

    /**
     * This method is generating instance of knapsack problem from seed.
     * @param seed long format seed for new problem instance.
     */
    public void generateInstanceFromLong(long seed, int itemsMaxNumber){
        int itemsNumber = 0;
        int dzielnik = 31;
        while(itemsNumber < 1 || itemsNumber > itemsMaxNumber){
            itemsNumber = Math.toIntExact(seed) % dzielnik;
            dzielnik--;
        }
        knapsackMaxWeight = 16 * itemsNumber + (int)(0.6 * Math.toIntExact(seed));
        listOfItems = new ArrayList<>();
        for(int i = 1; i <= itemsNumber; i++){
            Double weight = (i / (double)(itemsNumber + 1)) * (knapsackMaxWeight);
            Double value = (0.5 * weight) +  (Math.toIntExact(seed) % i) * Math.pow(10.0, String.valueOf(knapsackMaxWeight).length());
            Float float_value = value.floatValue() * 100;
            int temp = float_value.intValue();
            float_value = (float) (temp /100.0);
            addItem(new Item(float_value,weight.intValue()));
        }
    }


    /**
     * This is a constructor to initialize instance object.
     * @param knapsackMaxWeight an initial knapsack weight limit
     * @param listOfItems an initial list of items
     */
    public Instance(int knapsackMaxWeight, ArrayList<Item> listOfItems) {
        setKnapsack_max_weight(knapsackMaxWeight);
        setListOfItems(listOfItems);
    }

    /**
     * This is a default constructor
     */
    public Instance() {
    }

    /**
     * Get knapsack weight limit
     * @return knapsack weight limit
     */
    public int getKnapsackMaxWeight() {
        return knapsackMaxWeight;
    }

    /**
     * To set a knapsack weight limit
     * @param knapsackMaxWeight a new knapsack weight limit
     */
    public void setKnapsack_max_weight(int knapsackMaxWeight) {
        if(knapsackMaxWeight >= 0)
            this.knapsackMaxWeight = knapsackMaxWeight;
        else
            this.knapsackMaxWeight = 0;
    }

    /**
     * Get list of items
     * @return list of items
     */
    public ArrayList<Item> getListOfItems() {
        return listOfItems;
    }

    /**
     * To set list of items
     * @param listOfItems a new list of items for this instance
     */
    public void setListOfItems(ArrayList<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    /**
     * Returns a string representation of the instance
     * @return string representation of the instance
     */
    @Override
    public String toString() {
        return "knapsackProblem.Instance{" +
                "knapsackMaxWeight=" + knapsackMaxWeight +
                '}';
    }

    /**
     * This method is adding item to instance's list of items.
     * @param item The item to add.
     */
    public void addItem(Item item){
        listOfItems.add(item);
    }

    /**
     * This method is removing item from instance's list of items.
     * @param item The item to remove.
     */
    public void removeItem(Item item){
        listOfItems.remove(item);
    }

}
