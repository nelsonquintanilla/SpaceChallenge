package com.applaudostudios.manager;

import com.applaudostudios.setter.Item;
import com.applaudostudios.setter.Rocket;
import com.applaudostudios.setter.U1;
import com.applaudostudios.setter.U2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Simulation {
    /**
     * It scans the text file. Then line by line splits the item name and the item value and stores them as fields
     * of an values object. All of these objects are stored in an items array.
     *
     * @param fileName the name of the file containing the items
     * @return array of items (a List<Item>)
     */
    private List<Item> loadItems(String fileName) {
        List<Item> items = new ArrayList<>();
        File file = new File(fileName);
        Scanner phase = null;

        try {
            phase = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("***Some file is missing!!!***");
        }

        if (phase != null) {
            while (phase.hasNextLine()) {
                Item values = new Item();
                String[] line = phase.nextLine().split("=");
                values.setName(line[0]);
                values.setWeight(Integer.parseInt(line[1]));
                items.add(values);
            }
        }
        return items;
    }

    /**
     * Takes the ArrayList of Items returned from loadItems and starts creating U1 rockets. It first tries to
     * fill up 1 rocket with as many items as possible before creating a new rocket object and filling that one
     * until all items are loaded.
     *
     * @param filename the name of the file containing the items
     * @return array of U1 rockets (a List<Rocket>)
     */
    public List<Rocket> loadU1(String filename) {
        Rocket rocketU1 = new U1(10000, 18000);
        List<Rocket> accumulatorOfRockets = new ArrayList<>();
        List<Item> currentItem = loadItems(filename);
        for (int i = 0; i < currentItem.size(); i++) {
            if (rocketU1.canCarry(currentItem.get(i))) {
                rocketU1.carry(currentItem.get(i));
            } else {
                accumulatorOfRockets.add(rocketU1);
                i--;
                rocketU1 = new U1(10000, 18000);
            }
        }
        accumulatorOfRockets.add(rocketU1);
        return accumulatorOfRockets;
    }

    /**
     * Takes the ArrayList of Items and starts creating U2 rockets and filling them with those items the same
     * way as with U1 until all items are loaded.
     *
     * @param filename the name of the file containing the items
     * @return array of U1 rockets (a List<Rocket>)
     */
    public List<Rocket> loadU2(String filename) {
        Rocket rocketU2 = new U2(18000, 29000);
        List<Rocket> accumulatorOfRockets = new ArrayList<>();
        List<Item> currentItem = loadItems(filename);
        for (int i = 0; i < currentItem.size(); i++) {
            if (rocketU2.canCarry(currentItem.get(i))) {
                rocketU2.carry(currentItem.get(i));
            } else {
                accumulatorOfRockets.add(rocketU2);
                i--;
                rocketU2 = new U2(18000, 29000);
            }
        }
        accumulatorOfRockets.add(rocketU2);
        return accumulatorOfRockets;
    }

    /**
     * This method takes the fleet of rockets for each phase and stores both fleets in a single allRockets array.
     *
     * @param fleetOfRockets the fleet of rockets made for each phase
     * @return array of all the rockets for both phases (a List<Rocket>)
     */
    public List<Rocket> completeFleet(List<Rocket>... fleetOfRockets) {
        List<Rocket> allRockets = new ArrayList<>();
        allRockets.addAll(fleetOfRockets[0]);
        allRockets.addAll(fleetOfRockets[1]);
        return allRockets;
    }

    /**
     * Takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList.
     * Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to send that rocket
     * again.
     *
     * @param rocket each rocket of the allRockets array return by the completeFleet method
     * @return setter object (a Setter)
     */
    public Setter runSimulation(List<Rocket> rocket) {
        Setter setter = new Setter();
        setter.setRocketsAccumulator(rocket.size());
        int counter1 = 0;
        int counter2 = 0;
        for (Rocket aRocket : rocket) {
            if (!aRocket.launch()) {
                counter1++;
            }
            if (!aRocket.land()) {
                counter2++;
            }

        }
        setter.setRocketsExplodedAccumulator(counter1);
        setter.setRocketsCrashedAccumulator(counter2);
        return setter;
    }

}
