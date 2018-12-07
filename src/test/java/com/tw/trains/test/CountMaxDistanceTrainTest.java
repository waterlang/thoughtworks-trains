package com.tw.trains.test;

import com.tw.trains.BootStarpProperty;
import com.tw.trains.TownContainer;
import com.tw.trains.model.Town;
import com.tw.trains.provider.CountMaxDistanceSearchProvider;
import com.tw.trains.util.RouteBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.MissingResourceException;

public class CountMaxDistanceTrainTest {

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
    public void shouldReturnSevenCountMaxDistanceWhenStartCAndEndCAndMaxDistanceIsThirty(){
        Town town =  RouteBuilder.buildTownInfo("C");
        CountMaxDistanceSearchProvider provider = new CountMaxDistanceSearchProvider(town,town,30,container);
        Integer count =  provider.search();
        Assert.assertEquals(7,(long)count);
    }


}
