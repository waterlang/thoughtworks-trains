package com.tw.trains.provider;

import com.tw.trains.TownContainer;
import com.tw.trains.model.Town;

import java.util.ArrayList;
import java.util.List;

public class CountMaxDistanceSearchProvider extends BaseSearchProvider {

    private Town start;
    private Town end;
    private Integer maxDistance;

    public CountMaxDistanceSearchProvider(Town start, Town end, Integer maxDistance, TownContainer container) {
        super(container);
        this.start = start;
        this.end = end;
        this.maxDistance = maxDistance;
    }


    @Override
    public Integer search() {
        int  startIdx = getIdxByTown(start);
        int endIdx = getIdxByTown(end);

        List<String> path = new ArrayList<>();
        path = execute(String.valueOf(startIdx),String.valueOf(endIdx),maxDistance,0,path);
        return path ==null?0:path.size();
    }


    public List<String> execute(String path, String end, int maxDistance, int pathVal, List<String> list) {
        int rowIdx = Integer.parseInt(path.substring(path.length() - 1));
        int[][] graphMatrix = getGraphMatrix();

        if (pathVal >= maxDistance) {
            return list;
        }
        if (pathVal > 0 && path.endsWith(end)) {
            list.add(path);
        }
        for (int i = 0; i < graphMatrix.length; i++) {
            int value = graphMatrix[rowIdx][i];
            if (value > 0) {
                execute(path + i, end, maxDistance,pathVal + value, list);
            }
        }
        return list;
    }
}
