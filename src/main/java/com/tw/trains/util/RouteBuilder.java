package com.tw.trains.util;

import com.tw.trains.model.Town;
import java.util.ArrayList;
import java.util.List;

public class RouteBuilder {

    public  static List<Town> buildSpecialRoute(List<String> townIdList){
        if(townIdList == null){
            return  null;
        }
        List<Town> result = new ArrayList<>();
        townIdList.stream().forEach(
                k->{
                  Town town = new Town();
                  town.setIdentify(k);
                  result.add(town);
                }
        );
        return result;
    }

    public static Town buildTownInfo(String identify){
        if(StringUtil.isEmpty(identify)){
            return  null;
        }
        Town town = new Town();
        town.setIdentify(identify);
        return  town;
    }

}
