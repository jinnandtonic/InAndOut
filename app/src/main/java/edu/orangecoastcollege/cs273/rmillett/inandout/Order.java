package edu.orangecoastcollege.cs273.rmillett.inandout;

/**
 * Created by Ryan Millett on 9/28/2017.
 *
 * Class used to model an In-N-Out order
 */
public class Order {
    public static final double PRICE_DOUBLE_DOUBLE = 3.60;
    public static final double PRICE_CHEESEBURGER = 2.15;
    public static final double PRICE_FRENCH_FRIES = 1.65;
    public static final double PRICE_SHAKE = 2.20;
    public static final double PRICE_SMALL_DRINK = 1.45;
    public static final double PRICE_MEDIUM_DRINK = 1.55;
    public static final double PRICE_LARGE_DRINK = 1.75;
    public static final double TAX_RATE = 0.08;

    private int mDoubleDouble;
    private int mCheeseburgers;
    private int mFrenchFries;
    private int mShakes;
    private int mSmallDrinks;
    private int mMediumDrinks;
    private int mLargeDrinks;

    /**
     * Gets number of DoubleDoubles ordered
     * @return
     */
    public int getDoubleDouble() {
        return mDoubleDouble;
    }

    /**
     * Sets number of DoubleDoubles ordered
     * @param doubleDouble
     */
    public void setDoubleDouble(int doubleDouble) {
        mDoubleDouble = doubleDouble;
    }

    /**
     * Gets number of Cheeseburgers ordered
     * @return
     */
    public int getCheeseburgers() {
        return mCheeseburgers;
    }

    /**
     * Sets number of Cheeseburgers ordered
     * @param cheeseburgers
     */
    public void setCheeseburgers(int cheeseburgers) {
        mCheeseburgers = cheeseburgers;
    }

    /**
     * Gets number of FrenchFries ordered
     * @return
     */
    public int getFrenchFries() {
        return mFrenchFries;
    }

    /**
     * Sets number of French Fries ordered
     * @param frenchFries
     */
    public void setFrenchFries(int frenchFries) {
        mFrenchFries = frenchFries;
    }

    /**
     * Gets number of Shakes ordered
     * @return
     */
    public int getShakes() {
        return mShakes;
    }

    /**
     * Sets number of Shakes ordered
     * @param shakes
     */
    public void setShakes(int shakes) {
        mShakes = shakes;
    }

    /**
     * Gets number of Small Drinks ordered
     * @return
     */
    public int getSmallDrinks() {
        return mSmallDrinks;
    }

    /**
     * Sets number of Small Drinks ordered
     * @param smallDrinks
     */
    public void setSmallDrinks(int smallDrinks) {
        mSmallDrinks = smallDrinks;
    }

    /**
     * Gets number of Medium Drinks ordered
     * @return
     */
    public int getMediumDrinks() {
        return mMediumDrinks;
    }

    /**
     * Sets number of Medium Drinks ordered
     * @param mediumDrinks
     */
    public void setMediumDrinks(int mediumDrinks) {
        mMediumDrinks = mediumDrinks;
    }

    /**
     * Gets number of Large Drinks ordered
     * @return
     */
    public int getLargeDrinks() {
        return mLargeDrinks;
    }

    /**
     * Sets number of Large Drinks ordered
     * @param largeDrinks
     */
    public void setLargeDrinks(int largeDrinks) {
        mLargeDrinks = largeDrinks;
    }

    /**
     * Gets number of items ordered
     * @return
     */
    public int getNumberItemsOrdered() {
        return getDoubleDouble() + getCheeseburgers() + getFrenchFries() + getShakes()
                + getSmallDrinks() + getMediumDrinks() + getLargeDrinks();
    }

    /**
     * Calculates the order subtotal
     * @return double representing order subtotal
     */
    public double calculateSubtotal() {
        double subTotal = 0.0;

        subTotal += getDoubleDouble() * PRICE_DOUBLE_DOUBLE;
        subTotal += getCheeseburgers() * PRICE_CHEESEBURGER;
        subTotal += getFrenchFries() * PRICE_FRENCH_FRIES;
        subTotal += getShakes() * PRICE_SHAKE;
        subTotal += getSmallDrinks() * PRICE_SMALL_DRINK;
        subTotal += getMediumDrinks() * PRICE_MEDIUM_DRINK;
        subTotal += getLargeDrinks() * PRICE_LARGE_DRINK;

        return subTotal;
    }

    /**
     * Calculates the order tax
     * @return double representing order tax
     */
    public double calculateTax() {
        return calculateSubtotal() * TAX_RATE;
    }

    /**
     * Calculates order total
     * @return double representing order total
     */
    public double calculateTotal() {
        return calculateSubtotal() + calculateTax();
    }
}
