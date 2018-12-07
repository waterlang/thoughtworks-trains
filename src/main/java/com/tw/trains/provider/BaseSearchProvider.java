package com.tw.trains.provider;

import com.tw.trains.TownContainer;
import com.tw.trains.model.Town;

public class BaseSearchProvider implements SearchProvider {

    private TownContainer container;

    public BaseSearchProvider(TownContainer container){
        this.container = container;
    }


    @Override
    public Object search() {
        return null;
    }


    protected Integer getIdxByTown(Town town){
        return container.getTownForIdxMap().get(town);
    }

    protected int[][] getGraphMatrix(){
        return container.getGraphMatrix();
    }

}
