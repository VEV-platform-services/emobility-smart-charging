package com.sap.charging.realTime.util;

import com.sap.charging.model.Car;
import com.sap.charging.sim.Simulation;
import com.sap.charging.util.Loggable;

public class Scheduler implements Loggable{

    @Override
    public int getVerbosity() {
        return Simulation.verbosity;
    }

    public void initializeChargingPlan(Car car, int minimalCurrent){
        log(2, "Initializing charging plan for car " + car.getId() + " with minimal current " + minimalCurrent);
        for (int i = 0; i < 20; i++) {
            car.getCurrentPlan()[i] = minimalCurrent;
        }
    }
    
}
