package com.boot;

import com.boot.controller.HomeController;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTest {

    @Test
    public void testApp() {
        HomeController homeController = new HomeController();
        assertEquals(homeController.home(), "Das Boot, reporting for duty!");
    }
}
