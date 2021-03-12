package com.meli.quasar.Satellite;

import java.util.List;

public class Satellite {

private String name;
private Double distance;
private List<String> message = null;

public Satellite(String satellite_name, Double distance, List<String> message) {
    this.name=satellite_name;
    this.distance=distance;
    this.message=message;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public Double getDistance() {
return distance;
}

public void setDistance(Double distance) {
this.distance = distance;
}

public List<String> getMessage() {
return message;
}

public void setMessage(List<String> message) {
this.message = message;
}

}