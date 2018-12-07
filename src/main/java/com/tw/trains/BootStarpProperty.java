package com.tw.trains;

import com.tw.trains.excpetion.PropertiesParseException;
import com.tw.trains.model.Town;
import com.tw.trains.model.TownRoute;
import com.tw.trains.util.StringUtil;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class BootStarpProperty {

    private TownContainer container = new TownContainer();

    public void init(String fileName) throws IOException {
        Locale defaultLocale = Locale.getDefault();
        ResourceBundle props = ResourceBundle.getBundle(fileName, defaultLocale);
        if(props == null || props.keySet() == null){
            throw new PropertiesParseException("cann't find any  data  form  properties file");
        }
        props.keySet().stream().forEach((k)->{
            addToTownContainer(k,props.getString(k));
        });
        container.graphToMatrix();
    }

    private  void addToTownContainer(String townIdentify,String distance){
        if(StringUtil.isEmpty(townIdentify) || townIdentify.length() != 2){
            throw  new PropertiesParseException("key is null or key error");
        }
        String startTownIdentify = townIdentify.substring(0,1);
        String toTownIdentify = townIdentify.substring(1,2);
        Town start = new Town();
        start.setIdentify(startTownIdentify);
        Town target =  new Town();
        target.setIdentify(toTownIdentify);
        TownRoute townEdge = new TownRoute(start,target,Integer.parseInt(distance));
        container.addTownRouteItem(start,townEdge);
    }


    public TownContainer getContainer() {
        return container;
    }
}
