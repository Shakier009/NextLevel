package Repository.Demography.Impl;

import Domain.Demography.Race;
import Factory.Demography.RaceFactory;
import Repository.Demography.RaceRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

public class RaceRepositoryImplTest {

    private RaceRepository repository;
    private Race race;

    private Race getSavedRace(){
        Set<Race> savedRaces = this.repository.getAll();
        return savedRaces.iterator().next();
    }

    @Before
    public void setUp() throws Exception{
        this.repository =  RaceRepositoryImpl.getRepository();
        this.race = RaceFactory.buildRace("Test");
    }

    @Test
    public void getAll() {
        Set<Race> all = this.repository.getAll();
        Assert.assertNotNull(all);
    }

    @Test
    public void create() {
        Race created = this.repository.create(this.race);
        getAll();
        Assert.assertSame(created, this.race);
    }

    @Test
    public void update() {
        String newName = "New Name";
        Race race = new Race.Builder().copy(getSavedRace()).raceName(newName).build();
        Race updated = this.repository.update(race);
        Assert.assertSame(newName, updated.getRaceName());
        getAll();
    }

    @Test
    public void read() {
        Race savedRace = getSavedRace();
        Race read = this.repository.read(savedRace.getRaceId());
        getAll();
        Assert.assertEquals(savedRace, read);
    }

    @Test
    public void delete() {
        Race savedRace = getSavedRace();
        this.repository.delete(savedRace.getRaceId());
        getAll();

        //Create another Race after deleting so that Read() has something to read.
        this.repository.create(this.race);
    }
}