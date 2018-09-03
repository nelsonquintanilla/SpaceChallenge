package com.applaudostudios.setter;

public class U2 extends Rocket {

    public U2(int rocketWeight, int maxWeight) {
        super(rocketWeight, maxWeight);
    }

    /**
     * It evaluates if a random probability generated is less or equal to the chance of explode in the launch.
     *
     * @return true or false based on the actual probability (randomly computed) (a boolean)
     */
    @Override
    public boolean launch() {
        int randomProbability = (int) (Math.random() * 100);
        float chanceOfLaunchExplosion = 4 * (getRocketWeight() / getMaxWeight());
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
        float chanceOfLandingCrash = 8 * (getRocketWeight() / getMaxWeight());
        return !(randomProbability <= chanceOfLandingCrash);
    }

}
