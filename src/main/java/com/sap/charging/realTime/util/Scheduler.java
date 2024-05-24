package com.sap.charging.realTime.util;

import java.util.Arrays;

import com.sap.charging.model.Car;
import com.sap.charging.model.ChargingStation;
import com.sap.charging.model.EnergyUtil.Phase;
import com.sap.charging.sim.Simulation;
import com.sap.charging.util.Loggable;

public class Scheduler implements Loggable{

    @Override
    public int getVerbosity() {
        return Simulation.verbosity;
    }

    public void distributeEnergy(Car car, double minimalCurrent, double attributedCurrent, ChargingStation charger){
        // TODO: remove this code and make a strict check for the minimal current attributed in vev-server backend
        if(attributedCurrent < minimalCurrent){
            log(2, "Attributed current " + attributedCurrent + " is smaller than minimal current " + minimalCurrent + " for car " + car.getId());
            Arrays.fill(car.getCurrentPlan(), minimalCurrent);
        }else{
            log(2, "Initializing charging plan for car " + car.getId() + " with minimal current " + minimalCurrent);
            Arrays.fill(car.getCurrentPlan(), Math.min(Math.min(attributedCurrent, car.maxCurrentPerPhase),charger.getFusePhase(Phase.PHASE_1)));
            
        }
        
    }
}
