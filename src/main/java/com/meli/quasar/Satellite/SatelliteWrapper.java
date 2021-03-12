package com.meli.quasar.Satellite;

import java.util.ArrayList;
import java.util.List;

public class SatelliteWrapper {

private List<Satellite> satellites = null;

public List<Satellite> getSatellites() {
return satellites;
}

public void setSatellites(List<Satellite> satellites) {
this.satellites = satellites;
}

public double[] getDistances(){

    double [] distances = new double[satellites.size()];
    for(int i = 0; i < satellites.size(); i ++){
        distances[i] = satellites.get(i).getDistance();
    }
    return  distances;
}

public List<List<String>> getMessages(){
    List<List<String>> messages = new ArrayList<List<String>>();
    for(Satellite s : satellites){
        messages.add(s.getMessage());
    }
    return  messages;
}

}