package com.tw.trains.provider;

import com.tw.trains.TownContainer;
import com.tw.trains.model.Town;

import java.util.List;


public class DistanceForSpecialRouteSearchProvicder extends BaseSearchProvider {

    private List<Town> townRoutes;

    public DistanceForSpecialRouteSearchProvicder(List<Town> townRoutes, TownContainer container) {
        super(container);
        this.townRoutes = townRoutes;
    }

    @Override
    public String search() {
        Integer result = 0;
        int[][] map = this.getGraphMatrix();

        if(townRoutes != null){
            for (int i = 0; i < townRoutes.size() - 1; i++) {
                int rowIdx = getIdxByTown(townRoutes.get(i));
                int cloIdx =  getIdxByTown(townRoutes.get(i+1));
                int value = map[rowIdx][cloIdx];
                if(value > 0){
                    result += value;
                }else {
                    result = 0;
                    break;
                }
            }
        }
        if(result >0 ){
            return String.valueOf(result);
        }else {
            return "NO SUCH ROUTE";
        }
    }


}
