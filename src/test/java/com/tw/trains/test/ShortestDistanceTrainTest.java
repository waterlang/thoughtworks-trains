package com.tw.trains.test;

import com.tw.trains.BootStarpProperty;
import com.tw.trains.TownContainer;
import com.tw.trains.model.Town;
import com.tw.trains.provider.ShortestDistanceSearchProvider;
import com.tw.trains.util.RouteBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.MissingResourceException;

/**
 * 两点之间最短路径
 */
public class ShortestDistanceTrainTest {

    private TownContainer container;


    @Before
    public void initData() throws IOException {
        BootStarpProperty property = new BootStarpProperty();
        property.init("townLine");
        container = property.getContainer();
    }

    @Test(expected =MissingResourceException.class )
    public void shouldThrowExceptionWhenReadNotExistProperties() throws IOException {
        BootStarpProperty property = new BootStarpProperty();
        property.init("bb");
    }

    @Test
    public void shouldReturnNineShortestDistanceWhenStartAAndEndC(){
        Town end =  RouteBuilder.buildTownInfo("C");
        Town start =  RouteBuilder.buildTownInfo("A");
        ShortestDistanceSearchProvider provider = new ShortestDistanceSearchProvider(start,end,container);
        Integer shortestDistance =provider.search();
        Assert.assertEquals(9,(long)shortestDistance);
    }

    @Test
    public void shouldReturnNineShortestDistanceWhenStartCAndEndC(){
        Town start =  RouteBuilder.buildTownInfo("C");
        Town end =  RouteBuilder.buildTownInfo("C");
        ShortestDistanceSearchProvider provider = new ShortestDistanceSearchProvider(start,end,container);
        Integer shortestDistance =provider.search();
        Assert.assertEquals(9,(long)shortestDistance);
    }



}
