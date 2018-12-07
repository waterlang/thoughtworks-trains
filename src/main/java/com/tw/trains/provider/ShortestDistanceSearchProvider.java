package com.tw.trains.provider;

import com.tw.trains.TownContainer;
import com.tw.trains.model.Town;

public class ShortestDistanceSearchProvider extends BaseSearchProvider {

    private Town start;
    private Town end;
    private String shortedPath;
    private Integer shortedVal = Integer.MAX_VALUE;

    public ShortestDistanceSearchProvider(Town start, Town end, TownContainer container) {
        super(container);
        this.start = start;
        this.end = end;
    }


    @Override
    public Integer search() {
        int  startIdx = this.getIdxByTown(start);
        int endIdx =  this.getIdxByTown(end);
        return getShorestDistance(String.valueOf(startIdx),String.valueOf(endIdx),0);
    }

    private   int getShorestDistance(String path, String end, int pathVal) {
        int[][] graphMatrix = getGraphMatrix();
        int rowIdx = Integer.parseInt( path.substring(path.length() - 1));
        if (path.endsWith(end) && pathVal < shortedVal && pathVal > 0) {
            shortedPath = path;
            shortedVal = pathVal;
            return pathVal;
        }
        for (int i = 0; i < graphMatrix[rowIdx].length; i++) {
            int value = graphMatrix[rowIdx][i];
            if (value > 0) {
                if (path.indexOf(String.valueOf(i)) > 0) {
                    continue;
                } else {
                    if(pathVal > shortedVal){
                        continue;
                    }
                    getShorestDistance(path + i, end, pathVal + value);
                }
            }
        }
        return shortedVal;
    }
}
