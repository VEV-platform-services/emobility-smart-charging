package com.sap.charging.sim.event;

import java.time.LocalTime;

import org.json.simple.JSONObject;

public class EventFairShare extends Event {

    public EventFairShare(LocalTime timestamp) {
		super(timestamp); 
	}
	
	public EventFairShare(JSONObject jsonObject) {
		super(jsonObject);
	}

    @Override
	public void addChildJSONAttributes(JSONObject object) {
	}

}
