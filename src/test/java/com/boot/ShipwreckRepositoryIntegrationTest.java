package com.boot;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ShipwreckRepositoryIntegrationTest {

    @Autowired
    private ShipwreckRepository shipwreckRepository;

    @Test
    public void testFindAll() {
        List<Shipwreck> shipwreckList = shipwreckRepository.findAll();
        assertThat(shipwreckList.size(), Matchers.is(greaterThanOrEqualTo(0)));

        Shipwreck shipwreck = new Shipwreck(1L, "HAMARA BAJAJ", "This is the Test for creation of Shipwreck", "50 Year Old", 50, 19.5, 20.22, 1994);
        shipwreckRepository.saveAndFlush(shipwreck);
        shipwreckList = shipwreckRepository.findAll();
        assertThat(shipwreckList.size(), Matchers.is(greaterThanOrEqualTo(1)));
    }
}
