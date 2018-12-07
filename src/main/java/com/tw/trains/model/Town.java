package com.tw.trains.model;

import java.util.Objects;

public class Town implements Comparable{
    private String identify;

    @Override
    public int compareTo(Object o) {
        if(o instanceof  Town){
            Town town = (Town)o;
            return this.getIdentify().compareTo(town.getIdentify());
        }
        return -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return Objects.equals(identify, town.identify);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identify);
    }

    public String getIdentify() {
        return identify;
    }

    public void setIdentify(String identify) {
        this.identify = identify;
    }

}
