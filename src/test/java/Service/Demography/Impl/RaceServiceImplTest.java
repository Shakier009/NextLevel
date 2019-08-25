package Service.Demography.Impl;

import Domain.Demography.Race;
import Factory.Demography.RaceFactory;
import Service.Demography.RaceService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class RaceServiceImplTest {

    private RaceService service;
    private Race race;

    private Race getSavedRace(){
        Set<Race> savedRaces = this.service.getAll();
        return savedRaces.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.service = RaceServiceImpl.getService();
        this.race = RaceFactory.buildRace("Test Race");
    }

    @Test
    public void create() {

        Race testCreate = this.service.create(this.race);
        Assert.assertSame(testCreate, this.race);

    }

    @Test
    public void update() {
        String newRaceName = "Application Development Theory 3";
        Race updated = new Race.Builder().copy(getSavedRace()).raceName(newRaceName).build();
        this.service.update(updated);
        Assert.assertSame(newRaceName, updated.getRaceName());
    }

    @Test
    public void delete() {
        int startingSize = this.service.getAll().size();
        Race savedRace = getSavedRace();
        this.service.delete(savedRace.getRaceId());

        Assert.assertEquals(startingSize-1,this.service.getAll().size());

        //Create another race after deleting so that Read() has something to read.
        this.service.create(this.race);
    }

    @Test
    public void read() {
        Race savedRace = getSavedRace();
        String id = savedRace.getRaceId();
        Race readRace = this.service.read(id);
        Assert.assertEquals(savedRace, readRace);
    }

    @Test
    public void getAll() {
        Set<Race> all = this.service.getAll();
        Assert.assertNotNull(all);
    }
}