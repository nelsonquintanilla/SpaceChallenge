package com.applaudostudios.manager;

import com.applaudostudios.setter.Rocket;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        Simulation simulation = new Simulation();
        List<Rocket> fleetOfU1RocketsForPhase1 = simulation.loadU1("phase_1.txt");
        List<Rocket> fleetOfU1RocketsForPhase2 = simulation.loadU1("phase_2.txt");
        List<Rocket> allU1Rockets = simulation.completeFleet(fleetOfU1RocketsForPhase1, fleetOfU1RocketsForPhase2);
        Setter U1SimulationResults = simulation.runSimulation(allU1Rockets);
        int U1totalOfU1Rockets = U1SimulationResults.getRocketsAccumulator() + U1SimulationResults.getRocketsExplodedAccumulator() + U1SimulationResults.getRocketsCrashedAccumulator();
        System.out.println("Total of budget required to send all U1 Rockets is $" + 100 * U1totalOfU1Rockets + " Millions.");
        System.out.println("Total of U1 Rockets sent to Mars: " + U1totalOfU1Rockets + ".");
        System.out.println("Total of exploded U1 Rockets: " + U1SimulationResults.getRocketsExplodedAccumulator() + ".");
        System.out.println("Total of crashed U1 Rockets: " + U1SimulationResults.getRocketsCrashedAccumulator() + ".\n");

        List<Rocket> fleetOfU2RocketsForPhase1 = simulation.loadU2("phase_1.txt");
        List<Rocket> fleetOfU2RocketsForPhase2 = simulation.loadU2("phase_2.txt");
        List<Rocket> allU2Rockets = simulation.completeFleet(fleetOfU2RocketsForPhase1, fleetOfU2RocketsForPhase2);
        Setter U2SimulationResults = simulation.runSimulation(allU2Rockets);
        int U2totalOfU2Rockets = U2SimulationResults.getRocketsAccumulator() + U2SimulationResults.getRocketsExplodedAccumulator() + U2SimulationResults.getRocketsCrashedAccumulator();
        System.out.println("Total of budget required to send all U1 Rockets is $" + 100 * U2totalOfU2Rockets + " Millions.");
        System.out.println("Total of U2 Rockets sent to Mars: " + U2totalOfU2Rockets + ".");
        System.out.println("Total of exploded U2 Rockets: " + U2SimulationResults.getRocketsExplodedAccumulator() + ".");
        System.out.println("Total of U2 crashed Rockets: " + U2SimulationResults.getRocketsCrashedAccumulator() + ".");

    }

}
