package com.applaudostudios.manager;

public class Setter {

    private int rocketsExplodedAccumulator = 0;
    private int rocketsCrashedAccumulator = 0;
    private int rocketsAccumulator = 0;

    public int getRocketsExplodedAccumulator() {
        return rocketsExplodedAccumulator;
    }

    public int getRocketsCrashedAccumulator() {
        return rocketsCrashedAccumulator;
    }

    public int getRocketsAccumulator() {
        return rocketsAccumulator;
    }

    public void setRocketsExplodedAccumulator(int rocketsExplodedAccumulator) {
        this.rocketsExplodedAccumulator = rocketsExplodedAccumulator;
    }

    public void setRocketsCrashedAccumulator(int rocketsCrashedAccumulator) {
        this.rocketsCrashedAccumulator = rocketsCrashedAccumulator;
    }

    public void setRocketsAccumulator(int rocketsAccumulator) {
        this.rocketsAccumulator = rocketsAccumulator;
    }

}
