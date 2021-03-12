package com.meli.quasar;

public class PositionSatellites {

    private double posx;
    private double posy;
    private double dist;
    private String name;
     
    public PositionSatellites(String name, double posx, double posy, double dist) {
        super();
        this.name = name;
        this.posx = posx;
        this.posy = posy;
        this.dist = dist;
    }

    public String getname() {
        return name;
    }
    public void setname(String name) {
        this.name = name;
    }
    public double getposx() {
        return posx;
    }
    public void setposx(double posx) {
        this.posx = posx;
    }
    public double getposy() {
        return posy;
    }
    public void setposy(double posy) {
        this.posy = posy;
    }
    public double getdist() {
        return dist;
    }
    public void setdist(double dist) {
        this.dist = dist;
    }

    public PositionSatellites() {
        super();
    }
    
}
