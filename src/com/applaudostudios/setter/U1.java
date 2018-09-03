package com.applaudostudios.setter;

public class U1 extends Rocket {

    public U1(int rocketWeight, int maxWeight) {
        super(rocketWeight, maxWeight);
    }

    /**
     * It evaluates if a random probability generated is less or equal to the chance of explode during the launching.
     *
     * @return true or false based on the actual probability (randomly computed) (a boolean)
     */
    @Override
    public boolean launch() {
        int randomProbability = (int) (Math.random() * 100);
        float chanceOfLaunchExplosion = 5 * (getRocketWeight() / getMaxWeight());
        return !(randomProbability <= chanceOfLaunchExplosion);
    }

    /**
     * It evaluates if a random probability generated is less or equal to the chance of crash during the landing.
     *
     * @return true or false based on the actual probability (randomly computed) (a boolean)
     */
    @Override
    public boolean land() {
        int randomProbability = (int) (Math.random() * 100);
        float chanceOfLandingCrash = 1 * (getRocketWeight() / getMaxWeight());
        return !(randomProbability <= chanceOfLandingCrash);
    }

}
