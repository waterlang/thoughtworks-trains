package com.tw.trains.model;

public class TownRoute {
    private Town parent;
    private Town target;
    private Integer distance;

    public TownRoute(){

    }

    public TownRoute(Town parent,Town target,Integer distance){
        this.parent = parent;
        this.target = target;
        this.distance = distance;
    }


    public Town getParent() {
        return parent;
    }

    public void setParent(Town parent) {
        this.parent = parent;
    }

    public Town getTarget() {
        return target;
    }

    public void setTarget(Town target) {
        this.target = target;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
