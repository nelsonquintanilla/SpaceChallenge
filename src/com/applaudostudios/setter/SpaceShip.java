package com.applaudostudios.setter;

public interface SpaceShip {
    /**
     * Indicates if the launching was successful or if the rocket has exploded.
     *
     * @return either true or false (a boolean)
     */
    boolean launch();

    /**
     * Indicates if the landing was successful or if the rocket has crashed.
     *
     * @return either true or false (a boolean)
     */
    boolean land();

    /**
     * It evaluates if the rocket can carry such item or if it exceed the weight limit.
     *
     * @param item the current item
     * @return either true or false (a boolean)
     */
    boolean canCarry(Item item);

    /**
     * Updates the current weight of the rocket.
     *
     * @param item the current item.
     */
    void carry(Item item);

}
