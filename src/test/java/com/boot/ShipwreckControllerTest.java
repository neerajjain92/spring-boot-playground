package com.boot;

import com.boot.controller.ShipwreckController;
import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ShipwreckControllerTest {

    @InjectMocks
    private ShipwreckController shipwreckController;

    @Mock
    private ShipwreckRepository shipwreckRepository;


    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testShipwreckGet() {
        Shipwreck shipwreck = new Shipwreck();
        shipwreck.setId(1L);
        when(shipwreckRepository.findOne(1L)).thenReturn(shipwreck);

        Shipwreck wreck = shipwreckController.getShipwreck(1L);

        verify(shipwreckRepository).findOne(1L);

        assertEquals(1L, wreck.getId().longValue());

        // Now How Hamcrest is different
        assertThat(wreck.getId(), is(1L));
    }

    @Test
    public void testShipwreckGetALL() {
        List<Shipwreck> shipwrecks = Arrays.asList(new Shipwreck(1L), new Shipwreck(2L), new Shipwreck(3L));

        when(shipwreckRepository.findAll()).thenReturn(shipwrecks);

        List<Shipwreck> expectedResult = shipwreckController.list();

        assertEquals(3, expectedResult.size());
    }

    @Test
    public void testShipwreckCreate() {
        Shipwreck shipwreck = new Shipwreck(1L, "HAMARA BAJAJ", "This is the Test for creation of Shipwreck", "50 Year Old", 50, 19.5, 20.22, 1994);

        when(shipwreckRepository.saveAndFlush(shipwreck)).thenReturn(shipwreck);

        assertEquals("HAMARA BAJAJ", shipwreckController.create(shipwreck).getName());
    }
}
