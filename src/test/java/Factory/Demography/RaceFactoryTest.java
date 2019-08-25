package Factory.Demography;

import Domain.Demography.Race;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RaceFactoryTest {

    @Test
    public void buildRace() {
        Race race = RaceFactory.buildRace("Asian");
        Assert.assertNotNull(race);
    }
}