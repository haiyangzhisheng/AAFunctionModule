package com.aaagame.module.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 单元测试，在要测试的类中，右键go to选择test构建
 */
public class AADateTest {
    AADate aaDate;

    @Before
    public void setUp() throws Exception {
        aaDate = new AADate();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getCurrentTime() throws Exception {
        System.out.println(AADate.getCurrentTime(AADate.ymd_zh_Hm));
    }

    @Test
    public void getFormatTime() throws Exception {

    }

    @Test
    public void getTimeFromConvert() throws Exception {

    }

}