package com.tw.trains.provider;

import com.tw.trains.TownContainer;
import com.tw.trains.model.Town;

import java.util.ArrayList;
import java.util.List;


public class MaxStepSearchProvider extends BaseSearchProvider {
    private int maxStep;
    private Town start;
    private Town end;

    public MaxStepSearchProvider(Town start, Town end, int maxStep, TownContainer container){
        super(container);
        this.start = start;
        this.end = end;
        this.maxStep = maxStep;
    }

    @Override
    public Integer search() {
        int  startIdx = this.getIdxByTown(start);
        int endIdx =  this.getIdxByTown(end);

        List<String> choicePathList = new ArrayList<>();
        List<String> resultData  = execute(String.valueOf(startIdx),String.valueOf(endIdx),maxStep,choicePathList);
        return resultData == null?0:resultData.size();
    }

    public List<String> execute(String start, String path, int maxPath, List<String> list) {
        int rowIdx = Integer.parseInt( path.substring(path.length() - 1,path.length()));
        int[][] graphMatrix = getGraphMatrix();

        if (path.length() - 1 > maxPath) {
            return list;
        }
        if (path.length() > 1 && path.endsWith(start)) {
            list.add(path);
        }
        for (int i = 0; i < graphMatrix.length; i++) {
            if (graphMatrix[rowIdx][i] > 0) {
                execute(start, path + i, maxPath, list);
            }
        }
        return list;
    }

}
