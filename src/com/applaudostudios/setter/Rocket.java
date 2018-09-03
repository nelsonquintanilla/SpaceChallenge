package com.applaudostudios.setter;

public class Rocket implements SpaceShip {

    private float mRocketWeight; // In kg.
    private float mMaxWeight; // In kg (both cargo and rocket considered).

    public float getRocketWeight() {
        return mRocketWeight;
    }

    public float getMaxWeight() {
        return mMaxWeight;
    }

    public Rocket(int rocketWeight, int maxWeight) {
        mRocketWeight = rocketWeight;
        mMaxWeight = maxWeight;
    }

    /**
     * Indicates that the launching was successful.
     *
     * @return true (a boolean)
     */
    @Override
    public boolean launch() {
        return true;
    }

    /**
     * Indicates that the landing was successful.
     *
     * @return true (a boolean)
     */
    @Override
    public boolean land() {
        return true;
    }

    /**
     * It evaluates if the rocket can carry such item or if it exceed the weight limit.
     *
     * @param item the current item
     * @return either true or false (a boolean)
     */
    @Override
    public final boolean canCarry(Item item) {
        return (mRocketWeight + item.getWeight()) <= mMaxWeight;
    }

    /**
     * Updates the current weight of the rocket.
     *
     * @param item the current item.
     */
    @Override
    public final void carry(Item item) {
        mRocketWeight += item.getWeight();
    }

}
