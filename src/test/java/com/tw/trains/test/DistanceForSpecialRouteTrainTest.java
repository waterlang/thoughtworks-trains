package com.tw.trains.test;

import com.tw.trains.BootStarpProperty;
import com.tw.trains.TownContainer;
import com.tw.trains.model.Town;
import com.tw.trains.provider.DistanceForSpecialRouteSearchProvicder;
import com.tw.trains.util.RouteBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.MissingResourceException;

public class DistanceForSpecialRouteTrainTest {

    private TownContainer container;


    @Before
    public void initDataFromProperty() throws IOException {
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
    public void shouldReturnEightDistanceForSpecialRouteTrainWhenStartAAndEndBAndPassB(){
        List<Town> listTown = RouteBuilder.buildSpecialRoute(Arrays.asList("A","B","C"));
        DistanceForSpecialRouteSearchProvicder provider = new DistanceForSpecialRouteSearchProvicder(listTown,container);
        String count =  provider.search();
        Assert.assertEquals(9,Long.parseLong(count));
    }

    @Test
    public void shouldReturnEightDistanceForSpecialRouteTrainWhenStartAAndEndD(){
        List<Town> listTown = RouteBuilder.buildSpecialRoute(Arrays.asList("A","D"));
        DistanceForSpecialRouteSearchProvicder provider = new DistanceForSpecialRouteSearchProvicder(listTown,container);
        String count =  provider.search();
        Assert.assertEquals(5,Long.parseLong(count));
    }

    @Test
    public void shouldReturnEightDistanceForSpecialRouteTrainWhenStartAAndEndCAndPassD(){
        List<Town> listTown = RouteBuilder.buildSpecialRoute(Arrays.asList("A","D","C"));
        DistanceForSpecialRouteSearchProvicder provider = new DistanceForSpecialRouteSearchProvicder(listTown,container);
        String count =  provider.search();
        Assert.assertEquals(13,Long.parseLong(count));
    }

    @Test
    public void shouldReturnEightDistanceForSpecialRouteTrainWhenStartAAndEndDAndPassEAndBAndC(){
        List<Town> listTown = RouteBuilder.buildSpecialRoute(Arrays.asList("A","E","B","C","D"));
        DistanceForSpecialRouteSearchProvicder provider = new DistanceForSpecialRouteSearchProvicder(listTown,container);
        String count =  provider.search();
        Assert.assertEquals(22,Long.parseLong(count));
    }


    @Test
    public void shouldReturnEightDistanceForSpecialRouteTrainWhenStartAAndEndDAndPassE(){
        List<Town> listTown = RouteBuilder.buildSpecialRoute(Arrays.asList("A","E","D"));
        DistanceForSpecialRouteSearchProvicder provider = new DistanceForSpecialRouteSearchProvicder(listTown,container);
        String count =  provider.search();
        Assert.assertEquals("NO SUCH ROUTE",count);
    }
}
