package com.tw.trains.test;

import com.tw.trains.util.StringUtil;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest {

    @Test
    public void shouldReturnTrueStringIsEmptyWhenStringIsNull(){
        String str = null;
        boolean strIsEmpty =StringUtil.isEmpty(str);
        Assert.assertEquals(true,strIsEmpty);
    }

    @Test
    public void shouldReturnFalseStringIsEmptyWhenStringIsOne(){
        String str = "One";
        boolean strIsEmpty =StringUtil.isEmpty(str);
        Assert.assertEquals(false,strIsEmpty);
    }


}
