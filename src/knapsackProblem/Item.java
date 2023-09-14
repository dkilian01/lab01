package knapsackProblem;

/**
 * Created by dkilian
 * knapsackProblem.Item class used for storing information of item from knapsack problem
 */
public class Item {
    /**
     * The item value
     */
    private  double value;

    /**
     * The item weight
     */
    private int weight;

    /**
     * This is a constructor to initialize instance object.
     * @param value an initial item value
     * @param weight an initial item weight
     */
    public Item(double value, int weight) {
        setValue(value);
        setWeight(weight);
    }

    /**
     * This is a default constructor
     */
    public Item() {
        this.value = 0;
        this.weight = 0;
    }

    /**
     * Get item value
     * @return item value
     */
    public double getValue() {
        return value;
    }

    /**
     * To set an item value
     * @param value a new item value
     */
    public void setValue(double value) {
        if(value >= 0.0)
            this.value = value;
        else
            this.value = 0.0;
    }

    /**
     * Get item weight
     * @return item weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * To set an item weight
     * @param weight a new item weight
     */
    public void setWeight(int weight) {
        if(weight >= 0)
            this.weight = weight;
        else
            this.weight = 0;
    }

    /**
     * Get item's value to weight ratio
     * @return value to weight ratio
     */
    public double getValueToWeightRatio() {
        return value/weight;
    }

    /**
     * Returns a string representation of the item
     * @return string representation of the item
     */
    @Override
    public String toString() {
        String item_string = "knapsackProblem.Item's value: " + getValue() + ", item's weight: " + getWeight();
        return item_string;
    }
}
