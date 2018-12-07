package com.tw.trains.test;

import com.tw.trains.model.Town;
import com.tw.trains.util.RouteBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class RouteBuilderTest {

    @Test
    public void shouldReturnNullBuildSpecialRouteWhenListIsNull(){
        List<Town> towns = RouteBuilder.buildSpecialRoute(null);
        Assert.assertEquals(null,towns);
    }

    @Test
    public void shouldReturnTownListSizeIsOneBuildSpecialRouteWhenListSizeIsOneAndIdentifyIsA(){
        List<Town> towns = RouteBuilder.buildSpecialRoute(Arrays.asList("A"));
        Town t = new Town();
        t.setIdentify("A");
        List<Town> result = Arrays.asList(t);
        Assert.assertEquals(result,towns);
    }


    @Test
    public void shouldReturnNullBuildSpecialRouteWhenIdentifyIsNull(){
        Town town = RouteBuilder.buildTownInfo(null);
        Assert.assertEquals(null,town);
    }

    @Test
    public void shouldReturnTownAndIdentifyIsABuildSpecialRouteWhenIdentifyIsNull(){
        Town town = RouteBuilder.buildTownInfo("A");
        Town t = new Town();
        t.setIdentify("A");
        Assert.assertEquals(t,town);
    }

}
