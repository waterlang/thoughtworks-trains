package com.tw.trains.provider;

import com.tw.trains.TownContainer;
import com.tw.trains.model.Town;

import java.util.ArrayList;
import java.util.List;

public class CountExactStepSearchProvider extends BaseSearchProvider {

    private Town start;
    private Town end;
    private int exactStep;

    public CountExactStepSearchProvider(Town start, Town end, int exactStep, TownContainer container) {
        super(container);
        this.start = start;
        this.end = end;
        this.exactStep = exactStep;
    }


    @Override
    public Integer search() {
        int  startIdx = getIdxByTown(start);
        int endIdx = getIdxByTown(end);

        List<String> resultData = getExactRoutes(String.valueOf(startIdx),String.valueOf(endIdx),exactStep,new ArrayList<>());
        return resultData == null?0:resultData.size();
    }


    private List<String> getExactRoutes(String path, String end, int exactStep, List<String> list) {
        int rowIdx = Integer.parseInt( path.substring(path.length() - 1));
        int[][] map = this.getGraphMatrix();

        if (path.length() - 1 > exactStep) {
            return list;
        }
        if (path.length() == (exactStep+1) && path.endsWith(end)) {
            list.add(path);
        }
        for (int i = 0; i < map.length; i++) {
            if (map[rowIdx][i] > 0) {
                getExactRoutes( path + i,end, exactStep, list);
            }
        }
        return list;
    }
}
